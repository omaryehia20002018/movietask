package com.Fawry.MovieApplication.controller.user;


import com.Fawry.MovieApplication.dto.User.UserCredentials;
import com.Fawry.MovieApplication.dto.User.UserDto;
import com.Fawry.MovieApplication.entity.User;
import com.Fawry.MovieApplication.repository.user.UserRepository;
import com.Fawry.MovieApplication.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/user")
@RequiredArgsConstructor
@Tag(name = "user controller")
public class UserController {

    private final UserService service;
    private final UserRepository repository;
    @PostMapping("/register")
    @Operation(description = "user register using username and password")
    public User register(@RequestBody UserDto user) {
        return service.register(user);

    }

    @PostMapping("/login")
    @Operation(description = "user log in with username and password")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserCredentials login(@RequestBody UserDto user) {
        String token=service.verify(user);
        UserCredentials userCredentials=new UserCredentials();
        userCredentials.setRole(repository.findByUsername(user.getUsername()).getRole());
        userCredentials.setToken(token);
        return userCredentials;
    }
}
