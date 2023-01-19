/*
File Name:  Main.java
Programmer:  Dante F
Date:  Wednesday, January 18, 2023
Description: Creating a rectangle class
*/

// import java.util.Scanner;  // For User stdin inputs and to read files
// import java.util.ArrayList;  // Import ArrayLists used for database
// import java.io.File; // import the File class
// import java.io.FileNotFoundException; // import class to handle errors


class Main {


    // Main method
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(-1,-2,21,9);

        System.out.println(rect.left);
        System.out.println(rect.bottom);
        System.out.println(rect.width);
        System.out.println(rect.height);

        System.out.println(rect.toString());
        System.out.println(rect.area());
        System.out.println(rect.perimeter());

    }

}

