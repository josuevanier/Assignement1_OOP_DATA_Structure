package org.example;

/**
 * Contains the info of a tennis court
 * @author  Joseph Josue Forestal
 */
public class TennisCourt implements Rectangle {
    public int length;
    public int width;

    /**
     * Default constructor
     */
    public TennisCourt() {
    }

    /***
     * Constructor
     * @param length int length
     * @param width int width
     */
    public TennisCourt(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Implemented from the rectangle interface prints the area of square
     */
    @Override
    public void printAreaOfRectangle() {
        System.out.println("The area of the Tennis court is " + (this.getLength() * this.getWidth()));
    }

    /**
     * Set the length
     * @param length the length that is being set
     */
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Set the width
     * @param width the width that is being set
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get length
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Get width
     * @return the width
     */
    public int getWidth() {
        return width;
    }
}
