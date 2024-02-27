package hi.vinnsla;

public class Askrifandi {
    private String nafn;

    /**
     * Smiður fyrir Askrifanda
     * frumstillir nafn sem "Óþekktur"
     */
    public Askrifandi(){
        this.nafn = "Óþekktur notandi";
    }

    /**
     * Setur nafn
     * @param nafn nafn
     */
    public void set(String nafn){
        this.nafn = nafn;
    }

    /**
     * Skilar nafni
     * @return nafn
     */
    public String get(){
        return this.nafn;
    }
}
