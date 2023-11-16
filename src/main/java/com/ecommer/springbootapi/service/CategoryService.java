package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.CategoryRequest;
import com.ecommer.springbootapi.dto.response.CategoryResponse;
import com.ecommer.springbootapi.dto.response.CommonResponse;

public interface CategoryService {
    CategoryRequest createCategory(CategoryRequest categoryRequest);

    CommonResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir);

    CategoryRequest getCategoryById(Long categoryId);

    CategoryRequest updateCategory(CategoryRequest categoryRequest, Long categoryId);

    void deleteCategory(Long categoryId);
}
