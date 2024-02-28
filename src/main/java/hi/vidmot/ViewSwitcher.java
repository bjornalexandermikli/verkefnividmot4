package hi.vidmot;

import hi.vinnsla.Lagalisti;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {
    private static Scene scene;

    /**
     * Stillir upp senu
     * 
     * @param scene Sena
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Skiptir milli sena
     * 
     * @param view Sjónarhorn sem er breytt
     */
    public static void switchTo(View view) {
        try {
            Parent root;
            root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFxml()));
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Skiptir milli sena
     * 
     * @param view      Sjónarhorn sem breytist
     * @param lagalisti Listi sem á að sýna
     * @param mynd      mynd
     */
    public static void switchTo(View view, Lagalisti lagalisti, String mynd) {
        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFxml()));
            root = loader.load();
            ListiController listiController = loader.getController();
            listiController.setLagalisti(lagalisti, mynd);
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
