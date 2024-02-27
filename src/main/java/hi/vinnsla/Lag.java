package hi.vinnsla;

public class Lag {
    private String skra;
    private String lag;
    private String lengd;
    private String mynd;

    /**
     * Smiður fyrir Lag
     * @param skra skrá
     * @param lag lag
     * @param lengd lengd
     * @param mynd mynd
     */
    public Lag(String skra, String lag, String lengd, String mynd) {
        this.skra = skra;
        this.lag = lag;
        this.lengd = lengd;
        this.mynd = mynd;
    }

    /**
     * Skilar skrá
     * @return skrá
     */
    public String getSkra() {
        return skra;
    }

    /**
     * Skilar lagi
     * @return lag
     */
    public String getLag() {
        return lag;
    }

    /**
     * Skilar lengd lags
     * @return lengd
     */
    public String getLengd() {
        return lengd;
    }

    /**
     * Skilar mynd
     * @return mynd
     */
    public String getMynd() {
        return mynd;
    }

    @Override
    public String toString() {
        return lag;
    }
}
