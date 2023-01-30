/*
File Name:  Main.java
Programmer:  Dante F
Date:  Monday, 30th of January
Description: Simulates a teacher grade book with
             5 students with classes and other extra features.
             Keep track of student averages and class test scores.
             Utilizes new 'student' class.
*/

import java.util.Scanner;  // For User stdin inputs 
import java.util.ArrayList;  // ArrayLists used file reading information
import java.io.File; // import the File class
import java.io.FileNotFoundException; // import class to handle errors
import java.io.FileWriter;  // used to write files to disk
import java.io.IOException;  // exception for when writing to files


// Main class
// Handles menu, user interface, calculations and all the heavy lifting
class Main {


    // Saves and Writes the student database to the disk as a file
    // doesn't return anything.
    // students: student database
    static void writeDatabase(ArrayList<Student> students) {

        // try except catch to catch any error exceptions if possible
        try {

            // file writer object used to write the file
            FileWriter myWriter = new FileWriter("students.txt");

            for (int i = 0; i < students.size(); i++) {

                // Write to file line by line
                myWriter.write(students.get(i).first + "\n");
                myWriter.write(students.get(i).last + "\n");
                myWriter.write(Double.toString(students.get(i).test1) + "\n");
                myWriter.write(Double.toString(students.get(i).test2) + "\n");
                myWriter.write(Double.toString(students.get(i).test3) + "\n");
            }

            // Close the file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {  // catch exception
            System.out.println("An error occurred. Unable to write database to disk...");
            e.printStackTrace();  // print error
        }
    }


    // Confirms if the user wants to save any changes made to the students directory
    // to disk.
    // if user wants to write the file to disk saveDatabase calls writeDatabase and writes the
    // file to the disk
    static void saveDatabase(ArrayList<Student> students) {

        System.out.println("Confirming the save will save any changes made\n" + 
                "to the student database to a file in the current\n" +
                "working directory with the name \"students.txt\" ");

        System.out.println("Continue? (Y)es or (N)o?");

        Scanner sc = new Scanner(System.in);

        System.out.print("Your choice: ");

        // formats the choice input
        String choice = sc.nextLine().toLowerCase();

        // choose the input
        switch (choice) {
            case "y":  // write the database
                writeDatabase(students);
                break;
            case "n":  // don't write the database and instead go back to the menu
                System.out.println("Exiting back to main menu...");
                break;
            default:  // invalid input 
                System.out.println("Invalid input, try again....");
                break;
        }
    }


    // perform a binary search on students
    // for their information
    // returns the index of the student in the sorted database
    // name: name to search for
    // students: student database
    // searchMethod: first or last name to search by
    static int binarySearch(String name, ArrayList<Student> students, String searchMethod) {

        // new arraylist with just names in them
        ArrayList<String> names = new ArrayList<String>();

        if (searchMethod.equals("f")) {  // user wants to search using first name
            // Create array with just names in them
            for (int i = 0; i < students.size(); i++) {  // loop thru all the students
                names.add(students.get(i).first.toLowerCase());  // add the first names to the list
            }
        }
        else if (searchMethod.equals("l")) {  // user wants to serach using last name
            // Create array with just names in them
            for (int i = 0; i < students.size(); i++) {  // loop thru all the students
                names.add(students.get(i).last.toLowerCase());  // add the last names to the list
            }
        }

        int left = 0;  // left index of array list
        int right = names.size() - 1;  // Right index of arraylist

        while (left <= right) {

            // find middle of arraylist
            int mid = Math.floorDiv((right + left),2);

            if (names.get(mid).equals(name)) {  // middle is target num
                //BOOK FOUND!
                return mid;
            }
            else if (names.get(mid).compareTo(name) < 0) {  // target num is greater than middle
                left = mid + 1;
            }
            else {  // target num is less than middle 
                right = mid - 1;
            }

        }

        // return -1 if search failed
        return -1;

    }


