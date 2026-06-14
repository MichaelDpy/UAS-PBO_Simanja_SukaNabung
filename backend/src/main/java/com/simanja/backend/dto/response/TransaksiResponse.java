package com.simanja.backend.dto.response;

import com.simanja.backend.model.Transaksi;

import java.time.LocalDate;

/**
 * DTO response untuk data Transaksi.
 */
public class TransaksiResponse {

    private Long id;
    private String judul;
    private Double jumlah;
    private String jenis;        // "PEMASUKAN" atau "PENGELUARAN"
    private String jenisLabel;   // "Pemasukan" atau "Pengeluaran"
    private String kategori;
    private LocalDate tanggal;
    private String keterangan;
    private Long userId;

    public TransaksiResponse() {}

    /**
     * Factory method konversi dari entity Transaksi ke TransaksiResponse.
     * Menggunakan polimorfisme melalui interface Kategorisasi.
     */
    public static TransaksiResponse from(Transaksi t) {
        TransaksiResponse dto = new TransaksiResponse();
        dto.id         = t.getId();
        dto.judul      = t.getJudul();
        dto.jumlah     = t.getJumlah();
        dto.jenis      = t.getJenis().name();
        dto.jenisLabel = t.getJenisLabel();      // Polymorphism — method dari interface Kategorisasi
        dto.kategori   = t.getKategori();         // Polymorphism — method dari interface Kategorisasi
        dto.tanggal    = t.getTanggal();
        dto.keterangan = t.getKeterangan();
        dto.userId     = t.getUser().getId();
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public Double getJumlah() { return jumlah; }
    public void setJumlah(Double jumlah) { this.jumlah = jumlah; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public String getJenisLabel() { return jenisLabel; }
    public void setJenisLabel(String jenisLabel) { this.jenisLabel = jenisLabel; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public LocalDate getTanggal() { return tanggal; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }

    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
