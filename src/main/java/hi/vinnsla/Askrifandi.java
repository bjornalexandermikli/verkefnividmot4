package hi.vinnsla;

public class Askrifandi {
    private String nafn;

    /**
     * Smiður fyrir Askrifanda hluti
     * 
     * 
     * Byrjar sem unknown
     */
    public Askrifandi() {
        this.nafn = "Unknown user";
    }

    /**
     * Setter fyrir nafn notanda
     * 
     * @param nafn nafnið
     */
    public void set(String nafn) {
        this.nafn = nafn;
    }

    /**
     * getter aðferð fyrir nafnið
     * 
     * @return nafnið
     */
    public String get() {
        return this.nafn;
    }
}
