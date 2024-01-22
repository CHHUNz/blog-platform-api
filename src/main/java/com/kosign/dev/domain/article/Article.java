package com.kosign.dev.domain.article;

import com.kosign.dev.domain.bookmark.BookMark;
import com.kosign.dev.domain.category.Categories;
import com.kosign.dev.domain.comment.Comment;
import com.kosign.dev.domain.photos.PhotoEntity;
import com.kosign.dev.domain.users.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_article")

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "article_id")
    private UUID id;

    @Column(name = "article_title")
    private String title;

    @Column(name = "article_description")
    private String description;

    @Column(name = "article_publish")
    private Boolean published;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "article_categories",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Categories> categories;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<PhotoEntity> photos;

    @OneToMany(mappedBy = "article")
    private List<BookMark> bookMarks;

    @OneToMany(mappedBy = "articles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();

    @Builder
    public Article(UUID id, String title, String description, Boolean published, Users user, List<Categories> categories){
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
        this.user = user;
        this.categories = categories;
    }

}
