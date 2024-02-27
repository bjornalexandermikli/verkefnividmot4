package Vinnsla;

import java.io.IOException;

public class lagaListar {

    public static final String skra1 = "src/main/resources/hi/vidmot/media/lagalisti1.txt";

    private lagaListi[] lagaListi = new lagaListi[2];
    private int index = 0;

    public lagaListar() {
        lagaListi lagalisti1 = new lagaListi();
        try {
            lagalisti1.lesaLog(skra1);
            add(lagalisti1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(lagaListi lagalisti) {
        this.lagaListi[index] = lagalisti;
        index++;
    }

    public lagaListi get(int index) {
        return lagaListi[index];
    }
}
