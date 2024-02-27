module hi.vidmot.audioplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens hi.vidmot.audioplayer to javafx.fxml;

    exports hi.vidmot.audioplayer;
}