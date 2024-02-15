package com.ecommer.springbootapi.dto.request;

import com.ecommer.springbootapi.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private String keywords;
    private String description;
    private String status;
    private Set<Category> children;
}
