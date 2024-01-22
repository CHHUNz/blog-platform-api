package com.kosign.dev.payload.article;

import com.kosign.dev.domain.category.Categories;
import com.kosign.dev.domain.photos.PhotoEntity;
import com.kosign.dev.domain.users.Users;
import com.kosign.dev.payload.category.CategoryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

public record ArticleRequest(
        String title,
        String description,
        boolean published,
        List<CategoryRequest> categories,
        UUID userId,
        List<PhotoEntity> photos
) {

}
