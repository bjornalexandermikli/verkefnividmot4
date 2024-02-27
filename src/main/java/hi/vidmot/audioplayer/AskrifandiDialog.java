package hi.vidmot.audioplayer;

import Vinnsla.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import java.io.IOException;
import javafx.scene.control.ButtonType;

public class AskrifandiDialog extends Dialog<askrifandi> {

    @FXML
    private TextField fxNafn;

    /**
     * Smiður sem býr til AskrifandiDialog
     * sér einnig um að breyta nafni á Askrifanda
     *
     * @param a Askrifandi hlutur sem á að breyta
     */
    public AskrifandiDialog(askrifandi a) {
        // Setjum DialogPane
        setDialogPane(lesaDialog());

        // sjáum hvorn takkan notandi ýtti á og setjum nafn á Askrifanda ef notandi ýtti
        // á OK
        setResultConverter((button) -> {
            if (button == ButtonType.OK) {
                a.set(fxNafn.getText());
                return a;
            }
            return null;
        });

    }

    /**
     * Sér um að lesa inn fxml skrá og skila DialogPane
     * 
     * @return DialogPane
     */
    private DialogPane lesaDialog() {
        // Lesum inn fxml skrá
        FXMLLoader fxmlLoader = new FXMLLoader(AskrifandiDialog.class.getResource("askrifandi-view.fxml"));
        // reynum að hlaða inn fxml skrá
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}