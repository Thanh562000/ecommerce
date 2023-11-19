package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.ProductDto;
import com.ecommer.springbootapi.dto.response.CommonResponse;
import com.ecommer.springbootapi.entities.Category;
import com.ecommer.springbootapi.entities.Product;
import com.ecommer.springbootapi.exception.ApiException;
import com.ecommer.springbootapi.exception.ResourceNotFoundException;
import com.ecommer.springbootapi.repository.CategoryRepository;
import com.ecommer.springbootapi.repository.ProductRepository;
import com.ecommer.springbootapi.service.CommonService;
import com.ecommer.springbootapi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommonService commonService;


    @Override
    public ProductDto createProduct(ProductDto productDto, MultipartFile multipartFile) {
        productDto.setImage(uploadProductImage(multipartFile));
        Product product = mapToEntity(productDto);
        Product createProduct = productRepository.save(product);
        return mapToDto(createProduct);
    }

    @Override
    public CommonResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> products = productRepository.findAll(pageable);

        List<Product> list = products.getContent();

        List<ProductDto> productList = list.stream()
                .map(v -> mapToDto(v))
                .toList();

        return commonService.getResponseContent(products, productList);
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", id));
        return mapToDto(product);
    }

    @Override
    public ProductDto update(Long categoryId, ProductDto productDto, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", productId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));


        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setKeywords(productDto.getKeywords());
        product.setPrice(productDto.getPrice());
        product.setDetail(productDto.getDetail());
        product.setQuantity(productDto.getQuantity());
        product.setStatus(productDto.getStatus());
        product.setCategory(category);

        Product update = productRepository.save(product);

        return mapToDto(update);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", id));
        productRepository.delete(product);

    }

    @Override
    public ProductDto saveProductByCategory(Long categoryId, ProductDto productDto) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));

        Product product = mapToEntity(productDto);

        product.setCategory(category);
        Product create = productRepository.save(product);

        return mapToDto(create);
    }

    @Override
    public List<ProductDto> searchProduct(String query) {
        List<Product> products = productRepository.searchProduct(query);

        if (products.size() == 0) {
            throw new ApiException("Product not found", HttpStatus.BAD_REQUEST);

        }
        return products.stream().map(v -> mapToDto(v)).toList();
    }

    private String uploadProductImage(MultipartFile file) {
        ProductDto productDto = new ProductDto();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains("..")) {
            logger.error("In valid file");
        }
        try {
            productDto.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        return productDto.getImage();
    }

    private ProductDto mapToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product mapToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
