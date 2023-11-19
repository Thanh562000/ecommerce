package com.ecommer.springbootapi.controller;

import com.ecommer.springbootapi.dto.request.CategoryDto;
import com.ecommer.springbootapi.dto.response.CommonResponse;
import com.ecommer.springbootapi.service.CategoryService;
import com.ecommer.springbootapi.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category with id: " + id + " is delete successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
        CategoryDto request = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public CommonResponse getAll(@RequestParam(value = "pageNo", defaultValue = Constant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = Constant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                 @RequestParam(value = "sortBy", defaultValue = Constant.DEFAULT_SORT_BY, required = false) String sortBy,
                                 @RequestParam(value = "sortDir", defaultValue = Constant.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        CommonResponse response = categoryService.getAllCategory(pageNo, pageSize, sortBy, sortDir);
        return response;
    }
}
