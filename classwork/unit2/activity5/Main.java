/*

File Name:  Main.java
Programmer:  Dante F
Date:  Friday, November 18, 2022
Description: Airline points program that allows
an airline to record airline points data for it's
passengers and to determine if a passenger qualifies
for bonus points.
             
*/


import java.util.Scanner;  // For User stdin inputs 
import java.util.ArrayList;  // Import ArrayLists used for database
import java.util.Collections;  // Sorting Arraylists

class Main {


    // edit the passengers database records
    // return the new edited arraylist database
    static ArrayList<String[]> editPassenger(ArrayList<String[]> database) {

        if (database.size() == 0) {  // database is empty
            System.out.println("Database is empty, can't edit any records.");
            System.out.println("You must add records to be able to edit records.");
            System.out.println("Returning to main menu...");
        }

        else {  // database is not empty

            System.out.println("\n\nPassenger Record List:");

            // loop through each passenger in database
            for (int i = 0; i < database.size(); i++) {

                // First name of passenger
                String firstName = database.get(i)[0];

                // Last name of passenger
                String lastName = database.get(i)[1];

                System.out.println((i+1) + ": " + firstName + " " + lastName);
            }

            Scanner sc = new Scanner(System.in);

            // Get user's choice
            System.out.println("\nChoose a passenger to EDIT records.");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            // Get first and last name of deleted passenger
            String firstName = database.get(choice-1)[0];
            String lastName = database.get(choice-1)[1];

            // Cast String points into Integers for total
            int points1 = Integer.parseInt(database.get(choice-1)[2]);
            int points2 = Integer.parseInt(database.get(choice-1)[3]);
            int points3 = Integer.parseInt(database.get(choice-1)[4]);
            int points4 = Integer.parseInt(database.get(choice-1)[5]);

            // Calculate total points for all 4 weeks
            int totalPoints = points1 + points2 + points3 + points4;

            // Format message 
            String msg0 = firstName + " " + lastName + " record:" +
                        "\nWeek 1 Points: " + points1 +
                        "\nWeek 2 Points: " + points2 +
                        "\nWeek 3 Points: " + points3 +
                        "\nWeek 4 Points: " + points4 +
                        "\nTotal Points: " + totalPoints + "\n";

            // print passenger records
            System.out.println(msg0);


            // format message
            String msg1 = "Choose an option to edit:\n" +
                "1: FIRST NAME\n" +
                "2: LAST NAME\n" +
                "3: Week 1 Points\n" +
                "4: Week 2 Points\n" +
                "5: Week 3 Points\n" +
                "6: Week 4 Points\n";
     
            // print editing options
            System.out.println(msg1);

            // Choice loop
            boolean loop = true;

            // Loop until user enters valid input
            // if loop == false break loop
            while (loop == true) {

                System.out.print("Your choice: ");

                // Format input
                String inp = sc.nextLine().toLowerCase();

                switch (inp) {
                    case "1":  // change first name
                        {
                        // Get new info to change from user
                        System.out.print("Enter the new first name: ");
                        String newInfo = sc.nextLine();

                        // prev info before change
                        String oldInfo = database.get(choice-1)[0];

                        // change to new info
                        database.get(choice-1)[0] = newInfo;

                        System.out.println("First name changed from " + oldInfo + " to: " + newInfo + "!");

                        loop = false;  // User valid input break loop
                        }
                        break;
                    case "2":  // change last name
                        {
                        // Get new info to change from user
                        System.out.print("Enter the new last name: ");
                        String newInfo = sc.nextLine();

                        // prev info before change
                        String oldInfo = database.get(choice-1)[1];

                        // change to new info
                        database.get(choice-1)[1] = newInfo;

                        System.out.println("Last name changed from " + oldInfo + " to: " + newInfo + "!");

                        loop = false;  // User valid input break loop
                        }
                        break;
                    case "3":  // change week1 points
                        {
                        // Get new info to change from user
                        System.out.print("Enter the new week1 points: ");
                        String newInfo = sc.nextLine();

                        // prev info before change
                        String oldInfo = database.get(choice-1)[2];

                        // change to new info
                        database.get(choice-1)[2] = newInfo;

                        System.out.println("Week1 points changed from " + oldInfo + " to: " + newInfo + "!");

                        loop = false;  // User valid input break loop
                        }
                        break;
                    case "4":  // change week2 points
                        {
                        // Get new info to change from user
                        System.out.print("Enter the new week2 points: ");
                        String newInfo = sc.nextLine();

                        // prev info before change
                        String oldInfo = database.get(choice-1)[3];

                        // change to new info
                        database.get(choice-1)[3] = newInfo;

                        System.out.println("Week2 points changed from " + oldInfo + " to: " + newInfo + "!");

                        loop = false;  // User valid input break loop
                        }
                        break;
                    case "5":  // change week3 points
                        {
                        // Get new info to change from user
                        System.out.print("Enter the new week3 points: ");
                        String newInfo = sc.nextLine();

                        // prev info before change
                        String oldInfo = database.get(choice-1)[4];

                        // change to new info
                        database.get(choice-1)[4] = newInfo;

                        System.out.println("Week3 points changed from " + oldInfo + " to: " + newInfo + "!");

                        loop = false;  // User valid input break loop
                        }
                        break;
                    case "6":  // change week4 points
                        {
                        // Get new info to change from user
                        System.out.print("Enter the new week4 points: ");
                        String newInfo = sc.nextLine();

                        // prev info before change
                        String oldInfo = database.get(choice-1)[5];

                        // change to new info
                        database.get(choice-1)[5] = newInfo;

                        System.out.println("Week4 points changed from " + oldInfo + " to: " + newInfo + "!");

                        loop = false;  // User valid input break loop
                        }
                        break;
                }       
            }
        }

        return database;
    }


