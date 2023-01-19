
public class Rectangle {

    int left, bottom, width, height;


    // return true if rect is entirely within current rectangle
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

        // rectangleB bottom left x coord in range:
        if (aBottomLeft[0]<=bBottomLeft[0]<=aBottomRight[0]) {  // in range
                                                                //
            // rectangleB bottom left y coord in range:
            if (aBottomLeft[1]<=bBottomLeft[1]<=aTopLeft[1]) {  // in range

                // rectangleb top right x coord in range:
                if (aBottomLeft[0]<=bTopRight[0]<=aBottomRight[0]) {  // in range

                    // rectangleb top right y coord in range:
                    if (aBottomRight[1]<=bTopRight[1]<=aTopRight[1]) {  // in range
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
