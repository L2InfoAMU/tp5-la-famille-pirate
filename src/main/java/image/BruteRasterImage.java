package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage implements Image {

    private Color color;
    private Color[][] colors;

    public BruteRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;
        createRepresentation();


        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.colors[i][j] = color;
            }
        }
        ;
    }

    public BruteRasterImage (Color[][] colors){
       this.setHeight(Matrices.getColumnCount(colors));
       this.setWidth(Matrices.getRowCount(colors));

        createRepresentation();
        //this.colors = colors.clone();
        this.setPixelsColor(colors);

    }
    public void createRepresentation(){
        this.colors = new Color[this.width][this.height];
    }



    @Override
    public Color getPixelColor(int x, int y) {

        return this.colors[x][y];
    }
    @Override
    public void setPixelColor(Color color, int x, int y){
        this.colors[x][y] = color;
    }







}
