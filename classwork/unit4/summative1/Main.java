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

        Rectangle a = new Rectangle(10,2,10,9);
        Rectangle b = new Rectangle(10,2,10,9);

        // Rectangle b = new Rectangle(10,2,10,9);
        // Rectangle a = new Rectangle(11,3,5,6);

        System.out.println(a.contains(b));


    }

}

