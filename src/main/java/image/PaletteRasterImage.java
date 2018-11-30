package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    private int width;
    private int height;
    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImage(Color color , int width , int height){
        this.height = height;
        this.width = width;
        createRepresentation();
        palette.add(color);
        for(int i = 0 ; i < width ; i++ ){
            for(int j =  0 ; j < height ; j++){
                indexesOfColors[i][j] = 0;
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels) {
        this.setHeight(Matrices.getColumnCount(pixels));
        this.setWidth(Matrices.getRowCount(pixels));
        createRepresentation();

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (palette.indexOf(pixels[i][j]) != -1) {
                    palette.add(pixels[i][j]);
                    indexesOfColors[i][j] = indexesOfColors.length -1;
                }
                else indexesOfColors[i][j] =palette.indexOf(pixels[i][j]);
            }
        }
    }

    public void createRepresentation(){
        this.palette = new ArrayList<>();
        this.indexesOfColors = new int[this.height][this.width];
    }


    @Override
    public Color getPixelColor(int x, int y) {
        return null;
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
    public void setHeight(int height){
        this.height = height;
    }
}
