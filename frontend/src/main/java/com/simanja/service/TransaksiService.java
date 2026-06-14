package com.simanja.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.simanja.model.Transaksi;
import com.simanja.model.Transaksi.JenisTransaksi;
import com.simanja.util.ApiClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * TransaksiService — Terhubung ke Spring Boot backend via REST API.
 */
public class TransaksiService {

    // DTO Internal untuk Summary dan Laporan
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record SummaryResponse(double totalPemasukan, double totalPengeluaran, double saldo, double totalTabungan) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record LaporanResponse(
            Map<String, Double> pemasukanPerBulan,
            Map<String, Double> pengeluaranPerBulan,
            Map<String, Double> pengeluaranPerKategori
    ) {}
    
    // Fix: jenis field sebagai String, bukan enum JenisTransaksi
    // Backend DTO (TransaksiRequest) mengharapkan String "PEMASUKAN" / "PENGELUARAN"
    record TransaksiRequest(
            String judul, 
            double jumlah, 
            String jenis, 
            String kategori, 
            LocalDate tanggal, 
            String keterangan
    ) {}

    /** Ambil semua transaksi milik user (userId diabaikan krn pakai JWT backend) */
    public List<Transaksi> getAllByUser(int userId) {
        return ApiClient.get("/transaksi", new TypeReference<List<Transaksi>>() {});
    }

    /** Ambil transaksi terbaru (5 item) */
    public List<Transaksi> getRecentByUser(int userId, int limit) {
        return ApiClient.get("/transaksi/recent?limit=" + limit, new TypeReference<List<Transaksi>>() {});
    }

    /** Panggil sekali, hasilnya bisa dipakai untuk totalPemasukan, totalPengeluaran, saldo */
    public SummaryResponse getSummaryResponse() {
        return ApiClient.get("/transaksi/summary", SummaryResponse.class);
    }

    public double getTotalPemasukan(int userId) {
        return getSummaryResponse().totalPemasukan();
    }

    public double getTotalPengeluaran(int userId) {
        return getSummaryResponse().totalPengeluaran();
    }

    public double getSaldo(int userId) {
        return getSummaryResponse().saldo();
    }

    /** Panggil sekali, hasilnya bisa dipakai untuk pemasukanPerBulan, pengeluaranPerBulan, pengeluaranPerKategori */
    public LaporanResponse getLaporanResponse() {
        return ApiClient.get("/transaksi/laporan", LaporanResponse.class);
    }

    public Map<String, Double> getPengeluaranPerKategori(int userId) {
        return getLaporanResponse().pengeluaranPerKategori();
    }

    /** Tambah transaksi baru */
    public Transaksi tambah(String judul, double jumlah, JenisTransaksi jenis,
                            String kategori, LocalDate tanggal, String keterangan, int userId) {
        
        // Fix: kirim jenis sebagai String (name()), bukan enum object
        TransaksiRequest req = new TransaksiRequest(judul, jumlah, jenis.name(), kategori, tanggal, keterangan);
        return ApiClient.post("/transaksi", req, Transaksi.class);
    }

    /** Update transaksi */
    public void update(int id, String judul, double jumlah, JenisTransaksi jenis,
                       String kategori, LocalDate tanggal, String keterangan) {
                       
        // Fix: kirim jenis sebagai String (name()), bukan enum object
        TransaksiRequest req = new TransaksiRequest(judul, jumlah, jenis.name(), kategori, tanggal, keterangan);
        ApiClient.put("/transaksi/" + id, req, Transaksi.class);
    }

    /** Hapus transaksi */
    public void hapus(int id) {
        ApiClient.delete("/transaksi/" + id);
    }

    /** Cari transaksi berdasarkan judul */
    public List<Transaksi> cari(int userId, String keyword) {
        return ApiClient.get("/transaksi?keyword=" + keyword, new TypeReference<List<Transaksi>>() {});
    }

    /** Data per bulan untuk grafik laporan */
    public Map<String, Double> getPemasukanPerBulan(int userId) {
        return getLaporanResponse().pemasukanPerBulan();
    }

    public Map<String, Double> getPengeluaranPerBulan(int userId) {
        return getLaporanResponse().pengeluaranPerBulan();
    }
}
