package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage implements Image {


    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImage(Color color , int width , int height){
        this.height = height;
        this.width = width;
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels) {
        this.setHeight(Matrices.getColumnCount(pixels));
        this.setWidth(Matrices.getRowCount(pixels));
        createRepresentation();
        System.out.println(pixels.length);
        System.out.println(pixels[0].length);


        setPixelsColor(pixels);
    }


    public void createRepresentation(){
        this.palette = new ArrayList<>();
        this.indexesOfColors = new int[this.width][this.height];
    }

   @Override
    public void setPixelColor(Color color, int x, int y){
        if(!palette.contains(color)) {
            palette.add(color);
            indexesOfColors[x][y] = palette.indexOf(color);
        }
        else indexesOfColors[x][y] = palette.indexOf(color);

    }

    public Color getPixelColor(int x, int y){
        return palette.get(indexesOfColors[x][y]);
    }

}
