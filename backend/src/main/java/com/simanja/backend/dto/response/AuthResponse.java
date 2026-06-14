package com.simanja.backend.dto.response;

/**
 * DTO response untuk login/register — berisi JWT token dan info user.
 */
public class AuthResponse {

    private String token;
    private String tokenType = "Bearer";
    private Long userId;
    private String nama;
    private String email;
    private String role;

    public AuthResponse() {}

    public AuthResponse(String token, Long userId, String nama, String email, String role) {
        this.token  = token;
        this.userId = userId;
        this.nama   = nama;
        this.email  = email;
        this.role   = role;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
