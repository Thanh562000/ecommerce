package com.ecommer.springbootapi.controller;

import com.ecommer.springbootapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
