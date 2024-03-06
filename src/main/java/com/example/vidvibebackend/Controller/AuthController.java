package com.example.vidvibebackend.Controller;

import com.example.vidvibebackend.Entity.ResponseResult;
import com.example.vidvibebackend.Entity.User;
import com.example.vidvibebackend.Entity.UserRegistrationRequest;
import com.example.vidvibebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 身份验证控制器
 *
 * @author yu
 * @date 2024/03/06
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult<String> register(@RequestBody UserRegistrationRequest registrationRequest) {
        User registeredUser = userService.register(registrationRequest.toUser());

        return ResponseResult.success("User registered successfully");
    }

}