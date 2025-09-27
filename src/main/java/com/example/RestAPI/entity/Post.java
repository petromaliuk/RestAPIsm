package com.example.RestAPI.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;
  private String body;

  @ManyToOne
  private User author;

  @ManyToMany
  private Set<User> likes;

}
