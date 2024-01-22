package com.kosign.dev.service.article;

import com.kosign.dev.payload.article.ArticleRequest;

import java.util.UUID;

public interface ArticleService {
    void createArticle(ArticleRequest articleRequest);
    Object getArticle();
    void deleteArticle(UUID id);

    void updateArticle(ArticleRequest articleRequest, UUID id);
}
