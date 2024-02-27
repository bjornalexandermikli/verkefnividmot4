package hi.vidmot.audioplayer;

import Vinnsla.askrifandi;
import Vinnsla.lagaListar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class PlayerController {
    askrifandi a = new askrifandi();
    lagaListar lagaListar = new lagaListar();

    /**
     * Sér um að birta Dialog og fá nafn frá notanda
     */
    public void onLogin() {
        // Birtum Dialog og fáum nafn frá notanda og setjum í Askrifanda
        AskrifandiDialog d = new AskrifandiDialog(a);
        d.showAndWait();
    }

    public void onVeljaLista(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        int i = GridPane.getColumnIndex(b);
        ViewSwitcher.switchTo(View.LISTI, lagaListar.get(i));
    }
}
