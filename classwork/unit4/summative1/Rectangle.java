
public class Rectangle {

    int left, bottom, width, height;

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
