package com.kosign.dev.service.article;

import com.kosign.dev.domain.article.Article;
import com.kosign.dev.domain.category.Categories;
import com.kosign.dev.domain.category.CategoryRepository;
import com.kosign.dev.domain.photos.PhotoEntity;
import com.kosign.dev.domain.photos.PhotoRepository;
import com.kosign.dev.domain.users.Users;
import com.kosign.dev.payload.article.ArticleRequest;
import com.kosign.dev.payload.article.ArticleResponse;
import com.kosign.dev.payload.category.CategoryResponse;
import com.kosign.dev.payload.photo.PhotoResponse;
import com.kosign.dev.service.category.CategoryMapper;
import com.kosign.dev.service.photos.PhotosMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ArticleMapper {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;

    public Article mapToEntity(ArticleRequest payload, Users users, List<Categories> categories){
        return Article.builder()
                .title(payload.title())
                .description(payload.description())
                .published(payload.published())
                .categories(new ArrayList<>(categories))
                .user(users)
                .build();
    }
    public ArticleResponse mapToResponse(Article article){
        var articleResponses = categoryRepository.findAllCategories();
        List<CategoryResponse> responses = articleResponses.stream().map(categoryMapper::mapToResponse).toList();
        var photos = photoRepository.findAll();

        List<String> photosList = photos.stream().map(PhotoEntity::getPhoto).collect(Collectors.toList());
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .published(article.getPublished())
                .categories(responses)
                .photo(photosList)
                .user(article.getUser())
                .build();
    }
}
