package com.kosign.dev.payload.article;

import com.kosign.dev.domain.article.Article;
import com.kosign.dev.domain.article.ArticleRepository;
import com.kosign.dev.domain.bookmark.BookMark;
import com.kosign.dev.domain.category.Categories;
import com.kosign.dev.domain.photos.PhotoEntity;
import com.kosign.dev.domain.users.Users;
import com.kosign.dev.payload.category.CategoryResponse;
import com.kosign.dev.payload.photo.PhotoResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private UUID id;
    private String title;
    private String description;
    private Boolean published;
    private Users user;
    private List<PhotoEntity> photo;
    List<CategoryResponse> categories;
//    private List<BookMark> bookMarks;
}
