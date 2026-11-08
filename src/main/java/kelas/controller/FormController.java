package kelas.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import kelas.Navigator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController implements Initializable{

    @FXML
    private TextField namaField, kodeField, hargaField;
    @FXML
    private ComboBox<String> KategoriCombo;
    @FXML
    private Navigator navigator;
    @FXML
    private ImageView fotoImageView;
    
    private String selectedFotoPath = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    KategoriCombo.getItems().addAll("Makanan", "Minuman");
    KategoriCombo.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void handlePilihFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Foto Produk");

        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(namaField.getScene().getWindow());
        if (file != null) {
            selectedFotoPath = file.toURI().toString(); 
            Image image = new Image(selectedFotoPath);
            fotoImageView.setImage(image);
        }
    }
    
    @FXML
    private void handleTambahProduk(ActionEvent event) {
        String nama = namaField.getText().trim();
        String kode = kodeField.getText().trim();
        String kategori = KategoriCombo.getValue();
        String hargaStr = hargaField.getText().trim();

        if (nama.isEmpty() || kode.isEmpty()) {
            showAlert("Ditolak", "Nama produk dan kode produk tidak boleh kosong.");
            return;
        }

        int harga = 0;
        try {
            harga = Integer.parseInt(hargaStr);
        } catch (NumberFormatException e) {
            showAlert("Ditolak", "Harga harus berupa angka yang valid!");
            return;
        }

        if (harga <= 0) {
            showAlert("Ditolakk", "Harga produk harus lebih dari nol!");
            return;
        }

        // Buat objek Produk baru dan simpan ke list
        Produk produkBaru = new Produk(kode, nama, kategori, harga, selectedFotoPath);
        DataProduk.tambahProduk(produkBaru);

        showAlert("Sukses", "Produk berhasil ditambahkan!");
        
        // Pindah ke halaman daftar produk
        Navigator.navigate(event, "/kelas/daftar.fxml");
    }

    @FXML
    private void handleLihatDaftar(ActionEvent event) {
        Navigator.navigate(event, "/kelas/daftar.fxml");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}