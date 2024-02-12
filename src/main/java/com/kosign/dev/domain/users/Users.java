package com.kosign.dev.domain.users;

import com.kosign.dev.domain.bookmark.BookMark;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private String role;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @OneToMany(mappedBy = "users")
    private List<BookMark> bookmarks;
    @Builder
    public Users(UUID id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
