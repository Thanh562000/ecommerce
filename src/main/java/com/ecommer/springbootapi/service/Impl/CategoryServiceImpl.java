package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.CategoryRequest;
import com.ecommer.springbootapi.dto.response.CategoryResponse;
import com.ecommer.springbootapi.dto.response.CommonResponse;
import com.ecommer.springbootapi.entities.Category;
import com.ecommer.springbootapi.exception.ResourceNotFoundException;
import com.ecommer.springbootapi.repository.CategoryRepository;
import com.ecommer.springbootapi.service.CategoryService;
import com.ecommer.springbootapi.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CommonService commonService;

    @Override
    public CategoryRequest createCategory(CategoryRequest categoryRequest) {
        //convert dto -> entity
        Category category = convertToEntity(categoryRequest);
        //save entity
        Category cate = categoryRepository.save(category);
        //convert entity -> dto
        return convertToDto(cate);
    }

    @Override
    public CommonResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Category> categories = categoryRepository.findAll(pageable);

        List<Category> categoryList = categories.getContent();
        List<CategoryRequest> categoryRequestList = categoryList.stream()
                .map(category -> convertToDto(category))
                .toList();

        CommonResponse categoryResponse = commonService.getResponseContent(categories, categoryRequestList);
        return categoryResponse;
    }

    @Override
    public CategoryRequest getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
        return convertToDto(category);
    }

    @Override
    public CategoryRequest updateCategory(CategoryRequest categoryRequest, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
        category.setTitle(categoryRequest.getTitle());
        category.setDescription(categoryRequest.getDescription());
        category.setKeywords(categoryRequest.getKeywords());
        category.setStatus(categoryRequest.getStatus());
        Category updateCategory = categoryRepository.save(category);

        CategoryRequest request = convertToDto(updateCategory);
        return request;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
        categoryRepository.delete(category);
    }

    public Category convertToEntity(CategoryRequest requestDto) {
        Category category = new Category();
        category.setDescription(requestDto.getDescription());
        category.setId(requestDto.getId());
        category.setStatus(requestDto.getStatus());
        category.setTitle(requestDto.getTitle());
        category.setKeywords(requestDto.getKeywords());
        category.setChildren(requestDto.getChildren());
        return category;
    }

    public CategoryRequest convertToDto(Category category) {
        CategoryRequest requestDto = new CategoryRequest();
        requestDto.setId(category.getId());
        requestDto.setTitle(category.getTitle());
        requestDto.setKeywords(category.getKeywords());
        requestDto.setDescription(category.getDescription());
        requestDto.setChildren(category.getChildren());
        return requestDto;
    }
}
