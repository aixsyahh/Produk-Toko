# Aplikasi Pencatatan Produk Toko (JavaFX)

Aplikasi desktop berbasis JavaFX yang dirancang untuk mengelola dan mencatat data produk toko secara interaktif. Aplikasi ini dibangun menggunakan arsitektur MVC (Model-View-Controller) dengan antarmuka FXML dan JavaFX Scene Builder.

---

## 🚀 Fitur Utama

- **Form Tambah Produk**: Memungkinkan pengguna memasukkan kode produk, nama produk, memilih kategori (Makanan/Minuman), dan menentukan harga.
- **Validasi Input**: Menolak input nama kosong dan memastikan harga lebih dari nol (`> 0`).
- **Tabel Data Produk**: Menampilkan daftar produk tersimpan secara langsung (*in-memory storage*).
- **Pencarian Produk**: Mencari produk berdasarkan nama secara real-time dari tabel.
- **Halaman Detail Produk**: Menampilkan rincian lengkap informasi produk yang dipilih secara dinamis.

---

## 🖥️ Tampilan Aplikasi
1. Form tambah produk
<img width="431" height="452" alt="Screenshot 2026-11-08 232509" src="https://github.com/user-attachments/assets/c5fa42cc-997b-40d8-afe9-eb155a0476d9" />
--
2. Daftar & pencarian produk
<img width="435" height="454" alt="Screenshot 2026-11-08 232843" src="https://github.com/user-attachments/assets/5925d7db-d87b-48cd-85e6-79e2a74340ef" />
--
3. Detail produk
<img width="434" height="451" alt="Screenshot 2026-11-08 232908" src="https://github.com/user-attachments/assets/568367d5-f810-424f-b6d4-1b7101c7596b" />

## Cara menjalankan
1. Clone repository
git clone [https://github.com/aixsyahh/Produk-Toko.git](https://github.com/aixsyahh/Produk-Toko.git)
cd Produk-Toko
2. Jalankan maven di command line
mvn clean javafx:run
3. Atau lewat netbeans
- Klik File -> Open Project... -> Pilih folder ProdukToko.
- Klik kanan pada proyek ProdukToko, pilih Clean and Build.
- Tekan F6 / ikon Run.

## 📁 Struktur Proyek

```text
src/main/
├── java/kelas/
│   ├── MainApp.java           
│   ├── Navigator.java         
│   ├── controller/            
│   │   ├── FormController.java
│   │   ├── DaftarController.java
│   │   └── DetailController.java
│   ├── data/                  
│   │   └── DataProduk.java
│   └── model/                
│       └── Produk.java
└── resources/kelas/           
    ├── form.fxml
    ├── daftar.fxml
    ├── detail.fxml
    └── styles/
        └── app.css