    // get user to search for a passenger and
    // view all their records and information from the database
    static void searchPassenger(ArrayList<String[]> database) {

        // database size check
        if (database.size() == 0) {
            System.out.println("Database is empty, can't search for any records.");
            System.out.println("You must add records to be able to SEARCH for records.");
            System.out.println("Returning to main menu...");
        }

        else {  // database has 1 or more records

            System.out.println("\n\nPassenger Record List:");

            // loop through each passenger in database
            for (int i = 0; i < database.size(); i++) {

                // First name of passenger
                String firstName = database.get(i)[0];

                // Last name of passenger
                String lastName = database.get(i)[1];

                System.out.println((i+1) + ": " + firstName + " " + lastName);
            }

            Scanner sc = new Scanner(System.in);

            // Get user's choice
            System.out.println("\nChoose a passenger to VIEW records/information.");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            // Get first and last name of deleted passenger
            String firstName = database.get(choice-1)[0];
            String lastName = database.get(choice-1)[1];

            // Cast String points into Integers for total
            int points1 = Integer.parseInt(database.get(choice-1)[2]);
            int points2 = Integer.parseInt(database.get(choice-1)[3]);
            int points3 = Integer.parseInt(database.get(choice-1)[4]);
            int points4 = Integer.parseInt(database.get(choice-1)[5]);

            // Calculate total points for all 4 weeks
            int totalPoints = points1 + points2 + points3 + points4;

            String msg = firstName + " " + lastName + " record:" +
                        "\nWeek 1 Points: " + points1 +
                        "\nWeek 2 Points: " + points2 +
                        "\nWeek 3 Points: " + points3 +
                        "\nWeek 4 Points: " + points4 +
                        "\nTotal Points: " + totalPoints + "\n";

            System.out.println(msg);
        }
    }


