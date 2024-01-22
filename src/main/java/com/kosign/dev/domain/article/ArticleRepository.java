package com.kosign.dev.domain.article;

import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<Article, UUID> {

    @Query("select a from Article a order by a.title asc")
    List<Article> findAllArticles();

    @Transactional
    @Modifying
    @Query("delete from Article a where a.id = :id")
    void deleteArticleById(UUID id);
}
