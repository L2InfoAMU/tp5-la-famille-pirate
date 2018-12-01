package image;

import javafx.scene.paint.Color;

import java.util.HashMap;

public class SparseRasterImage extends RasterImage {

    HashMap<Point,Color> pixelsMap;

    public SparseRasterImage(Color color , int width  , int height){
        super(color,width,height);
    }

    public  SparseRasterImage(Color[][] pixels){
        super(pixels);

    }


    @Override
    public void createRepresentation() {
        this.pixelsMap = new HashMap<>();
    }

    @Override
    public void setPixelColor(Color color , int x , int y){
         pixelsMap.put(new Point(x,y),color);

    }



    @Override
    public Color getPixelColor(int x, int y) {
        return pixelsMap.getOrDefault(new Point(x,y),Color.WHITE);
    }
}
