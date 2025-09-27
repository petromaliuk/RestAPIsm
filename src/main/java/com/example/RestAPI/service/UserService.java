package com.example.RestAPI.service;

import com.example.RestAPI.entity.User;
import com.example.RestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User createUser(String username) {
    User user = new User();
    user.setUsername(username);
    return userRepository.save(user);
  }

  public void followUser(Long userId, Long followUserId) {
    User user = userRepository.findById(userId).orElseThrow();
    User followUser = userRepository.findById(followUserId).orElseThrow();
    user.getFollowers().add(followUser);
    userRepository.save(user);
  }
}