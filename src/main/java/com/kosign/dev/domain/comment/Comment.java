package com.kosign.dev.domain.comment;

import com.kosign.dev.domain.article.Article;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "comment_id")
    private UUID commentId;

    @Column(name = "comment_caption")
    private String comment_caption;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articles;
}
