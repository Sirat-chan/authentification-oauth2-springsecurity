package com.example.jwt.services.impl;

import com.example.jwt.entities.User;
import com.example.jwt.repository.UserRepository;
import com.example.jwt.services.UserInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserInterface {
    private final UserRepository userRepository;
    @Override
    public void updateUserProfile(String name, String email, String password, MultipartFile profileImage) throws IOException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        user.setFirstName(name);
        user.setPassword(password);

        if (profileImage != null && !profileImage.isEmpty()) {
            String uploadDir = "uploads/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = profileImage.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(profileImage.getInputStream(), filePath);

            user.setProfileImage(fileName);
        }

        userRepository.save(user);
    }
}
