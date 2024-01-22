package com.kosign.dev.service.category;

import com.kosign.dev.domain.category.CategoryRepository;
import com.kosign.dev.exception.CusNotFoundException;
import com.kosign.dev.payload.category.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(CategoryRequest payload) {
        var entity = categoryMapper.mapToEntity(payload);
        categoryRepository.save(entity);
    }

    @Override
    public Object getCategories() {
        var categoryList = categoryRepository.findAllCategories();
        return categoryList.stream().map(categoryMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateCategory(CategoryRequest categoryRequest, UUID id) {
         var category = categoryRepository.updateById(id)
                .orElseThrow(() -> new CusNotFoundException("Category is not found"));
         category.setName(categoryRequest.name());
    }

    @Override
    public void deleteCategory(UUID id) {
        var deleteCategory = categoryRepository.updateById(id)
                .orElseThrow(()-> new CusNotFoundException("Category is not found"));
        categoryRepository.deleteCategoriesById(deleteCategory.getId());
    }


}
