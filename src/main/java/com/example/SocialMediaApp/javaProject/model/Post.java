package com.example.SocialMediaApp.javaProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private int postId;
    private int userId;
    private String content;
    private LocalDateTime postTime;
    private int likes;
    private int dislikes;
}
