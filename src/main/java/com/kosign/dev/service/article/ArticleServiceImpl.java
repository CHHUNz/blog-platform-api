package com.kosign.dev.service.article;

import com.kosign.dev.domain.article.ArticleRepository;
import com.kosign.dev.domain.category.Categories;
import com.kosign.dev.domain.category.CategoryRepository;
import com.kosign.dev.domain.photos.PhotoEntity;
import com.kosign.dev.domain.users.UserRepository;
import com.kosign.dev.domain.users.Users;
import com.kosign.dev.exception.CusNotFoundException;
import com.kosign.dev.payload.article.ArticleRequest;
import com.kosign.dev.payload.category.CategoryRequest;
import com.kosign.dev.domain.photos.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;
    @Override
    public void createArticle(ArticleRequest articleRequest) {

        Users users = userRepository.findUsersById(articleRequest.userId()).orElseThrow(()-> new CusNotFoundException("User not found"));
        List<Categories> categories = categoryRepository.findAllCategories();
        for (CategoryRequest categoryRequest : articleRequest.categories()){
            Categories category = categoryRepository.findByName(categoryRequest.name()).orElseThrow(()-> new CusNotFoundException("Category is not found"));
            categories.add(category);
        }
        var entity = articleMapper.mapToEntity(articleRequest, users, categories);
        articleRepository.save(entity);
        PhotoEntity photo1 = new PhotoEntity();
        for (PhotoEntity photo : articleRequest.photos()) {
            photo1.setPhoto(photo.getPhoto());
            photo1.setArticle(articleRepository.save(entity));
            photoRepository.save(photo1);
        }

    }

    @Override
    public Object getArticle() {
        var articles = articleRepository.findAll();
        return articles.stream()
                .map(articleMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(UUID id) {
        var article = articleRepository.findById(id)
                .orElseThrow(()-> new CusNotFoundException("Article is not found"));
        articleRepository.deleteArticleById(article.getId());
    }

    @Override
    public void updateArticle(ArticleRequest articleRequest, UUID id) {
        var article = articleRepository.findById(id)
                .orElseThrow(()-> new CusNotFoundException("Article is not found"));
        List<Categories> categories = categoryRepository.findAllCategories();
        for (CategoryRequest categoryRequest : articleRequest.categories()){
            Categories category = categoryRepository.findByName(categoryRequest.name()).orElseThrow(()-> new CusNotFoundException("Category is not found"));
            categories.add(category);
        }
        Users users = userRepository.findUsersById(articleRequest.userId()).orElseThrow(()-> new CusNotFoundException("User not found"));
        article.setTitle(articleRequest.title());
        article.setDescription(articleRequest.description());
        article.setCategories(categories);
        article.setPublished(articleRequest.published());
        article.setUser(users);
        articleRepository.save(article);
//        PhotoEntity photos = new PhotoEntity();
//        for (PhotoEntity photo : articleRequest.photos()) {
//            photos.setPhoto(photo.getPhoto());
//            photos.setArticle(articleRepository.save(article));
//            photoRepository.save(photos);
//        }
    }
}
