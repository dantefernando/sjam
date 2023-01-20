/*
File Name:  Rectangle.java
Programmer:  Dante F
Date:  Wednesday, January 18, 2023
Description: Rectangles created on a cartesian plane can be represented using this class
            given the bottom left x and y coords, height and width.
*/


public class Rectangle {

    int left, bottom, width, height;


    // return true if rect is entirely within current rectangle
    // looks at two corners of rectangle and checks if they're
    // in range of the containing rectangle
    public boolean contains(Rectangle rect) {
        // left = x, bottom = y
        
        // find 4 coords of each corner of this rectangle
        int[] aBottomLeft = {this.left, this.bottom};
        int[] aBottomRight = {this.left+this.width, this.bottom};
        int[] aTopLeft = {this.left, this.bottom+this.height};
        int[] aTopRight = {this.left+this.width, this.bottom+this.height};

        // find 4 coords of each corner of rect
        int[] bBottomLeft = {rect.left, rect.bottom};
        int[] bBottomRight = {rect.left+rect.width, rect.bottom};
        int[] bTopLeft = {rect.left, rect.bottom+rect.height};
        int[] bTopRight = {rect.left+rect.width, rect.bottom+rect.height};

        // check X bottom left corner of rectangle b
        if ((bBottomLeft[0] >= aBottomLeft[0]) && (bBottomLeft[0] <= aBottomRight[0])) {

            // check Y bottom left corner of rectangle b
            if ((bBottomLeft[1] >= aBottomLeft[1]) && (bBottomLeft[1] <= aTopLeft[1])) {

                // check X top right corner of rectangle b
                if ((bTopRight[0] >= aBottomLeft[0]) && (bTopRight[0] <= aTopRight[0])) {

                    // check Y top right corner of rectangle b
                    if ((bTopRight[1] >= aBottomRight[1]) && (bTopRight[1] <= aTopRight[1])) {

                        return true;

                    }
                }
            }
        }
        return false;
    }


    // Method that returns the perimeter of the rectangle
    public int perimeter() {
        int perimeter = (this.width*2) + (this.height*2);
        return perimeter;
    }


    // Method that returns the area of the rectangle
    public int area() {
        int area = this.width * this.height;
        return area;
    }


    // Method that overrides toString default method
    @Override
    public String toString() {

        // Format the output of the method
        String output = "base: (" + this.left + "," + this.bottom + ") w:" + this.width + " h:" + this.height;

        return output;

    }


    // Constructor with 4 parameters
    public Rectangle(int left, int bottom, int width, int height) {
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;

        // width is less than 0
        if (this.width < 0) {
            this.width = 0;  // Change to 0
        }

        // height is less than 0
        if (this.height < 0) {
            this.height = 0;  // Change to 0
        }
    }


    // Constructor with no parameters
    public Rectangle() {
        this.left = 0;
        this.bottom = 0;
        this.width = 0;
        this.height = 0;
    }


}
