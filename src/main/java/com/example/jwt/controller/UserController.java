package com.example.jwt.controller;


import com.example.jwt.repository.UserRepository;
import com.example.jwt.services.UserInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserInterface userInterface;

    @PostMapping("/update")
    public ResponseEntity<?> updateUserProfile(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(value = "profileImage", required = false) MultipartFile profileImage
    ) throws IOException {

        userInterface.updateUserProfile(name, email, password, profileImage);
        return ResponseEntity.ok("Profile updated successfully.");
    }

}
