package org.example;

/**
 * Contains the info of Rectangle adapter
 * @author  Joseph JoSUE fORESTAL
 */
public class RectangleAdapter{

    public Rectangle rectangle;

    /***
     * Constructor
     * @param rectangle take  an interface typf of parameter
     */
    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * Set the side of Rectangle adapter
     * @param side the side that is being set
     */
    public void setSide(int side){
        rectangle.setLength(side);
        rectangle.setWidth(side);
    }

    /***
     * Print the area of a square (Rectangle adapter)
     */
    public void printAreaOfSquare(){
        rectangle.printAreaOfRectangle();
    }

    public static void main(String[] args) {
        RectangleAdapter adapter = new RectangleAdapter(new TennisCourt());
        adapter.setSide(4);
        adapter.printAreaOfSquare();

        ChessBoard ch = new ChessBoard(2);
        ch.printAreaOfSquare();

        TennisCourt tenis = new TennisCourt(3,4);
        tenis.printAreaOfRectangle();
    }
}
