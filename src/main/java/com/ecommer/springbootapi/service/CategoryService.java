package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.CategoryRequestDto;
import com.ecommer.springbootapi.dto.response.CategoryResponse;

public interface CategoryService {
    CategoryRequestDto createCategory(CategoryRequestDto categoryRequestDto);

    CategoryResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir);

    CategoryRequestDto getCategoryById(Long categoryId);

    CategoryRequestDto updateCategory(CategoryRequestDto categoryRequestDto, Long categoryId);

    void deleteCategory(Long categoryId);
}
