package org.example;

public class TennisCourt implements Rectangle {

    public int length;
    public int width;

    public TennisCourt(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void printAreaOfRectangle() {

        System.out.println("The area of the Tennis court is " + (this.getLength() * this.getWidth()));
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
