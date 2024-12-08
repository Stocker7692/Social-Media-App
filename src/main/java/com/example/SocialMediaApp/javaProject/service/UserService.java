package com.example.SocialMediaApp.javaProject.service;

import com.example.SocialMediaApp.javaProject.in_memory_storage.InMemoryDatabase;
import com.example.SocialMediaApp.javaProject.model.User;

public class UserService {

    public String registerUser(String username) {
        if (username == null || username.length() < 3 || username.length() > 20) {
            return "Invalid username. Must be 3-20 characters.";
        }

        for (User user : InMemoryDatabase.users.values()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return "Username already taken.";
            }
        }

        InMemoryDatabase.userCounter++;
        int userId = InMemoryDatabase.userCounter;
        User user = new User(userId, username);
        InMemoryDatabase.users.put(userId, user);
        return username + " Registered!!";
    }


    public String followUser(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return "You cannot follow yourself.";
        }

        User follower = InMemoryDatabase.users.get(followerId);
        User followee = InMemoryDatabase.users.get(followeeId);

        if (follower == null || followee == null) {
            return "User not found.";
        }

        if (follower.getFollowing().contains(followeeId)) {
            return "You are already following " + followee.getUsername() + ".";
        }

        follower.getFollowing().add(followeeId);
        return "Followed " + followee.getUsername() + "!!";
    }

    public String unfollowUser(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return "You cannot unfollow yourself.";
        }

        User follower = InMemoryDatabase.users.get(followerId);
        User followee = InMemoryDatabase.users.get(followeeId);

        if (follower == null || followee == null) {
            return "User not found.";
        }

        if (!follower.getFollowing().contains(followeeId)) {
            return "You are not following " + followee.getUsername() + ".";
        }

        follower.getFollowing().remove(followeeId);
        return "Unfollowed " + followee.getUsername() + "!!";
    }
}
