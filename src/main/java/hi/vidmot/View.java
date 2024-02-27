package hi.vidmot;

public enum View {
    HEIMA("heima-view.fxml"),
    LISTI("listi-view.fxml");

    private String fxml;

    /**
     * Frumstillir fxml skrá
     * @param fxml skrá
     */
    private View(String fxml) {
        this.fxml = fxml;
    }

    /**
     * Skilar fxml skrá
     * @return fxml skrá
     */
    public String getFxml() {
        return fxml;
    }
}
