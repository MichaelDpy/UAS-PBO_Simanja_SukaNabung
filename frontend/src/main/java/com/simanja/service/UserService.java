package com.simanja.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.simanja.model.User;
import com.simanja.util.ApiClient;

/**
 * UserService — Menghubungkan Profil dengan backend REST API
 */
public class UserService {

    @JsonIgnoreProperties(ignoreUnknown = true)
    record UpdateUserRequest(
            String nama,
            String username,
            String telepon,
            String jenisKelamin,
            String tanggalLahir,
            String alamat,
            String profileImagePath
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    record ChangePasswordRequest(
            String oldPassword,
            String newPassword,
            String confirmPassword
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    record MessageResponse(String message) {}

    public User getProfile() {
        return ApiClient.get("/users/me", User.class);
    }

    public User updateProfile(String nama, String username, String telepon, 
                              String jenisKelamin, String tanggalLahir, String alamat, String profileImagePath) {
        
        UpdateUserRequest req = new UpdateUserRequest(
                nama, username, telepon, jenisKelamin, tanggalLahir, alamat, profileImagePath
        );
        
        return ApiClient.put("/users/me", req, User.class);
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword) {
        ChangePasswordRequest req = new ChangePasswordRequest(oldPassword, newPassword, confirmPassword);
        ApiClient.put("/users/change-password", req, MessageResponse.class);
    }
}
