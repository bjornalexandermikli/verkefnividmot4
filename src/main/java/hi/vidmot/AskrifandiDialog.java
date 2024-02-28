package hi.vidmot;

import hi.vinnsla.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import java.io.IOException;
import javafx.scene.control.ButtonType;

public class AskrifandiDialog extends Dialog<Askrifandi> {

    @FXML
    private TextField fxNafn;

    /**
     * Smiður fyrir AskrifandiDialog - breytir líka nafni
     * 
     *
     * @param a Áskrifandahluturinn
     */
    public AskrifandiDialog(Askrifandi a) {

        setDialogPane(lesaDialog());

        // sjá hvaða takka ýtt og bregðast rétt við
        setResultConverter((button) -> {
            if (button == ButtonType.OK) {
                a.set(fxNafn.getText());
                return a;
            }
            return null;
        });

    }

    /**
     * les fxml og skilar DialogPane
     * 
     * @return skilar DialogPane
     */
    private DialogPane lesaDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(AskrifandiDialog.class.getResource("askrifandi-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
