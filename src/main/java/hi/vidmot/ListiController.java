package hi.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

import hi.vinnsla.Lag;
import hi.vinnsla.Lagalisti;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;

public class ListiController {
    @FXML
    private ListView<Lag> fxListView;
    @FXML
    private ImageView fxValidLagMynd;
    @FXML
    private Button fxPlayPause;
    @FXML
    private ProgressBar fxProgressBar;
    
    private Lagalisti listi;
    private Lag validLag;
    private MediaPlayer mediaPlayer;

    /**
     * Frumstillir listann og tengir við ListView
     */
    public void initialize() {
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }

    public void setLagalisti(Lagalisti lagalisti) {
        this.listi = lagalisti;
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }


    /**
     * Sér um að velja lag úr listanum
     * @param mouseEvent Ýtt á lag
     */
    public void onValidLag(MouseEvent mouseEvent) {
        validLag = fxListView.getSelectionModel().getSelectedItem();
        System.out.println(validLag.getLag());
        //Image mynd = new Image(validLag.getMynd());
        //fxValidLagMynd.setImage(mynd);
        spilaLag(validLag);
    }


    /**
     * Spilar lag úr listanum sem er valið
     * @param validLag lag sem á að spila
     */
    private void spilaLag(Lag validLag) {
        System.out.println(validLag.getSkra());
        File file = new File(getClass().getResource(validLag.getSkra()).getFile());
        System.out.println(file.toURI().toString());
        Media media = new Media(file.toURI().toString());
        setjaPlayer(media);
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    /**
     * Setur lag í mediaPlayer
     * @param media lag sem á að spila
     */
    private void setjaPlayer(Media media) {
        if(mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.currentTimeProperty().addListener((observable, old, newValue) -> 
        fxProgressBar.setProgress(newValue.divide(Double.parseDouble(validLag.getLengd())).toMillis()));
    }

    /**
     * Sér um að fara heim þegar ýtt er á takka
     */
    public void onHeim(){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        ViewSwitcher.switchTo(View.HEIMA);
    }

    public void onPlayPause(ActionEvent actionEvent) {
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
            mediaPlayer.pause();
            fxPlayPause.getStyleClass().remove("play");
            fxPlayPause.getStyleClass().add("pause");
        } else {
            mediaPlayer.play();
            fxPlayPause.getStyleClass().remove("pause");
            fxPlayPause.getStyleClass().add("play");
        }
    }
}
