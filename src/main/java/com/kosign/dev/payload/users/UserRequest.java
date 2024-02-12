package com.kosign.dev.payload.users;

public record UserRequest(String username,String password, String email ,String role) {
}
