package com.kosign.dev.payload.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AuthRequest(
        @NotBlank
        @Size(max = 150)
        String username,
        @NotBlank
        @Size(max = 20)
        String password

) {
}
