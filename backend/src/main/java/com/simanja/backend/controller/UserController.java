package com.simanja.backend.controller;

import com.simanja.backend.dto.request.ChangePasswordRequest;
import com.simanja.backend.dto.request.UpdateUserRequest;
import com.simanja.backend.dto.response.UserResponse;
import com.simanja.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserController — REST Controller untuk manajemen data user.
 *
 * Demonstrasi: Controller layer (MVC), Security (role-based authorization)
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /api/users/me
     * Ambil profil user yang sedang login (dari JWT token).
     */
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getMe(Authentication authentication) {
        String email = authentication.getName(); // email dari JWT token
        UserResponse response = userService.getByEmail(email);
        return ResponseEntity.ok(response);
    }

    /**
     * PUT /api/users/me
     * Update profil user yang sedang login.
     */
    @PutMapping("/me")
    public ResponseEntity<UserResponse> updateMe(Authentication authentication,
                                                  @RequestBody UpdateUserRequest request) {
        String email = authentication.getName();
        UserResponse response = userService.updateProfil(email, request);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/users
     * Ambil semua user — hanya untuk ADMIN.
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> response = userService.getAll();
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/users/{id}
     * Ambil user berdasarkan ID — hanya untuk ADMIN.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        UserResponse response = userService.getById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * PUT /api/users/change-password
     * Ubah password user yang sedang login.
     */
    @PutMapping("/change-password")
    public ResponseEntity<Map<String, String>> changePassword(
            Authentication authentication,
            @Valid @RequestBody ChangePasswordRequest request) {
        String email = authentication.getName();
        userService.changePassword(email, request);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Password berhasil diubah");
        return ResponseEntity.ok(response);
    }
}
