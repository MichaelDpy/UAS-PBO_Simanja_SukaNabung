package com.simanja.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

/**
 * DTO untuk request buat target baru.
 */
public class TargetRequest {

    @NotBlank(message = "Nama target tidak boleh kosong")
    private String nama;

    private String iconEmoji;

    @NotNull(message = "Target amount tidak boleh kosong")
    @Positive(message = "Target amount harus lebih dari 0")
    private Double targetAmount;

    @NotNull(message = "Deadline tidak boleh kosong")
    private LocalDate deadline;

    public TargetRequest() {}

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getIconEmoji() { return iconEmoji; }
    public void setIconEmoji(String iconEmoji) { this.iconEmoji = iconEmoji; }

    public Double getTargetAmount() { return targetAmount; }
    public void setTargetAmount(Double targetAmount) { this.targetAmount = targetAmount; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
}
