package hi.vidmot;

import hi.vinnsla.Askrifandi;
import hi.vinnsla.Lagalistar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class PlayerController {
    Askrifandi a = new Askrifandi();
    Lagalistar lagalistar = new Lagalistar();
    private String[] myndir = new String[2];

    @FXML
    private Label fxStatus;

    public void initialize() {
        fxStatus.setText("Staða: Enginn notandi skráður inn");
        myndir[0] = "media/mynd1.png";
        myndir[1] = "media/mynd2.png";
    }

    public void onLogin() {
        AskrifandiDialog d = new AskrifandiDialog(a);
        d.showAndWait();
        fxStatus.setText("Góðan daginn: " + a.get());
    }

    public void onVeljaLista(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        int i = GridPane.getColumnIndex(b);
        ViewSwitcher.switchTo(View.LISTI, lagalistar.get(i), myndir[i]);
    }
}
