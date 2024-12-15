package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.User;
import com.example.dual_selection_platform_back.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @GetMapping("/login/{username}/{password}")
    public User login( @PathVariable String username, @PathVariable String password) {
        System.out.println("Received username: " + username + ", password: " + password);
        System.out.println("role_id: " + userService.login(username, password).getRole_id());
        return userService.login(username, password);
    }
}