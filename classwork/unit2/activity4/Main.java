/*
File Name:  Main.java
Programmer:  Dante F
Date:  Friday, Novemember 11, 2022
Description: Simulates a teacher grade book with
             5 students
*/


import java.util.Scanner;  // For User stdin inputs 

class Main {

    // Calculate the average for the specified test for the whole class
    // and print it to stdout
    static void calculateTestAverage(String[][] students, int index) {

        // set sum of marks for calculating average later
        double sum = 0;

        // loop through 2d array to add up all the marks for the test
        for (int i = 0; i < students.length; i++) {
            
            // Cast string mark to double for calculations 
            double mark = Double.parseDouble(students[i][index]);

            // Add mark to sum
            sum += mark;

        }

        // calculate average for class test
        double average = sum / 5;

        System.out.println("Class Average for Test #" + (index-1) + ": " + average + "%");

    }


    // display the options to choose the test to calculate the class average for
    static void classTestAverage(String[][] students) {

        System.out.println("\n\nTests: \n1: Test #1\n2: Test #2\n3: Test #3\n");

        Scanner sc = new Scanner(System.in);

        // Choice loop
        boolean loop = true;

        // Loop until user enters valid input
        // if loop == false break loop
        while (loop == true) {

            System.out.println("\nChoose a TEST to calculate an average for.");
            System.out.print("Your choice: ");

            // format input
            String choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "1":  // Calculate the class average for the first test
                    calculateTestAverage(students, 2);
                    loop = false;  // User valid input break loop
                    break;
                case "2":  // Calculate the class average for the second test
                    calculateTestAverage(students, 3);
                    loop = false;  // User valid input break loop
                    break;
                case "3":  // Calculate the class average for the third test
                    calculateTestAverage(students, 4);
                    loop = false;  // User valid input break loop
                    break;
                default:  // User enters invalid input (no exceptions for erroneous user inputs)
                    System.out.println("Please choose a valid option, try again...\n");
            }
        }

    }


    static void calculateStudentAverage(String[][] students, int index) {

        // First name of student
        String firstName = students[index][0];

        // Last name of student
        String lastName = students[index][1];

        // Test Mark 1
        double mark1 = Double.parseDouble(students[index][2]);

        // Test Mark 2
        double mark2 =  Double.parseDouble(students[index][3]);

        // Test Mark 3
        double mark3 =  Double.parseDouble(students[index][4]);

        double average = (mark1 + mark2 + mark3) / 3;

        System.out.println("\n" + firstName + " " + lastName + "'s Average: " + average + "%");

    }


    // Calculate a single student's average
    static void studentTestAverage(String[][] students) {

        System.out.println("\n\nStudent list:");

        // loop through each student in students[][] 
        for (int i = 0; i < students.length; i++) {

            // First name of student
            String firstName = students[i][0];

            // Last name of student
            String lastName = students[i][1];


            System.out.println((i+1) + ": " + firstName + " " + lastName);
        }


        Scanner sc = new Scanner(System.in);

        // Choice loop
        boolean loop = true;

        // Loop until user enters valid input
        // if loop == false break loop
        while (loop == true) {

            System.out.println("\nChoose a student to calculate an average for.");
            System.out.print("Your choice: ");

            // format input
            String choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "1":  // Calculate the student average for the first student
                    calculateStudentAverage(students, 0);
                    loop = false;  // User valid input break loop
                    break;
                case "2":   // Calculate the student average for the second student
                    calculateStudentAverage(students, 1);
                    loop = false;  // User valid input break loop
                    break;
                case "3":  // Calculate the student average for the third student
                    calculateStudentAverage(students, 2);
                    loop = false;  // User valid input break loop
                    break;
                case "4":  // Calculate the student average for the fourth student
                    calculateStudentAverage(students, 3);
                    loop = false;  // User valid input break loop
                    break;
                case "5":  // Calculate the student average for the fifth student
                    calculateStudentAverage(students, 4);
                    loop = false;  // User valid input break loop
                    break;
                default:  // User enters invalid input (no exceptions for erroneous user inputs)
                    System.out.println("Please choose a valid option, try again...\n");
            }
        }
    }


    // List student info of every student stored in students[][] 2D array
    static void listStudentInfo(String[][] students) {

        System.out.println("\n\nFIRSTNAME LASTNAME = MARK1, MARK2, MARK3\n");

        // loop through each student in students[][] 
        for (int i = 0; i < students.length; i++) {

            // Display student number to user
            // System.out.println("Student #" + (i+1) + ":");

            // First name of student
            String firstName = students[i][0];

            // Last name of student
            String lastName = students[i][1];

            // Test Mark 1
            // Cast mark1 from string to double
            double mark1 = Double.parseDouble(students[i][2]);

            // Test Mark 2
            // Cast mark2 from string to double
            double mark2 =  Double.parseDouble(students[i][3]);

            // Test Mark 3
            // Cast mark3 from string to double
            double mark3 =  Double.parseDouble(students[i][4]);

            // Print each person's names and grades
            System.out.println(firstName + " " + lastName + " = " + mark1 + "%" + ", " + mark2 + "%" + ", " + mark3 + "%") ;
        }
    }

    // Interactive MENU acts as user interface 
    // Choose options from the student grade book
    static void menu(String[][] students) {

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n==== Student Grade Book ====\n"+
                             "1: List All Student Info\n"+
                             "2: Calculate Student Test Average\n"+
                             "3: Calculate Class Test Average\n"+
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

                // Format input
                String choice = sc.nextLine().toLowerCase();

                switch (choice) {
                    case "1":  // List all the student info
                        listStudentInfo(students);
                        loop = false;  // User valid input break loop
                        break;
                    case "2":  // Calculate the Student Test Average
                        studentTestAverage(students);
                        loop = false;  // User valid input break loop
                        break;
                    case "3":  // Calculate the Class Test Average
                        classTestAverage(students);
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


    // Get information of 5 students on startup from user
    // return 2D array of student information
    static String[][] getStudents() {

        Scanner sc = new Scanner(System.in);

        // Initialize 2D Array for student info
        String[][] students = new String[5][5];

        // Get information of 5 students
        for (int i = 0; i < 5; i++) {

            // Display student number to user
            System.out.println("Student #" + (i+1) + ":");

            // Get First name of student from user
            System.out.print("\nEnter Student First Name: ");
            students[i][0] = sc.nextLine();

            // Get Last name of student from user
            System.out.print("\nEnter Student Last Name: ");
            students[i][1] = sc.nextLine();

            // Get student test mark 1 from user
            System.out.print("\nEnter Student Test mark 1: ");
            students[i][2] = sc.nextLine();

            // Get student test mark 2 from user
            System.out.print("\nEnter Student Test mark 2: ");
            students[i][3] = sc.nextLine();

            // Get student test mark 3 from user
            System.out.print("\nEnter Student Test mark 3: ");
            students[i][4] = sc.nextLine();

        }

        // Return student 2D array
        return students;
    }


    // Main method
    public static void main(String[] args) {

        String[][] students = getStudents();  // Get 2D array of student info

        // String[][] students = {
        //     {"Dante", "Fernando", "88.5", "99.5", "78.5"},
        //     {"Ilhan", "Shahril", "90.2", "18.2", "100.0"},
        //     {"Dan", "Golzio", "12.3", "88.1", "99.0"},
        //     {"Ayman", "Amghar", "75.2", "80.4", "99.9"}, 
        //     {"Royce", "Chan", "99", "99.5", "98.5"}
    // };

        menu(students);  // Menu interface
        System.out.println("Exited, Goodbye!"); // User has exited the main menu interface

    }
}

