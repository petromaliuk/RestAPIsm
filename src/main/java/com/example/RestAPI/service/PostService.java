package com.example.RestAPI.service;

import com.example.RestAPI.entity.Post;
import com.example.RestAPI.entity.User;
import com.example.RestAPI.repository.PostRepository;
import com.example.RestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;

  @Autowired
  private UserRepository userRepository;

  public Post createPost(String title, String body, Long authorId) {
    User author = userRepository.findById(authorId).orElseThrow();
    Post post = new Post();
    post.setTitle(title);
    post.setBody(body);
    post.setAuthor(author);
    return postRepository.save(post);
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public void likePost(Long postId, Long userId) {
    Post post = postRepository.findById(postId).orElseThrow();
    User user = userRepository.findById(userId).orElseThrow();
    post.getLikes().add(user);
    postRepository.save(post);
  }
}