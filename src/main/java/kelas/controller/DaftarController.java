package kelas.controller;

import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {

    @FXML
    private TableView<Produk> tabel;
    @FXML
    private TableColumn<Produk, String> kodeCol;
    @FXML
    private TableColumn<Produk, String> namaCol;
    @FXML
    private TableColumn<Produk, String> kategoriCol;
    @FXML
    private TableColumn<Produk, Integer> hargaCol;
    @FXML
    private TextField cariField;

    private ObservableList<Produk>
        masterList = FXCollections.observableArrayList();
    
    @FXML
    private void initialize() {
        // Menghubungkan kolom tabel dengan atribut di class Produk
        kodeCol.setCellValueFactory(new PropertyValueFactory<>("kode"));
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategoriCol.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        hargaCol.setCellValueFactory(new PropertyValueFactory<>("harga"));

        // Muat data dari DataProduk
        masterList.addAll(DataProduk.getListProduk());
        tabel.setItems(masterList);
    }

    @FXML
    private void cari() {
        String keyword = cariField.getText().trim().toLowerCase(Locale.ROOT);

        ObservableList<Produk> filteredList = FXCollections.observableArrayList();
        for (Produk p : masterList) {
            if (p.getNama().toLowerCase().contains(keyword)) {
                filteredList.add(p);
            }
        }
        tabel.setItems(filteredList);
        
    }

    @FXML
    private void tambah(ActionEvent event) {
       Navigator.navigate(event, "/kelas/form.fxml");
    }

    @FXML
    private void detail(ActionEvent event) {
        Produk produkTerpilih = tabel.getSelectionModel().getSelectedItem();
        if (produkTerpilih == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Silakan pilih produk dari tabel terlebih dahulu!");
            alert.showAndWait();
            return;           
        }
        
        DetailController.setProdukTerpilih(produkTerpilih);
        Navigator.navigate(event, "/kelas/detail.fxml");
    }
    
    

}
