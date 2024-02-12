package com.kosign.dev.controller;

import com.kosign.dev.payload.auth.AuthRequest;
import com.kosign.dev.payload.auth.RegisterRequest;
import com.kosign.dev.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class AuthController extends AbstractRestController {
    private final AuthService authService;
    @PostMapping("/register")
    public Object signup(@RequestBody @Valid RegisterRequest payload) throws Throwable {
        authService.register(payload);
        return ok();
    }

    @PostMapping("/login")
    public Object login(@RequestBody @Valid AuthRequest payload) throws Throwable {
        return ok(authService.login(payload));
    }
}
