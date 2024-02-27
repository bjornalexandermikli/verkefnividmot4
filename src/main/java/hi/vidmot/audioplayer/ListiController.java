package hi.vidmot.audioplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Vinnsla.Lag;
import Vinnsla.lagaListi;
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

    private lagaListi listi;
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

    public void setLagalisti(lagaListi lagaListi) {
        this.listi = lagaListi;
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }

    /**
     * Sér um að velja lag úr listanum
     * 
     * @param mouseEvent Ýtt á lag
     */
    public void onValidLag(MouseEvent mouseEvent) {
        validLag = fxListView.getSelectionModel().getSelectedItem();
        // Image mynd = new Image(validLag.getMynd());
        // fxValidLagMynd.setImage(mynd);
        spilaLag(validLag);
    }

    /**
     * Spilar lag úr listanum sem er valið
     * 
     * @param validLag lag sem á að spila
     */
    private void spilaLag(Lag validLag) {
        System.out.println(validLag.getSkra());
        Media media = new Media(getClass().getResource(validLag.getSkra()).toExternalForm());
        setjaPlayer(media);
        mediaPlayer.play();
    }

    /**
     * Setur lag í mediaPlayer
     * 
     * @param media lag sem á að spila
     */
    private void setjaPlayer(Media media) {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(media);
        /*
         * mediaPlayer.currentTimeProperty().addListener((observable, old, newValue) ->
         * fxProgressBar.setProgress(newValue.divide(validLag.getLengd()).toMillis()));
         */
    }

    /**
     * Sér um að fara heim þegar ýtt er á takka
     */
    public void onHeim() {
        mediaPlayer.stop();
        ViewSwitcher.switchTo(View.HEIMA);
    }

    public void onPlayPause(ActionEvent actionEvent) {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
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
