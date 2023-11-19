package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.ProductDto;
import com.ecommer.springbootapi.dto.response.CommonResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto, MultipartFile multipartFile);

    CommonResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir);

    ProductDto getById(Long id);

    ProductDto update(Long categoryId, ProductDto productDto, Long productId);

    void delete(Long id);

    ProductDto saveProductByCategory(Long categoryId, ProductDto productDto);

    List<ProductDto> searchProduct(String query);
}
