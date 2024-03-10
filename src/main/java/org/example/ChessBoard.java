package org.example;

/***
 * Contains the info of a chess board
 * @author Joseph Josue Forestal
 */
public class ChessBoard implements Square {
    public int sideLength;

    /**
     * Default constructor
     */
    public ChessBoard() {
    }

    /**
     * Constructor
     * @param side take a side as a parameter
     */
    public ChessBoard(int side) {
        this.sideLength = side;
    }

    /**
     *Implements of the method print square based on the interface square
     */
    @Override
    public void printAreaOfSquare() {
        System.out.println("Area of the chessBoard " + (Math.pow(getSideLength(),2)));
    }

    /**
     * Get the side length
     * @return the side length
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     * Set the side length  and implementation of the method set side from the interface Square
     * @param side the side that is being set
     */
    @Override
    public void setSide(int side) {
        this.sideLength  = side;
    }
}
