package com.kosign.dev.payload.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
public class UserResponse {
    private UUID id;
    private String username;
    private String role;

    public UserResponse(UUID id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }
}
