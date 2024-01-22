package com.kosign.dev.controller;

import com.kosign.dev.domain.category.CategoryRepository;
import com.kosign.dev.payload.category.CategoryRequest;
import com.kosign.dev.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController extends AbstractRestController{
    private final CategoryService categoryService;

    @PostMapping("/create")
    public Object createCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.createCategory(categoryRequest);
        return ok();
    }

    @GetMapping("")
    public Object getCategories(){
        return ok(categoryService.getCategories());
    }

    @PutMapping("/update/{id}")
    public Object updateCategory(@RequestBody CategoryRequest categoryRequest, @PathVariable("id") UUID id){
        categoryService.updateCategory(categoryRequest, id);
        return ok();
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteCategory(@PathVariable("id") UUID id){
        categoryService.deleteCategory(id);
        return ok();
    }
}
