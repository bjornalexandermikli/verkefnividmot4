package hi.vidmot;

import hi.vinnsla.Lag;
import hi.vinnsla.Lagalisti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ListiController {
    @FXML
    private ListView<Lag> fxListView;
    @FXML
    private ImageView fxValidLagMynd;
    @FXML
    private ImageView fxPlayPause;
    @FXML
    private ProgressBar fxProgressBar;
    @FXML
    private ImageView fxTopImage;

    private Lagalisti listi;
    private Lag validLag;
    private MediaPlayer mediaPlayer;

    /**
     * Frumstillir lista
     * - tengir síðan við ListView
     */
    public void initialize() {
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }

    /**
     * setur lagalista og mynd
     * 
     * @param lagalisti lög listi
     * @param mynd      myndin
     */
    public void setLagalisti(Lagalisti lagalisti, String mynd) {
        this.listi = lagalisti;
        Image myndin = new Image(getClass().getResource(mynd).toExternalForm());
        fxTopImage.setImage(myndin);
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }

    /**
     * velur lag
     * 
     * @param mouseEvent Smellt á lag (viðmót)
     */
    public void onValidLag(MouseEvent mouseEvent) {
        validLag = fxListView.getSelectionModel().getSelectedItem();
        Image mynd = new Image(getClass().getResource(validLag.getMynd()).toExternalForm());
        fxValidLagMynd.setImage(mynd);
        spilaLag(validLag);
    }

    private void spilaLag(Lag validLag) {
        File file = new File(getClass().getResource(validLag.getSkra()).getFile());
        Media media = new Media(file.toURI().toString());
        setjaPlayer(media);
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    /**
     * setur í media spilara
     * 
     * @param media lagið
     */
    private void setjaPlayer(Media media) {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.currentTimeProperty().addListener((observable, old, newValue) -> fxProgressBar
                .setProgress(newValue.divide(Double.parseDouble(validLag.getLengd())).toMillis()));
        tengjaPlayTakka();
        setStopTime();

    }

    private void setStopTime() {
        mediaPlayer.setStopTime(mediaPlayer.getMedia().getDuration());
        mediaPlayer.setOnEndOfMedia(this::naestaLag);
    }

    private void naestaLag() {
        int index = fxListView.getSelectionModel().getSelectedIndex();
        if (index < fxListView.getItems().size() - 1) {
            fxListView.getSelectionModel().select(index + 1);
            onValidLag(null);
        }
    }

    /**
     * Tengir takka til að mynd breytist
     */
    private void tengjaPlayTakka() {
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == MediaPlayer.Status.PLAYING) {
                fxPlayPause.setImage(new Image(getClass().getResource("media/pause.png").toExternalForm()));
            } else {
                fxPlayPause.setImage(new Image(getClass().getResource("media/play.png").toExternalForm()));
            }
        });
    }

    /**
     * fer heim
     */
    public void onHeim() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        ViewSwitcher.switchTo(View.HEIMA);
    }

    /**
     * spilar/stöðvar
     * 
     * @param actionEvent afspilun/stöðva takki
     */
    public void onPlayPause(ActionEvent actionEvent) {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.play();
        }
    }
}
