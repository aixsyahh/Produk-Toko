package kelas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {

    @FXML
    private Label kodeLabel, namaLabel, kategoriLabel, hargaLabel;
    @FXML
    private ImageView fotoImageView;
    
    private static Produk produkTerpilih;

    public static void setProdukTerpilih(Produk produk) {
        produkTerpilih = produk;
    }

  
    public void initialize() {
        if (produkTerpilih != null) {
            kodeLabel.setText(produkTerpilih.getKode());
            namaLabel.setText(produkTerpilih.getNama());
            kategoriLabel.setText(produkTerpilih.getKategori());
            hargaLabel.setText("Rp " + String.format("%,d", produkTerpilih.getHarga()));
            
            if (produkTerpilih.getPathFoto() != null && !produkTerpilih.getPathFoto().isEmpty()) {
                Image image = new Image(produkTerpilih.getPathFoto());
                fotoImageView.setImage(image);
            }
        }
    }

    @FXML
    private void handleKembali(ActionEvent event) {
        Navigator.navigate(event, "/kelas/daftar.fxml");
    }
    
}
