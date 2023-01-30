/*
File Name:  Main.java
Programmer:  Dante F
Date:  Monday, 30th of January
Description: Simulates a teacher grade book with
             5 students with classes and other extra features.
*/


import java.util.Scanner;  // For User stdin inputs 
import java.util.ArrayList;  // ArrayLists used file reading information
import java.io.File; // import the File class
import java.io.FileNotFoundException; // import class to handle errors

class Main {


    // Delete student from the database
    static ArrayList<Student> deleteStudent(ArrayList<Student> students) {

        System.out.println("\n\nStudent list:");

        // loop through each student in students[][] 
        // print out each student's name with a number next to them
        // to choose from 
        for (int i = 0; i < students.size(); i++) {

            // First name of student
            String firstName = students.get(i).first;

            // Last name of student
            String lastName = students.get(i).last;

            // print students with choice numbers to stdout
            System.out.println((i+1) + ": " + firstName + " " + lastName);
        }


        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose a student to delete from the database.");
        System.out.print("Your choice: ");

        // format input
        int choice = sc.nextInt();

        // get index of the student
        int index = choice - 1;

        // remove the student from the database
        students.remove(index);

        System.out.println("New list:");

        for (int i = 0; i < students.size(); i++) {

            // First name of student
            String firstName = students.get(i).first;

            // Last name of student
            String lastName = students.get(i).last;

            // print students with choice numbers to stdout
            System.out.println((i+1) + ": " + firstName + " " + lastName);
        }

        return students;

    }


    // Edit student tests marks from the database
    static ArrayList<Student> editStudentTest(ArrayList<Student> students) {

        System.out.println("\n\nStudent list:");

        // loop through each student in students[][] 
        // print out each student's name with a number next to them
        // to choose from 
        for (int i = 0; i < students.size(); i++) {

            // First name of student
            String firstName = students.get(i).first;

            // Last name of student
            String lastName = students.get(i).last;


            System.out.println((i+1) + ": " + firstName + " " + lastName);
        }


        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose a student to edit their test for.");
        System.out.print("Your choice: ");

        // format input
        int choice = sc.nextInt();

        // print their tests to stdout

        // student index in the array list
        int index = choice - 1;

        double mark1 = students.get(index).test1;
        double mark2 = students.get(index).test2;
        double mark3 = students.get(index).test3;
        
        System.out.println("1: Test 1 " + mark1 + "%\n2: Test 2 " + mark2 + "%\n3: Test 3 " + mark3 + "%");

        System.out.println("\nChoose a test to edit the score for.");
        System.out.print("Your choice: ");

        // format input
        int testChoice = sc.nextInt();

        System.out.print("Enter The NEW score for Test " + testChoice + ": ");

        // get the new test score from the user
        double newMark = sc.nextDouble();

        // set the new test score for the student
        students.get(index).setTestScore(testChoice, newMark);

        System.out.println("New test score for Test " + testChoice + " is: " + students.get(index).getTestScore(testChoice) + "%");

        return students;

    }


    // delete and edit a student's test marks
    static ArrayList<Student> editStudentInfoMenu(ArrayList<Student> students) {

        // Format Menu
        String message = "\n==== Edit Student Info ====\n"+
                         "1: Edit Student Test Marks\n"+
                         "2: Delete Student\n"+
                         "===========================\n";

        // Print Menu to stdout
        System.out.println(message);

        Scanner sc = new Scanner(System.in);

        System.out.print("Your choice: ");

        // Format input
        String choice = sc.nextLine().toLowerCase();

        switch (choice) {
            case "1":  // edit student test marks
                students = editStudentTest(students);
                break;
            case "2":  // delete student
                students = deleteStudent(students);
                break;
        }

        return students;

    }


    // Calculate the average for the specified test for the whole class
    // and print it to stdout
    static void calculateTestAverage(ArrayList<Student> students, String choice) {

        // set sum of marks for calculating average later
        double sum = 0;

        // loop through 2d array to add up all the marks for the test
        for (int i = 0; i < students.size(); i++) {

            switch (choice) {
                case "1":  // get mark for the first test
                    sum += students.get(i).test1;
                    break;
                case "2":  // get mark for the second test
                    sum += students.get(i).test2;
                    break;
                case "3":  // get mark for the third test
                    sum += students.get(i).test3;
                    break;
            }

        }

        // calculate average for class test
        double average = sum / students.size();

        System.out.println("Class Average for Test #" + choice + ": " + average + "%");

    }


    // display the options to choose the test to calculate the class average for
    static void classTestAverage(ArrayList<Student> students) {

        System.out.println("\n\nTests: \n1: Test #1\n2: Test #2\n3: Test #3\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose a TEST to calculate an average for.");
        System.out.print("Your choice: ");

        // format input
        String choice = sc.nextLine().toLowerCase();

        calculateTestAverage(students, choice);

    }


