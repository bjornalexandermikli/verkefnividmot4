package hi.vidmot;

public enum View {
    HEIMA("heima-view.fxml"),
    LISTI("listi-view.fxml");
    
    private String fxml;

    private View(String fxml) {
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }
}
