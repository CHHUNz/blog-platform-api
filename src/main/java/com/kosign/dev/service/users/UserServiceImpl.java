package com.kosign.dev.service.users;

import com.kosign.dev.domain.users.UserRepository;
import com.kosign.dev.exception.CusNotFoundException;
import com.kosign.dev.payload.users.UserRequest;
import com.kosign.dev.payload.users.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public void CreateUser(UserRequest payload) {
        var entity = userMapper.mapToEntity(payload);
        userRepository.save(entity);
    }

    @Override
    public Object getUsers() {
        var userList = userRepository.findAllUserOrderByUsername();
        return userList.stream()
                .map(userMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUsers(UserRequest payload, UUID id) {
        var updateUser = userRepository.findUsersById(id).orElseThrow(()-> new CusNotFoundException("User is not found"));
        updateUser.setUsername(payload.username());
        updateUser.setPassword(payload.password());
        updateUser.setRole(payload.role());
        userRepository.save(updateUser);
    }

    @Override
    public Object getUserById(UUID id) {
        return userRepository.findUsersById(id).
                map(userMapper::mapToResponse)
                .orElseThrow(()-> new CusNotFoundException("User is not found"));
    }

    @Override
    public void deleteUser(UUID id) {
        var deleteUser = userRepository.findUsersById(id)
                .orElseThrow(()-> new CusNotFoundException("User is not found"));
        userRepository.deleteById(deleteUser.getId());
    }
}
