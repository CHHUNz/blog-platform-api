package com.kosign.dev.controller;

import com.kosign.dev.payload.users.UserRequest;
import com.kosign.dev.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController extends AbstractRestController {
    private final UserService userService;

    @PostMapping("/create")
    public Object createUser(@RequestBody UserRequest payload){
        userService.CreateUser(payload);
        return ok();
    }

    @GetMapping("")
    public Object getUsers(){
        return ok(userService.getUsers());
    }
    @PutMapping("/update/{id}")
    public Object updateUser(@RequestBody UserRequest payload, @PathVariable("id") UUID id){
        userService.updateUsers(payload, id);
        return ok();
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable("id") UUID id){
        return ok(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteUserById(@PathVariable("id") UUID id){
        userService.deleteUser(id);
        return ok();
    }
}
