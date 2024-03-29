/*
File Name:  Main.java
Programmer:  Dante F
Date:  Wednesday, November 30, 2022
Description: User is able to enter a number and the program will search for the book using the reference number in Booklist.txt
*/

import java.util.Scanner;  // For User stdin inputs and to read files
import java.util.ArrayList;  // Import ArrayLists used for database
import java.io.File; // import the File class
import java.io.FileNotFoundException; // import class to handle errors


class Main {


    // perform a binary search on the file
    // for the reference number
    static void binarySearch(String num, ArrayList<String> file) {

        // new arraylist with just reference nums in them
        ArrayList<Integer> refNums = new ArrayList<Integer>();

        // Create array with just reference numbers in them
        for (int i = 0; i < file.size(); i += 2) {
            refNums.add(Integer.parseInt(file.get(i)));
        }


        int left = 0;  // left index of array list
        int right = refNums.size() - 1;  // Right index of arraylist

        while (left <= right) {

            // find middle of arraylist
            int mid = Math.floorDiv((right + left),2);

            if (refNums.get(mid) == Integer.parseInt(num)) {  // middle is target num
                //BOOK FOUND!
                String title = file.get((mid*2) + 1);  // Name of book

                String msg = "BINARY SEARCH RESULTS:\n" +
                    "\nBook Reference Number: " + file.get((mid*2)) +
                    "\nBook Title: " + title + "\n";

                System.out.println(msg);
                return;
            }
            else if (refNums.get(mid) < Integer.parseInt(num)) {  // target num is greater than middle
                left = mid + 1;
            }
            else {  // target num is less than middle 
                right = mid - 1;
            }

        }

        System.out.println("Binary search unsuccessful, didn't find reference number...");

    }


    // perform a linear search on the file
    // for the reference number
    static void linearSearch(String num, ArrayList<String> file) {

        for (int i = 0; i < file.size(); i += 2) {
            if (num.equals(file.get(i))) {  // found ref num

                String title = file.get(i+1);  // Name of book

                String msg = "LINEAR SEARCH RESULTS:\n" +
                    "\nBook Reference Number: " + num +
                    "\nBook Title: " + title + "\n";

                System.out.println(msg);
                return;
            }
        }
        System.out.println("Book not found using linear search, try again...");
    }


    // Read file from current directory
    // and return arraylist of file contents
    static ArrayList<String> getFile() {

        // create file arraylist
        ArrayList<String> file = new ArrayList<String>();

        try {  // try to read the file
            File myObj = new File("booklist.txt");

            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();  // read line
                file.add(data);  // Add to file arraylist
            }
            myReader.close(); // close the file
        }
        catch (FileNotFoundException e) {  // File not found
            System.out.println("An error occurred. File not found.");
            System.out.println("Exiting...");
            System.exit(1);
            // e.printStackTrace();  // trace how the error occured
        }

        // return array list of file contents
        return file;

    }


    static void search(String num, ArrayList<String> file) {

        // search using linear search
        linearSearch(num, file);
        
        // search using binary search
        binarySearch(num, file);

    }


    // get reference num from user and return it
    static String getNum() {

        Scanner sc = new Scanner(System.in);

        // get reference num
        System.out.print("Enter reference number to search up: ");
        String num = sc.nextLine();
        System.out.println();

        return num;

    }


    // Main method
    public static void main(String[] args) {

        boolean loop = true;

        while (loop == true) {

            // read file and get array of file contents
            ArrayList<String> file = getFile();

            String num = getNum();  // get reference number
                                    //
            search(num, file);  // search using reference number

        }
        System.out.println("Exited, Goodbye!"); // User has exited 
    }
}

