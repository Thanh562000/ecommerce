package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.CategoryRequestDto;
import com.ecommer.springbootapi.dto.response.CategoryResponse;
import com.ecommer.springbootapi.entities.Category;
import com.ecommer.springbootapi.exception.ResourceNotFoundException;
import com.ecommer.springbootapi.repository.CategoryRepository;
import com.ecommer.springbootapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public CategoryRequestDto createCategory(CategoryRequestDto categoryRequestDto) {
        return null;
    }

    @Override
    public CategoryResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public CategoryRequestDto getCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public CategoryRequestDto updateCategory(CategoryRequestDto categoryRequestDto, Long categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
        categoryRepository.delete(category);
    }
}
