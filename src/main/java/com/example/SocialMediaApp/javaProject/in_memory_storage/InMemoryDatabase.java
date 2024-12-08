package com.example.SocialMediaApp.javaProject.in_memory_storage;

import com.example.SocialMediaApp.javaProject.model.Post;
import com.example.SocialMediaApp.javaProject.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    public static final Map<Integer, User> users = new HashMap<>();
    public static final Map<Integer, Post> posts = new HashMap<>();
    public static int postCounter = 0;
    public static int userCounter = 0;
}
