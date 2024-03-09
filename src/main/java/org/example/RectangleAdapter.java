package org.example;

public class RectangleAdapter{

    public Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void setSide(int side){
        rectangle.setLength(side);
        rectangle.setWidth(side);
    }


    public void printAreaOfSquare(){
        rectangle.printAreaOfRectangle();
    }
}
