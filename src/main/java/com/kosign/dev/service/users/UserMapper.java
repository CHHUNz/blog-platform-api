package com.kosign.dev.service.users;

import com.kosign.dev.domain.users.UserRepository;
import com.kosign.dev.domain.users.Users;
import com.kosign.dev.payload.users.UserRequest;
import com.kosign.dev.payload.users.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final UserRepository userRepository;

    public Users mapToEntity(UserRequest payload){
        return Users.builder()
                .username(payload.username())
                .role(payload.role())
                .password(payload.password())
                .build();
    }

    public UserResponse mapToResponse(Users users){
        return UserResponse.builder()
                .id(users.getId())
                .username(users.getUsername())
                .role(users.getRole())
                .build();

    }
}
