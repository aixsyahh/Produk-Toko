package kelas.model;

public class Produk {

    private final String kode;
    private final String nama;
    private final String kategori;
    private int harga;
    private String pathFoto;

    public Produk(String kode, String nama, String kategori, int harga, String pathFoto) {
        if (kode == null || kode.isBlank() || nama == null) {
            throw new IllegalArgumentException("Data pembelian tidak lengkap.");
        }
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.pathFoto = pathFoto;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public int getHarga() {
        return harga;
    }
    
    public String getPathFoto(){
        return pathFoto;
    }
    
}
