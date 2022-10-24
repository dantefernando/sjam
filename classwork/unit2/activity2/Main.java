/*
File Name:  Main.java
Programmer:  Dante F
Date:  Sunday, October 25, 2022
Description: Program that can store and display
             integer values from an array or arrayList.
*/


import java.util.Scanner;  // Used for user inputs
import java.util.ArrayList;  // Import ArrayList Class
import java.util.Collections;  // Import Collections for sorting

class Main {


    // Sort elements of numList and print only EVEN nums to stdout
    // sort from lowest to highest, only EVEN nums and display sum
    static void displayEvenElements(ArrayList<Integer> numList) {

        // Create copy of numList to sort
        ArrayList<Integer> sortedList = new ArrayList<>(numList);
        Collections.sort(sortedList);  // Sort list from lowest to highest

        // empty arraylist with only odd integers
        ArrayList<Integer> evenList = new ArrayList<Integer>();

        // loop thru elements of sortedList, append each odd num to oddList
        for (int i: sortedList) {  
            if (i % 2 == 0) {  // Num is even
                evenList.add(i);  // Add the even number to oddList
            }
        }
        
        // Sum of numList
        int sum = 0;

        // Iterate through elements in list and add them to sum
        for (int i: evenList) {
            sum += i;
        }

        System.out.println("Sorted list: " + evenList);
        System.out.println("Sum of list: " + sum);

    }


    // Sort elements of numList and print only ODD nums to stdout
    // sort from lowest to highest, only ODD nums and display sum
    static void displayOddElements(ArrayList<Integer> numList) {

        // Create copy of numList to sort
        ArrayList<Integer> sortedList = new ArrayList<>(numList);
        Collections.sort(sortedList);  // Sort list from lowest to highest

        // empty arraylist with only odd integers
        ArrayList<Integer> oddList = new ArrayList<Integer>();

        // loop thru elements of sortedList, append each odd num to oddList
        for (int i: sortedList) {  
            if (i % 2 == 1) {  // Num is odd
                oddList.add(i);  // Add the odd number to oddList
            }
        }
        

        // Sum of numList
        int sum = 0;

        // Iterate through elements in list and add them to sum
        for (int i: oddList) {
            sum += i;
        }

        System.out.println("Sorted list: " + oddList);
        System.out.println("Sum of list: " + sum);

    }


    // Sort elements of numList and print it to stdout
    // sort from lowest to highest and display sum
    static void displayElements(ArrayList<Integer> numList) {

        // Create copy of numList to sort
        ArrayList<Integer> sortedList = new ArrayList<>(numList);
        Collections.sort(sortedList);  // Sort list from lowest to highest

        // Sum of numList
        int sum = 0;

        // Iterate through elements in list and add them to sum
        for (int i: numList) {
            sum += i;
        }

        System.out.println("Sorted list: " + sortedList );
        System.out.println("Sum of list: " + sum );

    }



    // Remove integer element from arrayList
    static ArrayList<Integer> removeElement(ArrayList<Integer> numList) {

        System.out.println("\nCurrent list: " + numList + "\n");

        System.out.println(numList.size());

        System.out.println("INDEX : ELEMENT IN LIST");
        
        // loop through list print elements to stdout and format with index nums and elements beside
        for (int i = 0; i < numList.size(); i++) {
            System.out.println(i + " : " + numList.get(i));
        }

        // get num to remove from ArrayList
        int num = getUserNum("\nINDEX num to remove from list (e.g. \'0\' removes first element): ");
        int numRemoved = numList.get(num);
        numList.remove(num); //  number to arraylist

        System.out.println("Element: " + numRemoved + " removed from list. New list: " + numList);

        // Return arraylist
        return numList;
    }


    // Add integer element to the arrayList
    static ArrayList<Integer> addElement(ArrayList<Integer> numList) {

        System.out.println("\nCurrent list: " + numList + "\n");

        // get num to add to ArrayList
        int num = getUserNum("\nInteger to add to list: ");
        numList.add(num); // add number to arraylist

        System.out.println(num + " added to list: " + numList);

        // Return arraylist
        return numList;
    }


    // Get number from user input
    // return number entered by user
    static int getUserNum(String message) {

            Scanner sc = new Scanner(System.in);

            // Get num from user from stdin
            System.out.print(message);
            int num = sc.nextInt();

            // return num entered by user
            return num;
    }


    // Interactive MENU acts as user interface 
    // for user to choose operations
    // and calculate values.
    static void menu() {

        // Create ArrayList object to store integers in
        ArrayList<Integer> numList = new ArrayList<Integer>();

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n===== Array Main Menu =====\n"+
                             "1: Add Integer Element to List\n"+
                             "2: Remove Integer Element from List\n"+
                             "3: Display Integers Lowest to Highest\n"+
                             "4: Display ODD Integers Lowest to Highest\n"+
                             "5: Display EVEN Integers Lowest to Highest\n"+
                             "\nCURRENT Elements List: " + numList + "\n" + 
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
                    case "1":  // User wants to add an element to the ArrayList
                        numList = addElement(numList);
                        loop = false;
                        break;
                    case "2":  // User wants to remove an element from the ArrayList
                        numList = removeElement(numList);
                        loop = false;
                        break;
                    case "3":  // print sorted elements and print to stdout
                        displayElements(numList);
                        loop = false;
                        break;
                    case "4":  // print Sorted only odd elements and print to stdout
                        displayOddElements(numList);
                        loop = false;
                        break;
                    case "5":  // print Sorted only even elements and print to stdout
                        displayEvenElements(numList);
                        loop = false;
                        break;
                    case "0":  // User wants to exit program
                        loop = false;
                        menuLoop = false; // Stop menu loop and exit program
                        break;
                    default:  // User enters invalid input (no exceptions for erroneous user inputs)
                        System.out.println("Please choose a valid option, try again...\n");
                }
            }
        }
    }


    // Main method runs on startup
    public static void main(String[] args) { 

        menu();  // Run menu on startup
        System.out.println("Exited, Goodbye!"); // User has exited the main menu interface

    }
}


