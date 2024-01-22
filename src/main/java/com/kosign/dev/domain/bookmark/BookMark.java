package com.kosign.dev.domain.bookmark;

import com.kosign.dev.domain.article.Article;
import com.kosign.dev.domain.users.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_bookmark")
public class BookMark {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bookmark_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

}
