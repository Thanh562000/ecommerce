package com.ecommer.springbootapi.controller;

import com.ecommer.springbootapi.dto.request.ProductDto;
import com.ecommer.springbootapi.dto.response.CommonResponse;
import com.ecommer.springbootapi.service.ProductService;
import com.ecommer.springbootapi.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProductDto> createProduct(@RequestPart("productDto") ProductDto productDto, @RequestPart("file") MultipartFile file) {
        ProductDto responseProduct = productService.createProduct(productDto, file);
        return new ResponseEntity<>(responseProduct, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public CommonResponse getAll(@RequestParam(value = "pageNo", defaultValue = Constant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = Constant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                 @RequestParam(value = "sortBy", defaultValue = Constant.DEFAULT_SORT_BY, required = false) String sortBy,
                                 @RequestParam(value = "sortDir", defaultValue = Constant.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return productService.getAll(pageNo, pageSize, sortBy, sortDir);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        ProductDto productDto = productService.getById(id);
        return ResponseEntity.ok(productDto);
    }

    @PostMapping("/{categoryId}/saveProductByCategory")
    public ResponseEntity<ProductDto> saveProductByCategoryId(@PathVariable Long categoryId,
                                                              @RequestBody ProductDto productDto
    ) {
        ProductDto responseProduct = productService.saveProductByCategory(categoryId, productDto);
        return new ResponseEntity<>(responseProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}/update/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long categoryId,
                                                    @RequestBody ProductDto productDto,
                                                    @PathVariable Long productId
    ) {
        ProductDto responseProduct = productService.update(categoryId, productDto, productId);
        return ResponseEntity.ok(responseProduct);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> delete(@PathVariable Long productId) {
        productService.delete(productId);
        return new ResponseEntity<>("Product with id" + productId + "is delete success", HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<ProductDto> search(@RequestParam(value = "query") String query) {
        return productService.searchProduct(query);
    }
}
