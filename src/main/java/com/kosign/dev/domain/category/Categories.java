package com.kosign.dev.domain.category;

import com.kosign.dev.domain.article.Article;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id")
    private UUID id;

    @Column(name = "category_name", unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Article> article;

    @Builder
    public Categories(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
