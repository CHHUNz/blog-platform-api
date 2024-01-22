package com.kosign.dev.service.category;

import com.kosign.dev.payload.category.CategoryRequest;

import java.util.UUID;

public interface CategoryService {
    void createCategory(CategoryRequest payload);
    Object getCategories();
    void updateCategory(CategoryRequest categoryRequest, UUID id);
    void deleteCategory(UUID id);
}
