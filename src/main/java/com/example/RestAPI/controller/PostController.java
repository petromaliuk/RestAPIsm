package com.example.RestAPI.controller;

import com.example.RestAPI.entity.Post;
import com.example.RestAPI.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
  @Autowired
  private PostService postService;

  @PostMapping
  public Post createPost(@RequestParam String title, @RequestParam String body, @RequestParam Long authorId) {
    return postService.createPost(title, body, authorId);
  }

  @GetMapping
  public List<Post> getAllPosts() {
    return postService.getAllPosts();
  }

  @PostMapping("/{postId}/like/{userId}")
  public void likePost(@PathVariable Long postId, @PathVariable Long userId) {
    postService.likePost(postId, userId);
  }
}
