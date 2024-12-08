package com.example.SocialMediaApp.javaProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int userId;
    private String username;
    private Set<Integer> following;

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.following = new HashSet<>();
    }
}
