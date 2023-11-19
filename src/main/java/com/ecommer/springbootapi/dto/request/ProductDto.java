package com.ecommer.springbootapi.dto.request;

import com.ecommer.springbootapi.entities.Comment;
import com.ecommer.springbootapi.entities.ImageData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties({"hibernate_lazy_initializer", "handler"})
public class ProductDto {
    private Long id;
    private String title;
    private String keywords;
    private String description;
    private String detail;
    private double price;
    private Integer quantity;
    private String status;
    private String image;
    private CategoryDto category;
    private Set<ImageDataDto> images = new HashSet<>();
    private Set<CommentDto> comments = new HashSet<>();
}
