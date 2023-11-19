package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.CategoryDto;
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
    public CategoryDto createCategory(CategoryDto categoryDto) {
        //convert dto -> entity
        Category category = convertToEntity(categoryDto);
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
        List<CategoryDto> categoryDtoList = categoryList.stream()
                .map(category -> convertToDto(category))
                .toList();

        return commonService.getResponseContent(categories, categoryDtoList);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
        return convertToDto(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        category.setKeywords(categoryDto.getKeywords());
        category.setStatus(categoryDto.getStatus());
        Category updateCategory = categoryRepository.save(category);

        return convertToDto(updateCategory);

    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
        categoryRepository.delete(category);
    }

    public Category convertToEntity(CategoryDto requestDto) {
        Category category = new Category();
        category.setDescription(requestDto.getDescription());
        category.setId(requestDto.getId());
        category.setStatus(requestDto.getStatus());
        category.setTitle(requestDto.getTitle());
        category.setKeywords(requestDto.getKeywords());
        category.setChildren(requestDto.getChildren());
        return category;
    }

    public CategoryDto convertToDto(Category category) {
        CategoryDto requestDto = new CategoryDto();
        requestDto.setId(category.getId());
        requestDto.setTitle(category.getTitle());
        requestDto.setKeywords(category.getKeywords());
        requestDto.setDescription(category.getDescription());
        requestDto.setChildren(category.getChildren());
        return requestDto;
    }
}
