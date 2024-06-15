package com.example.jwt.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserInterface {
    void updateUserProfile(String name, String email, String password, MultipartFile profileImage) throws IOException;

}
