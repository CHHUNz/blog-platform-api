package com.kosign.dev.service.auth;

import com.kosign.dev.payload.auth.AuthRequest;
import com.kosign.dev.payload.auth.RegisterRequest;

public interface AuthService {
    Object login(AuthRequest payload) throws Throwable;

    void register(RegisterRequest payload) throws Throwable;

}
