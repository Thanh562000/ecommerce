package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.CategoryDto;
import com.ecommer.springbootapi.dto.response.CommonResponse;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CommonResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir);

    CategoryDto getCategoryById(Long categoryId);

    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

    void deleteCategory(Long categoryId);
}
