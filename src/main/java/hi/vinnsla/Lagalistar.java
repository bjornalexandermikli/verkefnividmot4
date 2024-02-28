package hi.vinnsla;

import java.io.IOException;

public class Lagalistar {

    public static final String SKRA1 = "src/main/resources/hi/vidmot/media/lagalisti1.txt";
    public static final String SKRA2 = "src/main/resources/hi/vidmot/media/lagalisti2.txt";

    private Lagalisti[] lagalisti = new Lagalisti[2];
    private int index = 0;

    public Lagalistar() {
        Lagalisti lagalisti1 = new Lagalisti();
        try {
            lagalisti1.lesaLog(SKRA1);
            add(lagalisti1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lagalisti lagalisti2 = new Lagalisti();
        try {
            lagalisti2.lesaLog(SKRA2);
            add(lagalisti2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Lagalisti lagalisti) {
        this.lagalisti[index] = lagalisti;
        index++;
    }

    public Lagalisti get(int index) {
        return lagalisti[index];
    }
}
