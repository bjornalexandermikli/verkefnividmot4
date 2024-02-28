package hi.vidmot;

public enum View {
    HEIMA("heima-view.fxml"),
    LISTI("listi-view.fxml");

    private String fxml;

    /**
     * endursetur fxml
     * 
     * @param fxml skráin
     */
    private View(String fxml) {
        this.fxml = fxml;
    }

    /**
     * gefur fxml (skrá)
     * 
     * @return skráin
     */
    public String getFxml() {
        return fxml;
    }
}
