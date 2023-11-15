package com.ecommer.springbootapi.dto.request;

import com.ecommer.springbootapi.entities.Category;

import java.util.Set;

public class CategoryRequestDto {
    private Long id;
    private String title;
    private String keywords;
    private String description;
    private String status;
    private Set<Category> children;
}
