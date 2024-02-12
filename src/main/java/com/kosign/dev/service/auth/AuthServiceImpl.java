package com.kosign.dev.service.auth;

import com.kosign.dev.common.api.StatusCode;
import com.kosign.dev.payload.auth.AuthRequest;
import com.kosign.dev.payload.auth.AuthResponse;
import com.kosign.dev.payload.auth.RegisterRequest;
import com.kosign.dev.payload.auth.SecurityUser;
import com.kosign.dev.domain.users.UserRepository;
import com.kosign.dev.domain.users.Users;
import com.kosign.dev.exception.BusinessException;
import com.kosign.dev.global.component.UserAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final UserAuthenticationProvider authProvider;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Object login(AuthRequest payload) throws Throwable {
        // Perform authentication
        Authentication authenticate = authProvider.authenticate(payload.username(), payload.password());

        SecurityUser securityUser = (SecurityUser) authenticate.getPrincipal();
        // Set the authenticated user in the SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        // Generate JWT token
        String token = tokenService.generateToken(securityUser);

        // Return the token in the response
        return new AuthResponse(token, "Bearer", tokenService.getExpireIn());
    }

    @Override
    public void register(RegisterRequest payload) throws Throwable {
        var userId = userRepository.findUsersById(payload.id());
        if (userId.isPresent()){
            throw new BusinessException(StatusCode.USER_ID_EXIST);
        }
        String rawPassword;
        try {
            rawPassword = passwordEncoder.encode(payload.password());
        } catch (Exception e){
            throw new BusinessException(StatusCode.PASSWORD_MUST_BE_ENCRYPTED);
        }

        var user = Users.builder()
                .username(payload.username())
                .password(rawPassword)
                .role(payload.role())
                .build();
        userRepository.save(user);
    }
}
