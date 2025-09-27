package com.example.RestAPI.controller;

import com.example.RestAPI.entity.User;
import com.example.RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping
  public User createUser(@RequestParam String username) {
    return userService.createUser(username);
  }

  @PostMapping("/{userId}/follow/{followUserId}")
  public void followUser(@PathVariable Long userId, @PathVariable Long followUserId) {
    userService.followUser(userId, followUserId);
  }
}