    // Display sorted VIP passengers by last name and points etc.
    static void displaySortedVIPs(ArrayList<String[]> database) {

        // return a database ArrayList sorted by last names
        ArrayList<String[]> sortedList = sortPassengers(database);

        // Loop through sortedList and delete
        // all the passengers with less than 5000 points
        for (int i = 0; i < sortedList.size(); i++) {

            // Cast String points into Integers for total
            int points1 = Integer.parseInt(sortedList.get(i)[2]);
            int points2 = Integer.parseInt(sortedList.get(i)[3]);
            int points3 = Integer.parseInt(sortedList.get(i)[4]);
            int points4 = Integer.parseInt(sortedList.get(i)[5]);

            // Calculate total points for all 4 weeks
            int totalPoints = points1 + points2 + points3 + points4;

            if (totalPoints < 5000) {  
                // Remove passenger record from list (not VIP)
                sortedList.remove(i);
            }

        }

        if (sortedList.size() == 0) {  // No one qualifies as a VIP
            System.out.println("No passengers qualify as VIPs\n returning to menu...");
        }

        else {  // at least one passenger qualifies as a VIP member 

            System.out.println("\n*VIPs* Sorted by Last name:\n");

            // Loop through sortedList
            for (int i = 0; i < sortedList.size(); i++) {

                // Set attributes for formatting message for
                // each passenger to send to stdout
                String first = sortedList.get(i)[0];
                String last = sortedList.get(i)[1];
                int week1 = Integer.parseInt(sortedList.get(i)[2]);
                int week2 = Integer.parseInt(sortedList.get(i)[3]);
                int week3 = Integer.parseInt(sortedList.get(i)[4]);
                int week4 = Integer.parseInt(sortedList.get(i)[5]);

                // calculate total for all 4 weeks
                int total = week1 + week2 + week3 + week4;

                // format message
                String msg = i+1 + ". " + first + " " + last +
                    "\nWeek 1 Points: " + week1 +
                    "\nWeek 2 Points: " + week2 +
                    "\nWeek 3 Points: " + week3 +
                    "\nWeek 4 Points: " + week4 +
                    "\nTotal Points: " + total + "\n";

                // print formatted message
                System.out.println(msg);
            }
        }
    }


    // Sort passengers by last name
    // return sorted arraylist of passenger records by last name
    static ArrayList<String[]> sortPassengers(ArrayList<String[]> database) {

        // Declare list for last names
        ArrayList<String> lastNames = new ArrayList<String>();

        // Loop through database records 
        for (int i = 0; i < database.size(); i++) {
            // Add last names to lastNames
            lastNames.add(database.get(i)[1]);
        }

        Collections.sort(lastNames);  // sort lastNames

        // Declare new sorted list for passenger records
        ArrayList<String[]> sortedList = new ArrayList<String[]>();

        // SORT BY LAST NAMES
        // Loop through lastNames arraylist
        for (int i = 0; i < lastNames.size(); i++) {

            // Loop through database
            for (int j = 0; j < database.size(); j++) {

                // Last names are the same
                if (database.get(j)[1] == lastNames.get(i)) {

                    // Add the passenger to the sorted list
                    sortedList.add(database.get(j));
                }
            }
        }

        return sortedList;

    }


    // Display sorted passengers by last name and points etc.
    static void displaySortedPassengers(ArrayList<String[]> database) {

        // return a database ArrayList sorted by last names
        ArrayList<String[]> sortedList = sortPassengers(database);

        System.out.println("\nSorted by Last name:\n");
        
        // Loop through sortedList
        for (int i = 0; i < sortedList.size(); i++) {

            // Set attributes for formatting message for
            // each passenger to send to stdout
            String first = sortedList.get(i)[0];
            String last = sortedList.get(i)[1];
            int week1 = Integer.parseInt(sortedList.get(i)[2]);
            int week2 = Integer.parseInt(sortedList.get(i)[3]);
            int week3 = Integer.parseInt(sortedList.get(i)[4]);
            int week4 = Integer.parseInt(sortedList.get(i)[5]);

            // calculate total for all 4 weeks
            int total = week1 + week2 + week3 + week4;

            String msg = i+1 + ". " + first + " " + last +
                "\nWeek 1 Points: " + week1 +
                "\nWeek 2 Points: " + week2 +
                "\nWeek 3 Points: " + week3 +
                "\nWeek 4 Points: " + week4 +
                "\nTotal Points: " + total + "\n";

            System.out.println(msg);
        }
    }


