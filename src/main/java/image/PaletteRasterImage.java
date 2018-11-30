package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage implements Image {

    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImage(Color color , int width , int height) {

        super(color,width,height);
    }

    public PaletteRasterImage(Color[][] pixels) {
        super(pixels);
    }

    @Override
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
