package com.kosign.dev.service.category;

import com.kosign.dev.domain.category.Categories;
import com.kosign.dev.domain.category.CategoryRepository;
import com.kosign.dev.payload.category.CategoryRequest;
import com.kosign.dev.payload.category.CategoryResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Builder
public class CategoryMapper {
    private final CategoryRepository categoryRepository;

    public Categories mapToEntity(CategoryRequest payload){
        return Categories.builder()
                .name(payload.name())
                .build();
    }

    public CategoryResponse mapToResponse(Categories payload){
        return CategoryResponse.builder()
                .id(payload.getId())
                .name(payload.getName())
                .build();
    }
}