    // display the student's average over the three tests
    static void calculateStudentAverage(ArrayList<Student> students, int index) {

        // First name of student
        String firstName = students.get(index).first;

        // Last name of student
        String lastName = students.get(index).last;

        double average = students.get(index).getAverage();

        System.out.println("\n" + firstName + " " + lastName + "'s Average: " + average + "%");

    }


    // Calculate a single student's average
    static void studentTestAverage(ArrayList<Student> students) {

        System.out.println("\n\nStudent list:");

        // loop through each student in students[][] 
        for (int i = 0; i < students.size(); i++) {

            // First name of student
            String firstName = students.get(i).first;

            // Last name of student
            String lastName = students.get(i).last;


            System.out.println((i+1) + ": " + firstName + " " + lastName);
        }


        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose a student to calculate an average for.");
        System.out.print("Your choice: ");

        // format input
        int choice = sc.nextInt();

        calculateStudentAverage(students, choice-1);
    }


    // List student info of every student stored in students[][] 2D array
    static void listStudentInfo(ArrayList<Student> students) {

        System.out.println("\n\nFIRSTNAME LASTNAME = MARK1, MARK2, MARK3\n");

        // loop through each student in students[][] 
        for (int i = 0; i < students.size(); i++) {

            // Display student number to user
            // System.out.println("Student #" + (i+1) + ":");

            // First name of student
            String firstName = students.get(i).first;

            // Last name of student
            String lastName = students.get(i).last;

            // Test Mark 1
            // Cast mark1 from string to double
            double mark1 = students.get(i).test1;

            // Test Mark 2
            // Cast mark2 from string to double
            double mark2 =  students.get(i).test2;

            // Test Mark 3
            // Cast mark3 from string to double
            double mark3 =  students.get(i).test3;

            // Print each person's names and grades
            System.out.println(firstName + " " + lastName + " = " + mark1 + "%" + ", " + mark2 + "%" + ", " + mark3 + "%") ;
        }
    }


    // Interactive MENU acts as user interface 
    // Choose options from the student grade book
    static void menu(ArrayList<Student> students) {

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n==== Student Grade Book ====\n"+
                             "1: List All Student Info\n"+
                             "2: Calculate Student Test Average\n"+
                             "3: Calculate Class Test Average\n"+
                             "4: Edit Student Info\n"+
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
                    case "4":  // Calculate the Class Test Average
                        students = editStudentInfoMenu(students);
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


    // Convert the arraylist of string arrays to an arraylist of student objects
    // return an arraylist of students using the custom Student class
    static ArrayList<Student> getStudentObjects(ArrayList<String[]> studentsRaw) {

        // create students arraylist
        ArrayList<Student> students =  new ArrayList<Student>();

        // loop through students
        for (int i = 0; i < studentsRaw.size(); i++) {
            Student newStudent = new Student(studentsRaw.get(i)[0], studentsRaw.get(i)[1], studentsRaw.get(i)[2], studentsRaw.get(i)[3], studentsRaw.get(i)[4]);
            students.add(newStudent);
        }

        return students;
    }


    // Convert the 1D array from file contents into a 2D ArrayList
    // return arraylist of students
    static ArrayList<String[]> getStudents(ArrayList<String> file) {

        // Create blank students arraylist
        ArrayList<String[]> studentsRaw = new ArrayList<String[]>();

        // loop through students information
        for (int i=0; i < file.size(); i+= 5) {
            //                      First        Last           Test 1         Test 2         Test 3
            String[] studentInfo = {file.get(i), file.get(i+1), file.get(i+2), file.get(i+3), file.get(i+4)};

            // add student into to students arraylist
            studentsRaw.add(studentInfo);
        }

        // return list of students info
        return studentsRaw;
    }


    // Read file from current directory
    // and return arraylist of file contents
    static ArrayList<String> readFile() {

        // create file arraylist
        ArrayList<String> file = new ArrayList<String>();

        try {  // try to read the file
            File myObj = new File("students.txt");

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


    // Main method
    public static void main(String[] args) {

        // return contents of file
        ArrayList<String> file = readFile();

        // convert contents of file into a 2d arrray
        ArrayList<String[]> studentsRaw = getStudents(file);

        // convert 2d array into an arraylist of student objects
        ArrayList<Student> students = getStudentObjects(studentsRaw);

        // String[][] students = getStudents();  // Get 2D array of student info

        menu(students);  // Menu interface
        System.out.println("Exited, Goodbye!"); // User has exited the main menu interface

    }
}

