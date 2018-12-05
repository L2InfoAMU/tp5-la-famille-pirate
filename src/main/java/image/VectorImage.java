package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VectorImage implements Image {

    private int width;
    private int height;
    private List<Shape> shapes;


    public VectorImage(List<Shape> shapes , int width , int height ){
        this.shapes = new ArrayList<>(shapes);
        this.setHeight(height);
        this.setWidth(width);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        Point point = new Point(x, y);
        for (Shape shape : shapes) {
            if (shape.contains(point)) {
                return shape.getColor();
            }
        }
        return Color.WHITE;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }


    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