    // delete passenger record from the database
    // return new arraylist database after removing passenger
    static ArrayList<String[]> deleteRecord(ArrayList<String[]> database) {

        if (database.size() == 0) {  // database is empty
            System.out.println("Database is empty, can't delete any records.");
            System.out.println("You must add records to be able to delete records.");
            System.out.println("Returning to main menu");
        }

        else {  // database has at least 1 record

            System.out.println("\n\nPassenger Record List:");

            // loop through each passenger in database
            for (int i = 0; i < database.size(); i++) {

                // First name of passenger
                String firstName = database.get(i)[0];

                // Last name of passenger
                String lastName = database.get(i)[1];

                System.out.println((i+1) + ": " + firstName + " " + lastName);
            }

            Scanner sc = new Scanner(System.in);

            // Get user's choice
            System.out.println("\nChoose a passenger to delete.");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            // Get first and last name of deleted passenger
            String firstName = database.get(choice-1)[0];
            String lastName = database.get(choice-1)[1];

            // Delete record
            database.remove(choice-1);

            System.out.println("Record: " + firstName + " " + lastName + " deleted!");

        }

        return database;

    }


    // Add passenger record to the database
    // from user input and return arraylist database 
    // return the new database with the added passenger record
    static ArrayList<String[]> addRecord(ArrayList<String[]> database) {

        Scanner sc = new Scanner(System.in);

        // create string array for entering passenger information
        String[] passenger = new String[6];

        // Get First name of passenger from user
        System.out.print("\nEnter Passenger's First Name: ");
        passenger[0] = sc.nextLine();

        // Get Last name of passenger from user
        System.out.print("\nEnter Passenger's Last Name: ");
        passenger[1] = sc.nextLine();

        // Get passenger points earned for first week of month
        System.out.print("\nEnter Passenger's Points for FIRST week of the month: ");
        passenger[2] = sc.nextLine();

        // Get passenger points earned for second week of month
        System.out.print("\nEnter Passenger's Points for SECOND week of the month: ");
        passenger[3] = sc.nextLine();

        // Get passenger points earned for third week of month
        System.out.print("\nEnter Passenger's Points for THIRD week of the month: ");
        passenger[4] = sc.nextLine();

        // Get passenger points earned for fourth week of month
        System.out.print("\nEnter Passenger's Points for FOURTH week of the month: ");
        passenger[5] = sc.nextLine();

        // Add the passenger array to the database
        database.add(passenger);

        // Return database with new passenger appended 
        return database;
    }


    // Interactive MENU acts as user interface 
    // Choose options from the airline points program
    static void menu() {

        // Create ArrayList for database
        ArrayList<String[]> database = new ArrayList<String[]>();

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n==== Airline Points Program ====\n"+
                             "1: Add passenger record to database\n"+
                             "2: Delete passenger record from database\n"+
                             "3: Display alphabetically sorted passengers\n"+
                             "4: Display alphabetically sorted VIPs\n"+
                             "5: Search for passenger record\n"+
                             "6: Edit passenger record\n"+
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
                    case "1":  // add passenger record to database
                        database = addRecord(database);
                        loop = false;  // User valid input break loop
                        break;
                    case "2":  // delete passenger record from the database
                        database = deleteRecord(database);
                        loop = false;  // User valid input break loop
                        break;
                    case "3":  // display passengers from the database sorted alphabetically
                        displaySortedPassengers(database);
                        loop = false;  // User valid input break loop
                        break;
                    case "4":  // display VIPs from the database sorted alphabetically
                        displaySortedVIPs(database);
                        loop = false;  // User valid input break loop
                        break;
                    case "5":  // search for a passenger from the database
                        searchPassenger(database);
                        loop = false;  // User valid input break loop
                        break;
                    case "6":  // edit a passenger's database records
                        database = editPassenger(database);
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


    // Main method
    public static void main(String[] args) {

        menu();  // Menu interface
        System.out.println("Exited, Goodbye!"); // User has exited the main menu interface

    }
}

