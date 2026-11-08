package kelas;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {
    public static void navigate(ActionEvent event, String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(Navigator.class.getResource(fxmlPath));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bukaDaftar(ActionEvent event) {
        navigate(event, "/kelas/daftar.fxml");
    }

    public static void bukaForm(ActionEvent event) {
        navigate(event, "/kelas/form.fxml");
    }

    public static void bukaDetail(ActionEvent event) {
        navigate(event, "/kelas/detail.fxml");
    }
}