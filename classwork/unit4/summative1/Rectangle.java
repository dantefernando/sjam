/*
File Name:  Rectangle.java
Programmer:  Dante F
Date:  Wednesday, January 18, 2023
Description: Rectangles created on a cartesian plane can be represented using this class
            given the bottom left x and y coords, height and width.
*/


import java.util.ArrayList;  // Import ArrayLists used for coords
import java.util.Collections;  // Import Collections to sort ArrayList

public class Rectangle {

    int left, bottom, width, height;

    // Return rectangle that is created when two rectangles (a and b)
    // are overlapped
    public static Rectangle intersection(Rectangle a, Rectangle b) {

        // find 4 coords of each corner of a
        int[] aBottomLeft = {a.left, a.bottom};
        int[] aBottomRight = {a.left+a.width, a.bottom};
        int[] aTopLeft = {a.left, a.bottom+a.height};
        int[] aTopRight = {a.left+a.width, a.bottom+a.height};

        // find 4 coords of each corner of b
        int[] bBottomLeft = {b.left, b.bottom};
        int[] bBottomRight = {b.left+b.width, b.bottom};
        int[] bTopLeft = {b.left, b.bottom+b.height};
        int[] bTopRight = {b.left+b.width, b.bottom+b.height};

        // Check if any rectangles are inside of each other:
        if (a.contains(b)) {  // rectangle b is completely inside a
            return b;
        }
        else if (b.contains(a)) {  // rectangle a is completely inside b
            return a;
        }
        else if ((aBottomLeft[0] < bTopRight[0]) && (aBottomLeft[1] < bTopRight[1]) && (aTopRight[0] > bBottomLeft[0]) && (aTopRight[1] > bBottomLeft[1])){  // rectangles overlap

            // add all the x values for both triangles into an arraylist to sort
            ArrayList<Integer> xValues = new ArrayList<Integer>();
            xValues.add(aBottomLeft[0]);
            xValues.add(aBottomRight[0]);
            xValues.add(bBottomLeft[0]);
            xValues.add(bBottomRight[0]);

            Collections.sort(xValues);  // sort x values

            // add all the y values for both triangles into an arraylist to sort
            ArrayList<Integer> yValues = new ArrayList<Integer>();
            yValues.add(aTopRight[1]);
            yValues.add(aBottomRight[1]);
            yValues.add(bTopRight[1]);
            yValues.add(bBottomRight[1]);

            Collections.sort(yValues);  // sort y values

            Rectangle intersectionRect = new Rectangle(xValues.get(1), yValues.get(1), xValues.get(2)-xValues.get(1), yValues.get(2)-yValues.get(1));

            return intersectionRect;


        }
        else if ( ((aBottomLeft[0] == bTopRight[0]) || (aTopRight[0] == bBottomLeft[0])) && ((bTopRight[1] > aBottomLeft[1] && bTopRight[1] < aTopLeft[1]) || (bBottomRight[1] > aBottomLeft[1] && bBottomRight[1] < aTopLeft[1])) ) {  // touching x is the same
            // if (bBottomRight[0] == aBottomLeft[0]) {
            //     // moeilijk
            //     Rectangle rec = new Rectangle();
            //     return rec;
            // }
            // moeilijk
            Rectangle rec = new Rectangle();
            return rec;
        }
        else if ( ((aBottomLeft[1] == bTopRight[1]) || (aTopRight[1] == bBottomLeft[1])) && ((aTopRight[0] < bBottomRight[0] && bBottomRight[0] < aTopRight[0]) || (aTopLeft[0] < bBottomLeft[0] && bBottomLeft[0] < aTopRight[0])) ) {  // touching y is the same
            // moeilijk
            Rectangle rec = new Rectangle();
            return rec;

        }
        else {  // rectangles are disjoint
            Rectangle empty = new Rectangle(0,0,0,0);
            return empty;
        }

    }


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
