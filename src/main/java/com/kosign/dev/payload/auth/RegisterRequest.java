package com.kosign.dev.payload.auth;

import java.util.UUID;

public record RegisterRequest(
        UUID id,
        String username,
        String password,
        String role
) {
}
