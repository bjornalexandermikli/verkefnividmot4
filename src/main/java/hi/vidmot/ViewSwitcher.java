package hi.vidmot;

import hi.vinnsla.Lagalisti;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {
    private static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(View view) {
        try {
            Parent root;
                root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFxml()));
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void switchTo(View view, Lagalisti lagalisti) {
        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFxml()));
            root = loader.load();
            ListiController listiController = loader.getController();
            listiController.setLagalisti(lagalisti);
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
