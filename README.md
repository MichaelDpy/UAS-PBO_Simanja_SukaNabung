# SiManja

SiManja merupakan sistem manajemen keuangan pribadi berbasis aplikasi desktop yang dirancang untuk membantu pengguna dalam mencatat, memantau, dan mengelola kondisi keuangan dengan lebih teratur. 


SiManja bertujuan untuk membantu pengguna dalam melacak alokasi pengeluaran, memonitor pemasukan, serta menyusun suatu target keuangan sehingga terdapat dorongan untuk membangun kebiasaan audit keuangan secara rutin dan membantu pembuatan keputusan finansial berbasis data.


## Fitur Utama SiManja
### 1. Dashboard Finansial

Dashboard ini berperan sebagai layanan utama yang ditampilkan setelah pengguna berhasil masuk ke SiManja. Fitur Dashboard Finansial bertujuan untuk memberikan ringkasan/gambaran kondisi keuangan pengguna sehingga pengguna tidak perlu melakukan pemeriksaan terhadap setiap transaksi secara mendalam dan menyeluruh.

Layanan tersebut memungkinkan pengguna untuk segera mengetahui data keuangan, seperti:
- 💰 Data saldo, pemasukan serta pengeluaran bulanan, dan sisa dana aman;
- 📊 Diagram arus kas dan alokasi pengeluaran;
- 📋 Rangkuman transaksi terakhir, target keuangan yang ingin dicapai, dan status anggaran.

### 2. Manajemen Transaksi
Fitur ini bertujuan untuk membantu pengguna dalam melacak serta memanajemen pengeluaran dan pemasukan.

Layanan tersebut memungkinkan pengguna untuk melakukan tindakan berikut.
- ➕ Mencatat transaksi, baik pemasukan maupun pengeluaran;
- ✏️ Mengedit dan menghapus transaksi;
- 🔍 Mencari transaksi berdasarkan kata kunci;
- 📋 Memeriksa riwayat transaksi;
- 📊 Ringkasan total pemasukan serta total pengeluaran;

### 3. Target Tabungan (Celengan)
Fitur ini bertujuan untuk membantu pengguna dalam membentuk suatu target finansial dan melacak perkembangan yang perlu dilakukan untuk mencapai target tersebut.

Layanan ini memungkinkan pengguna untuk melakukan tindakan berikut.
- 🎯 Membuat target tabungan dengan tenggat waktu yang ditentukan;
- 💰 Mengisi celengan;
- 📊 Melacak perkembangan dari tabungan atau target finansial;
- 🗑️ Mengedit dan menghapus target;
- 💵 Memeriksa total tabungan pengguna.

### 4. Laporan Keuangan 
Fitur ini bertujuan untuk membantu pengguna memahami pola keuangan dan menjaga pengguna tetap sadar mengenai alokasi pengeluaran serta pemasukannya.

Layanan ini memungkinkan pengguna untuk mendapatkan data sebagai berikut.
- 💰 Alokasi pengeluaran dalam bentuk diagram lingkaran;
- 📊 Tren arus kas bulanan yang meliputi pemasukan dan pengeluaran;
- 📋 Informasi penting terkait kondisi finansial pengguna.

### 5. Pengaturan Profil Pengguna
Layanan ini hadir sebagai media pengelolaan data pengguna (profil) dalam ekosistem SiManja dan memungkinkan pengguna untuk melakukan personalisasi sesuai dengan kebutuhan.

Dengan menggunakan menu Pengaturan, pengguna dapat melakukan tindakan berikut.
- 👤 Melihat data akun (profil) secara lengkap;
- ✏️ Memperbarui data akun, seperti nama, username, telepon, alamat, dll.;
- 🔐 Mengubah password;
- 🖼️ Menambahkan foto profil.


## Panduan Menjalankan Aplikasi SiManja
Persyaratan:
- ✅ **Java 17** atau versi yang lebih tinggi → [Download](https://adoptium.net/)
- ✅ **Apache Maven 3.6+** → [Download](https://maven.apache.org/download.cgi)

Verifikasi instalasi:
```bash
java -version     # Harus Java 17+
mvn -version      # Harus Maven 3.6+
```
---
### **1. Menjalankan Backend**

#### **Metode 1: Quick Start (Direkomendasikan)** 

Langkah tercepat untuk menjalankan aplikasi:

```bash
cd backend
QUICK_START.bat
```

**Script akan otomatis:**
1. Check Maven installation
2. Compile project (jika belum)
3. Start Spring Boot application
4. Menampilkan server info & demo accounts

---

#### **Metode 2: Fix Database Issues**

Jika ada masalah koneksi database atau compilation error:

```bash
cd backend
FIX_DATABASE.bat
```

**Script akan otomatis:**
1. Clean project (`mvn clean`)
2. Remove old data folder (jika ada)
3. Clear Maven cache untuk H2
4. Download fresh dependencies
5. Compile project
6. Start application

---

#### **Metode 3: Manual dengan Maven**

```bash
cd backend

# Clean & start
mvn clean spring-boot:run

# Atau dengan package
mvn clean package -DskipTests
mvn spring-boot:run
```

---

#### **Metode 4: Dari IDE**

##### **IntelliJ IDEA:**
1. `File` → `Open` → Pilih folder `backend`
2. Wait for Maven import
3. Right-click `SimanjaBackendApplication.java`
4. `Run 'SimanjaBackendApplication'`

##### **Eclipse:**
1. `File` → `Import` → `Existing Maven Project`
2. Select folder `backend`
3. Right-click project → `Run As` → `Spring Boot App`

---

#### **Verifikasi Server Berjalan**

Setelah start, Anda akan lihat output:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.5)

...
INFO  - Started SimanjaBackendApplication in 3.456 seconds
```

**Server Information:**
- 🌐 **Base URL:** `http://localhost:8080`
- 🗄️ **H2 Console:** `http://localhost:8080/h2-console`
- 📡 **API Base:** `http://localhost:8080/api`

---

### **2. Menjalankan Frontend**

#### **Metode 1: Perintah Terminal dengan Maven** 

Silakan masuk dahulu ke folder frontend, lalu jalankan aplikasi.

```bash
cd frontend
mvn javafx:run
```

---

#### **Metode 2: Melalui IDE**

1. `File` → `Open` → Pilih folder `frontend`
2. Wait for Maven import
3. Right-click `MainApp.java`
4. `Run 'MainApp.main()'`

---

## [Link Video Presentasi](https://youtu.be/W447g8EypGc)
