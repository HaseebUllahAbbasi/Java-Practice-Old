package Main_Pakcage;

import javafx.scene.image.ImageView;

public class MyImageView extends ImageView {
    private double offsetX = 0;
    private double offsetY = 0;
    private double originMinX = 0;
    private double originMinY = 0;

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public double getOriginMinX() {
        return originMinX;
    }

    public void setOriginMinX(double originMinX) {
        this.originMinX = originMinX;
    }

    public double getOriginMinY() {
        return originMinY;
    }

    public void setOriginMinY(double originMinY) {
        this.originMinY = originMinY;
    }
}
