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
     * Frumstillir listann og tengir við ListView
     */
    public void initialize() {
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }

    /**
     * Setur lagalistann í listann og myndina í toppinn
     * @param lagalisti listi af lögum
     * @param mynd myndin sem á að setja á toppinn
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
     * Sér um að velja lag úr listanum
     * @param mouseEvent Ýtt á lag
     */
    public void onValidLag(MouseEvent mouseEvent) {
        validLag = fxListView.getSelectionModel().getSelectedItem();
        System.out.println(validLag.getLag());
        Image mynd = new Image(getClass().getResource(validLag.getMynd()).toExternalForm());
        fxValidLagMynd.setImage(mynd);
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
        tengjaPlayTakka();
        setStopTime();

    }

    /**
     * Setur stopTime á mediaPlayer
     * Þegar lag klárast þá fer það í næsta lag
     */
    private void setStopTime(){
        mediaPlayer.setStopTime(mediaPlayer.getMedia().getDuration());
        mediaPlayer.setOnEndOfMedia(this::naestaLag);
    }

    /**
     * Fer í næsta lag í listanum
     */
    private void naestaLag(){
        int index = fxListView.getSelectionModel().getSelectedIndex();
        if(index < fxListView.getItems().size() - 1){
            fxListView.getSelectionModel().select(index + 1);
            onValidLag(null);
        }
    }

    /**
     * Tengir play/pause takka við mediaPlayer til að uppfæra mynd
     */
    private void tengjaPlayTakka(){
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == MediaPlayer.Status.PLAYING) {
                fxPlayPause.setImage(new Image(getClass().getResource("media/pause.png").toExternalForm()));
            } else {
                fxPlayPause.setImage(new Image(getClass().getResource("media/play.png").toExternalForm()));
            }
        });
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

    /**
     * Sér um að spila eða pása lag
     * @param actionEvent Ýtt á play/pause takka
     */
    public void onPlayPause(ActionEvent actionEvent) {
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
            mediaPlayer.pause();
        } else {
            mediaPlayer.play();
        }
    }
}
