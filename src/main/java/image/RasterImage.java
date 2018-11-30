package image;

import javafx.scene.paint.Color;

public abstract class RasterImage implements Image {
    protected int width;
    protected int height;
    public abstract void setPixelColor(Color color, int x, int y);
    public int getHeight() {
        return this.height;
    }
    public int getWidth() {
        return this.width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public void setPixelsColor(Color[][] pixels){
        for(int i = 0 ; i < this.width ; i++){
            for(int j = 0 ; j < this.height ; j++){
                setPixelColor(pixels[i][j] , i , j);

            }
        }
    }

    public void setPixelsColor(Color color) {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                setPixelColor(color,i,j);

            }
        }
    }

}
