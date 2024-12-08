package com.example.SocialMediaApp.javaProject.main_driver;

import com.example.SocialMediaApp.javaProject.service.UserService;
import com.example.SocialMediaApp.javaProject.service.PostService;

import java.util.Scanner;

public class MainDriver {
    public static void main(String[] args) {
        UserService userService = new UserService();
        PostService postService = new PostService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Social Media App");

        while (true) {
            System.out.println("\nEnter Command:");
            String command = scanner.nextLine();
            String[] inputs = command.split(" ", 3);
            String action = inputs[0];

            switch (action) {
                case "RegisterUser":
                    System.out.println(userService.registerUser(inputs[2]));
                    break;

                case "UploadPost":
                    System.out.println(postService.uploadPost(Integer.parseInt(inputs[1]), inputs[2]));
                    break;

                case "InteractWithUser":
                    String interactionType = inputs[1];
                    int followerId = Integer.parseInt(inputs[2]);
                    int followeeId = Integer.parseInt(inputs[3]);

                    if (interactionType.equals("FOLLOW")) {
                        System.out.println(userService.followUser(followerId, followeeId));
                    } else if (interactionType.equals("UNFOLLOW")) {
                        System.out.println(userService.unfollowUser(followerId, followeeId));
                    }
                    break;

                case "ShowFeed":
                    System.out.println(postService.showFeed(Integer.parseInt(inputs[1])));
                    break;

                case "EXIT":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
