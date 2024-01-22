package com.kosign.dev.domain.photos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kosign.dev.domain.article.Article;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "photo_tb")
@Data
@NoArgsConstructor
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @Column(name = "photo", nullable = false)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonIgnore
    private Article article;

    @Builder
    public PhotoEntity(String photo) {
        this.photo = photo;
    }
}