    // search a student by their first or last name and show information about the student
    // doesn't return anything
    // uses binary search algorithm to search students
    // students: students database
    static void searchStudent(ArrayList<Student> students) {

        Scanner sc = new Scanner(System.in);

        // get choice to sort by first name or last name
        System.out.print("Student search using (F)irst or (L)ast name?: ");
        
        // format choice to lowercase
        String sortMethod = sc.nextLine().toLowerCase();

        // bubble sort
        ArrayList<Student> sortedStudents = bubble(students, sortMethod);

        if (sortMethod.equals("f")) {  // user chose to sort by first name

            System.out.print(("Name to search for using First Name: "));

            // format choice to lowercase
            String name = sc.nextLine().toLowerCase();

            // binary search student's name for index of student
            // get index of student from binarySearch
            int studentIndex = binarySearch(name, sortedStudents, sortMethod);

            if (studentIndex == -1) {  // search failed
                System.out.println("Search failed, try again...");
            }
            else {  // search didn't fail
                Student student = sortedStudents.get(studentIndex);

                // Print each person's names and grades
                System.out.println("\n\nFIRSTNAME LASTNAME = MARK1, MARK2, MARK3\n");
                System.out.println(student.first + " " + student.last + " = " + student.test1 + "%" + ", " + student.test2 + "%" + ", " + student.test3 + "%") ;
            }

        }
        else if (sortMethod.equals("l")) {  // user chose to sort by last name

            System.out.print(("Name to search for using Last Name: "));

            // format choice to lowercase
            String name = sc.nextLine().toLowerCase();

            // binary search student's name for index of student
            int studentIndex = binarySearch(name, sortedStudents, sortMethod);

            if (studentIndex == -1) {  // search failed
                System.out.println("Search failed, try again...");
            }
            else {  // search didn't fail
                Student student = sortedStudents.get(studentIndex);

                // Print each person's names and grades
                System.out.println("\n\nFIRSTNAME LASTNAME = MARK1, MARK2, MARK3\n");
                System.out.println(student.first + " " + student.last + " = " + student.test1 + "%" + ", " + student.test2 + "%" + ", " + student.test3 + "%") ;

            }

        }
        else {
            System.out.println("invalid input try again...");
        }
    }


    // Edit and change student personal information, such as first name and last name
    // students: student database
    static ArrayList<Student> editStudentPersonalInfo(ArrayList<Student> students) {

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

        System.out.println("\nChoose a student to change their personal info.");
        System.out.print("Your choice: ");

        // format input
        int choice = sc.nextInt();

        // get index of the student
        int index = choice-1;

        Scanner sc1 = new Scanner(System.in);
        // get choice to sort by first name or last name
        System.out.print("Change student's (F)irst or (L)ast name?: ");

        // user changes the name to change, first or last
        String whatToChange = sc1.nextLine().toLowerCase();

        if (whatToChange.equals("f")) {  // user wants to change the first name

            // get choice to sort by first name or last name
            System.out.print("New First name: ");
            
            // change first or last name
            String newName = sc1.nextLine();

            // change name
            students.get(index).changeName(0, newName);

            System.out.println("First name changed to " + students.get(index).first + "!");

        }
        else if (whatToChange.equals("l")) {  // user wants to change the last name

            // get choice to sort by first name or last name
            System.out.print("New Last name: ");
            
            // change first or last name
            String newName = sc1.nextLine();

            // change name
            students.get(index).changeName(1, newName);

            System.out.println("Last name changed to " + students.get(index).last + "!");
        }
        return students;
    }


    // Delete students from the array list database
    // students: students database
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
    // students: student database
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

        // student test marks
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


    // user interface mini menu that gives the user optisons to
    // delete, edit and change a student's personal information
    // students database
    static ArrayList<Student> editStudentInfoMenu(ArrayList<Student> students) {

        // Format Menu
        String message = "\n==== Edit Student Info ====\n"+
                         "1: Edit Student Test Marks\n"+
                         "2: Delete Student\n"+
                         "3: Change Student Personal Info\n"+
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
            case "3":  // delete student
                students = editStudentPersonalInfo(students);
                break;
        }

