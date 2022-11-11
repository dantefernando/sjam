/*
File Name:  Main.java
Programmer:  Dante F
Date:  Friday, Novemember 11, 2022
Description: Simulates a teacher grade book with
             5 students
*/


import java.util.Scanner;  // For User stdin inputs 

class Main {


    // Interactive MENU acts as user interface 
    // Choose options from the student grade book
    static void menu(String[][] students) {

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n==== Student Grade Book ====\n"+
                             "1: List All Student Info\n"+
                             "2: Student Test Average\n"+
                             "3: Class Test Average\n"+
                             "===========================\n"+
                             "0: Exit Program\n"+
                             "===========================\n";

            // Print Menu to stdout
            System.out.println(message);

            Scanner sc = new Scanner(System.in);

            // Choice loop
            boolean loop = true;

            // Loop until user enters valid input
            // if loop == false break loop
            while (loop == true) {

                System.out.print("Your choice: ");

                // format input
                String choice = sc.nextLine().toLowerCase();

                switch (choice) {
                    case "1":  // List all the student info
                        loop = false;  // User valid input break loop
                        break;
                    case "2":  // Student Test Average
                        loop = false;  // User valid input break loop
                        break;
                    case "3":  // Class Test Average
                        loop = false;  // User valid input break loop
                        break;
                    case "0":  // User wants to exit program
                        loop = false;  // User valid input break loop
                        menuLoop = false; // Stop menu loop and exit program
                        break;
                    default:  // User enters invalid input (no exceptions for erroneous user inputs)
                        System.out.println("Please choose a valid option, try again...\n");
                }
            }
        }
    }


    // Get information of 5 students on startup
    // return 2D array of student information
    static String[][] getStudents() {

        Scanner sc = new Scanner(System.in);

        // Initialize 2D Array for student info
        String[][] students = new String[5][5];

        // Get information of 5 students
        for (int i = 0; i < 5; i++) {

            // Display student number to user
            System.out.println("Student #" + (i+1) + ":");

            // Get First name of student
            System.out.print("\nEnter Student First Name: ");
            students[i][0] = sc.nextLine();

            // Get Last name of student
            System.out.print("\nEnter Student Last Name: ");
            students[i][1] = sc.nextLine();

            // Get student test mark 1
            System.out.print("\nEnter Student Test mark 1: ");
            students[i][2] = sc.nextLine();

            // Get student test mark 2
            System.out.print("\nEnter Student Test mark 2: ");
            students[i][3] = sc.nextLine();

            // Get student test mark 3
            System.out.print("\nEnter Student Test mark 3: ");
            students[i][4] = sc.nextLine();

        }

        // Return student 2D array
        return students;
    }


    // Main method
    public static void main(String[] args) {

        String[][] students = getStudents();  // Get 2D array of student info
        menu(students);  // Menu interface
        System.out.println("Exited, Goodbye!"); // User has exited the main menu interface

    }
}

