package com.example.SocialMediaApp.javaProject.service;

import com.example.SocialMediaApp.javaProject.in_memory_storage.InMemoryDatabase;
import com.example.SocialMediaApp.javaProject.model.Post;
import com.example.SocialMediaApp.javaProject.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PostService {

    public String uploadPost(int userId, String content) {
        if (content == null || content.length() < 1 || content.length() > 280) {
            return "Invalid post content. Must be 1-280 characters.";
        }

        if (!InMemoryDatabase.users.containsKey(userId)) {
            return "User not found.";
        }

        InMemoryDatabase.postCounter++;
        int postId = InMemoryDatabase.postCounter;
        Post post = new Post(postId, userId, content, LocalDateTime.now(), 0, 0);
        InMemoryDatabase.posts.put(postId, post);
        return "Upload Successful with post id: " + String.format("%03d", postId) +
                "\nPreview: " + content;
    }

    public String showFeed(int userId) {
        User user = InMemoryDatabase.users.get(userId);
        if (user == null) return "User not found.";

        List<Post> feed = InMemoryDatabase.posts.values().stream()
                .sorted((p1, p2) -> p2.getPostTime().compareTo(p1.getPostTime()))
                .filter(post -> user.getFollowing().contains(post.getUserId()) || post.getUserId() == userId)
                .limit(10) // Show last 10 posts
                .collect(Collectors.toList());

        StringBuilder feedDisplay = new StringBuilder();
        for (Post post : feed) {
            User postUser = InMemoryDatabase.users.get(post.getUserId());
            feedDisplay.append("UserName: ").append(postUser.getUsername()).append("\n")
                    .append("Post: ").append(post.getContent()).append("\n")
                    .append("Post Time: ").append(post.getPostTime()).append("\n\n");
        }

        return feedDisplay.toString();
    }
}
