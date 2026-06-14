package com.simanja.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

/**
 * DTO untuk request tambah / update transaksi.
 * Validasi Bean Validation diterapkan pada setiap field.
 */
public class TransaksiRequest {

    @NotBlank(message = "Judul transaksi tidak boleh kosong")
    private String judul;

    @NotNull(message = "Jumlah tidak boleh kosong")
    @Positive(message = "Jumlah harus lebih dari 0")
    private Double jumlah;

    @NotBlank(message = "Jenis transaksi tidak boleh kosong")
    private String jenis; // "PEMASUKAN" atau "PENGELUARAN"

    @NotBlank(message = "Kategori tidak boleh kosong")
    private String kategori;

    @NotNull(message = "Tanggal tidak boleh kosong")
    private LocalDate tanggal;

    private String keterangan;

    public TransaksiRequest() {}

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public Double getJumlah() { return jumlah; }
    public void setJumlah(Double jumlah) { this.jumlah = jumlah; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public LocalDate getTanggal() { return tanggal; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }

    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
}
