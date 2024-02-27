package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lagalisti {
    ObservableList<Lag> listi;
    private int index = 0;

    public Lagalisti() {
        this.listi = FXCollections.observableArrayList();
    }

    /**
     * Les inn log frá skrá og býr til lista af logum
     * @param skra nafn á skrá
     * @throws IOException ef ekki tókst að lesa skrá
     */
    public void lesaLog(String skra) throws IOException{
        // lesa skrá
        String line = new String(Files.readAllBytes(Paths.get(skra)));
        String[] lina = line.split("\n");
        for (String s : lina) {
            String[] l = s.split(" ");
            Lag lag = new Lag(l[0], l[1], l[2] , l[3]);
            listi.add(lag);
            index++;
        }
    }

    public void add(Lag lag){
        listi.add(lag);
        index++;
    }

    public Lag get(int index){
        return listi.get(index);
    }

    public ObservableList<Lag> getListi() {
        return listi;
    }
}
