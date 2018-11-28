package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {
    private int width;
    private int height;
    private Color color;
    private Color[][] colors;

    public BruteRasterImage(Color color, int width, int height){
        this.color = color;
        this.height = height;
        this.width = width;
    }

    public BruteRasterImage (Color[][] colors){
        createRepresentation();
        this.colors = colors.clone();

    }
    public void createRepresentation(){
        this.colors = new Color[this.height][this.width];
    }



    @Override
    public Color getPixelColor(int x, int y) {
        return this.colors[x][y];
    }

    public void setPixelColor(Color color, int x, int y){
        this.colors[x][y] = color;
    }

    private void setPixelsColor(Color[][] pixels){
        for(int i = 0 ; i < this.width ; i++){
            for(int j = 0 ; j < this.height ; j++){
                this.colors[i][j] = pixels[i][j];

            }
        }
    }

    private void setPixelsColor(Color color) {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.colors[i][j] = color;

            }
        }
    }


    @Override
    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height{
        this.height = height;
    }

}