        return students;

    }


    // Calculate the average for the specified test for the whole class
    // and print it to stdout
    // students: student database
    // choice: which test to calculate the class average for
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
    // students: student database
    static void classTestAverage(ArrayList<Student> students) {

        System.out.println("\n\nTests: \n1: Test #1\n2: Test #2\n3: Test #3\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose a TEST to calculate an average for.");
        System.out.print("Your choice: ");

        // format input
        String choice = sc.nextLine().toLowerCase();

        // calculate class average for a test
        calculateTestAverage(students, choice);

    }


    // display the student's average over the three tests
    // students: student database
    // index: index of the student to calcuate the average for
    static void calculateStudentAverage(ArrayList<Student> students, int index) {

        // First name of student
        String firstName = students.get(index).first;

        // Last name of student
        String lastName = students.get(index).last;

        double average = students.get(index).getAverage();

        System.out.println("\n" + firstName + " " + lastName + "'s Average: " + average + "%");

    }


    // Calculate a single student's average
    // students: student database
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

        // calcuate student average for a test
        calculateStudentAverage(students, choice-1);
    }


    // bubble sort algorithm
    // sorts an arraylist using bubble sort
    // students: student database
    // sort method: first or last name to sort by
    static ArrayList<Student> bubble(ArrayList<Student> inStudents, String sortMethod) {

        // create copy of inStudents to sort
        ArrayList<Student> students = new ArrayList<Student>(inStudents);

        if (sortMethod.equals("f")) {  // sort by first name

            // i for outer loop
            // j for inner loop
            // temp for swaps
            int i, j;
            Student temp;

            // outer loop
            for (i = 0; i < students.size() - 1; i++) {
                
                // inner loop
                for (j = 0; j < students.size() - 1 - i; j++) {

                    // compare item to item on it's right
                    // alphabetically
                    int compare = (students.get(j).first.toLowerCase()).compareTo(students.get(j+1).first.toLowerCase());
                    if (compare > 0) {  // letter is alphabettically greater
                        temp = students.get(j);

                        students.set(j, students.get(j+1));
                        students.set(j+1, temp);
                    }
                }
            }

        }
        else if (sortMethod.equals("l")) {  // sort by last name

            // i for outer loop
            // j for inner loop
            // temp for swaps
            int i, j;
            Student temp;

            // outer loop
            for (i = 0; i < students.size() - 1; i++) {
                
                // inner loop
                for (j = 0; j < students.size() - 1 - i; j++) {

                    // compare item to item on it's right
                    // alphabetically
                    int compare = (students.get(j).last.toLowerCase()).compareTo(students.get(j+1).last.toLowerCase());
                    if (compare > 0) {  // word is alphabettically smaller
                        temp = students.get(j);

                        students.set(j, students.get(j+1));
                        students.set(j+1, temp);
                    }
                }
            }

        }
        else {
            System.out.println("Invalid input try again...");
        }

        return students;

    }


    // List student info of every student stored in students[][] 2D array
    // when displayed, can be sorted by first or last name
    // students: student database
    static void listStudentInfo(ArrayList<Student> students) {

        Scanner sc = new Scanner(System.in);

        // get choice to sort by first name or last name
        System.out.print("Sort student information by (F)irst or (L)ast name?: ");
        
        // format choice to lowercase
        String sortMethod = sc.nextLine().toLowerCase();

        // bubble sort
        ArrayList<Student> sortedStudents = bubble(students, sortMethod);

        System.out.println("\n\nFIRSTNAME LASTNAME = MARK1, MARK2, MARK3\n");

        // loop through each student in sortedStudents[][] 
        for (int i = 0; i < sortedStudents.size(); i++) {

            // Display student number to user
            // System.out.println("Student #" + (i+1) + ":");

            // First name of student
            String firstName = sortedStudents.get(i).first;

            // Last name of student
            String lastName = sortedStudents.get(i).last;

            // Test Mark 1
            // Cast mark1 from string to double
            double mark1 = sortedStudents.get(i).test1;

            // Test Mark 2
            // Cast mark2 from string to double
            double mark2 =  sortedStudents.get(i).test2;

            // Test Mark 3
            // Cast mark3 from string to double
            double mark3 =  sortedStudents.get(i).test3;

            // Print each person's names and grades
            System.out.println(firstName + " " + lastName + " = " + mark1 + "%" + ", " + mark2 + "%" + ", " + mark3 + "%") ;
        }
    }


    // Interactive MENU acts as user interface 
    // Choose options from the student grade book
    // students: student database
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
                             "5: Search for Student\n"+
                             "6: Save Database to File\n"+
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
                    case "5":  // Calculate the Class Test Average
                        searchStudent(students);
                        loop = false;  // User valid input break loop
                        break;
                    case "6":  // Calculate the Class Test Average
                        saveDatabase(students);
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
    // studentsRaw: database with just names and scores from the file
    // without any classes
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
    // file: file arraylist of the contents of students.txt
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


    // Read file student database file from current directory
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
    // args: args parsed thru cli
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

