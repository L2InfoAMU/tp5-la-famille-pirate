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
        System.out.println(pixels.length);
        System.out.println(pixels[0].length);


        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {

                setPixelColor(pixels[i][j],i,j);


                }
            }
        }


    public void createRepresentation(){
        this.palette = new ArrayList<>();
        this.indexesOfColors = new int[this.width][this.height];
    }

    public void setPixelsColor(Color color){
        palette.add(color);
        for(int i = 0 ; i < width ; i++ ){
            for(int j =  0 ; j < height ; j++){
                indexesOfColors[i][j] = 0;
            }
        }
    }
    public void setPixelsColor(Color[][] pixels){
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                setPixelColor(pixels[i][j] , i , j);
            }
        }
    }
    public void setPixelColor(Color color, int x, int y){
        if(!palette.contains(color)) {
            palette.add(color);
            indexesOfColors[x][y] = palette.indexOf(color);
        }
        else indexesOfColors[x][y] = palette.indexOf(color);

    }

    public Color getPixelColor(int x, int y){
        int index = indexesOfColors[x][y];
        return palette.get(index);
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
