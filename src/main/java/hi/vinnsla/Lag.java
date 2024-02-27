package hi.vinnsla;

public class Lag {
    private String skra;
    private String lag;
    private String lengd;
    private String mynd;

    public Lag(String skra, String lag, String lengd, String mynd) {
        this.skra = skra;
        this.lag = lag;
        this.lengd = lengd;
        this.mynd = mynd;
    }

    public String getSkra() {
        return skra;
    }

    public String getLag() {
        return lag;
    }

    public String getLengd() {
        return lengd;
    }

    public String getMynd() {
        return mynd;
    }

    @Override
    public String toString() {
        return lag;
    }
}
