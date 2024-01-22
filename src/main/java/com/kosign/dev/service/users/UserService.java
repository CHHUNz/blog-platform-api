package com.kosign.dev.service.users;

import com.kosign.dev.domain.users.Users;
import com.kosign.dev.payload.users.UserRequest;

import java.util.UUID;

public interface UserService {
    void CreateUser(UserRequest payload);
    Object getUsers();
    void updateUsers(UserRequest payload, UUID id);

    Object getUserById(UUID id);

    void deleteUser(UUID id);
}
