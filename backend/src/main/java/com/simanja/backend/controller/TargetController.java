package com.simanja.backend.controller;

import com.simanja.backend.dto.request.IsiCelenganRequest;
import com.simanja.backend.dto.request.TargetRequest;
import com.simanja.backend.dto.response.TargetResponse;
import com.simanja.backend.service.TargetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TargetController — REST Controller untuk manajemen target tabungan (celengan).
 *
 * Demonstrasi: Controller layer (MVC), Security (JWT authenticated)
 */
@RestController
@RequestMapping("/api/target")
public class TargetController {

    private final TargetService targetService;

    public TargetController(TargetService targetService) {
        this.targetService = targetService;
    }

    /**
     * GET /api/target
     * Ambil semua target celengan milik user.
     */
    @GetMapping
    public ResponseEntity<List<TargetResponse>> getAll(Authentication authentication) {
        String email = authentication.getName();
        List<TargetResponse> list = targetService.getAllByUser(email);
        return ResponseEntity.ok(list);
    }

    /**
     * GET /api/target/{id}
     * Detail target berdasarkan ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TargetResponse> getById(
            @PathVariable Long id,
            Authentication authentication) {

        String email = authentication.getName();
        TargetResponse response = targetService.getById(id, email);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/target/total-tabungan
     * Hitung total currentAmount semua target (untuk dashboard).
     */
    @GetMapping("/total-tabungan")
    public ResponseEntity<Map<String, Double>> getTotalTabungan(Authentication authentication) {
        String email = authentication.getName();
        Double total = targetService.getTotalTabungan(email);
        return ResponseEntity.ok(Map.of("totalTabungan", total));
    }

    /**
     * POST /api/target
     * Buat target celengan baru.
     */
    @PostMapping
    public ResponseEntity<TargetResponse> buatTarget(
            @Valid @RequestBody TargetRequest request,
            Authentication authentication) {

        String email = authentication.getName();
        TargetResponse response = targetService.buatTarget(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * PUT /api/target/{id}
     * Update target celengan.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TargetResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody TargetRequest request,
            Authentication authentication) {

        String email = authentication.getName();
        TargetResponse response = targetService.update(id, email, request);
        return ResponseEntity.ok(response);
    }

    /**
     * DELETE /api/target/{id}
     * Hapus target celengan.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> hapus(
            @PathVariable Long id,
            Authentication authentication) {

        String email = authentication.getName();
        targetService.hapus(id, email);
        return ResponseEntity.ok(Map.of("message", "Target berhasil dihapus"));
    }

    /**
     * POST /api/target/{id}/isi
     * Isi celengan — tambahkan dana ke target tertentu.
     */
    @PostMapping("/{id}/isi")
    public ResponseEntity<TargetResponse> isiCelengan(
            @PathVariable Long id,
            @Valid @RequestBody IsiCelenganRequest request,
            Authentication authentication) {

        String email = authentication.getName();
        TargetResponse response = targetService.isiCelengan(id, email, request);
        return ResponseEntity.ok(response);
    }
}
