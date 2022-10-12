
/*
File Name:  Main.java
Programmer:  Dante F
Date:  Sunday, October 9, 2022
Description:  Text-based non-scientific calculator.
              Has interactive menu
*/


import java.util.Scanner;

class Main {


    // Get num from user input and sqrt currentNum by user num
    static double sqrtNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        System.out.println("Are you sure you want to square root: " + currentNum + "?");

        if (getUserConfirmaton()) {  // User wants to square the number
            currentNum = Math.sqrt(currentNum);
            System.out.println("NEW! CURRENT NUMBER in Display: " + currentNum);
        }
        else {  // User doesn't want to square the number
            System.out.println("CURRENT NUMBER NOT changed: " + currentNum);
        }

        return currentNum;

    }


    // Get num from user input and divide currentNum by user num
    static double divideNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        double num = getUserNum("Number to divide by: ");

        // Multplication Calculation
        double total = currentNum / num;
        System.out.println(currentNum + "/" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // New num
        currentNum = total;
        return currentNum;

    }


    // Get num from user input and multiply currentNum by user num
    static double multiplyNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        double num = getUserNum("Number to multiply by: ");

        // Multplication Calculation
        double total = currentNum * num;
        System.out.println(currentNum + "x" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // New num
        currentNum = total;
        return currentNum;

    }


    // Subtract user input number from currentNum in calculator "display"
    static double subtractNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        double num = getUserNum("Number to subtract: ");

        // Subtraction Calculation
        double total = currentNum - num;
        System.out.println(currentNum + "-" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // New num
        currentNum = total;
        return currentNum;

    }


    // Add user input number to currentNum in calculator "display"
    static double addNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        double num = getUserNum("Number to add: ");

        // Addition calculation
        double total = num + currentNum;
        System.out.println(currentNum + "+" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // New num
        currentNum = total;
        return currentNum;

    }


    // Set number in calculator to value from user
    static double setNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        double num = getUserNum("Set CURRENT NUMBER to: ");

        System.out.println("CURRENT NUMBER changed from " + currentNum + " to " + num + ".");

        // New num
        currentNum = num;

        return currentNum;

    }


    // Return confirmation from user input 
    static boolean getUserConfirmaton() {

        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        boolean confirmed = false; // User confirmation status

        while (loop == true) {  // Basic error check loop 

            // Get num from user from stdin
            // System.out.print("Are you sure?? 1=Yes or 2=No: ");

            // Format input
            // Bug: I can't get strings to work for some reason so my dirty
            // workaround is to use integers as inputs instead...
            // otherwise I'd use "yes" and "no".. doesn't seem to work
            // int input = sc.nextInt();

            // if (input == 1) { // User wants to continue
            //     confirmed = true;
            //     loop = false;
            // }
            // else if (input == 2) { // User doesn't want to continue
            //     confirmed = false;
            //     loop = false;
            // }
            // else {  // User entered invalid input
            //     System.out.println("Please enter a valid input...");
            // }

            // Get num from user from stdin

            while (loop == true) {  // Basic error check loop
                                    //
                System.out.print("Are you sure?? (Y)es or (N)o: ");
                String input = sc.nextLine().toLowerCase(); // format user input into lowercase
                                                            //
                switch (input) {
                    case "yes":  // User wants to continue
                        confirmed = true;
                        loop = false;
                        break;
                    case "y":   // User wants to continue
                        confirmed = true;
                        loop = false;
                        break;
                    case "no":  // User doesn't want to continue
                        confirmed = false;
                        loop = false;
                        break;
                    case "n":  // User doesn't want to continue
                        confirmed = false;
                        loop = false;
                        break;
                    default: // User inputs invalid input
                        System.out.println("Please enter a valid input try again...");
                        break;
                }
            }

        }
        return confirmed;  // Return answer
    }


    // Return numbers from user input 
    static double getUserNum(String message) {

            Scanner sc = new Scanner(System.in);

            // Get num from user from stdin
            System.out.print(message);
            double num = sc.nextDouble();

            return num;

    }


    // Acts as an user interface for user to calculate values.
    static void menu() {

        // Default value when calculator starts up
        double currentNum = 0;

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n===== Math Main Menu =====\n"+
                             "S: [=]    Enter NUMBER\n"+
                             "1: [+]    ADD number\n"+
                             "2: [-]    SUBTRACT number\n"+
                             "3: [x]    MULTIPLY number\n"+
                             "4: [/]    DIVIDE number\n"+
                             "5: [sqrt] SQUARE ROOT number\n"+
                             "6: [x^2]  SQUARE number\n"+
                             "7: [x^y]  RAISE number TO POWER\n"+
                             "8: [+/-]  CHANGE SIGN\n"+
                             "\n   " + currentNum + " << CURRENT NUMBER in Display\n"+
                             "==========================\n"+
                             "0: Exit Program\n"+
                             "==========================\n";

            // Print Menu to stdout
            System.out.println(message);

            Scanner sc = new Scanner(System.in);

            // Choice loop
            boolean loop = true;

            // Loop until user enters valid input
            while (loop == true) {

                System.out.print("Your choice: ");
                String choice = sc.nextLine().toLowerCase();

                switch (choice) {
                    case "s":
                        currentNum = setNum(currentNum);
                        loop = false;
                        break;
                    case "1":
                        currentNum = addNum(currentNum);
                        loop = false;
                        break;
                    case "2":
                        currentNum = subtractNum(currentNum);
                        loop = false;
                        break;
                    case "3":
                        currentNum = multiplyNum(currentNum);
                        loop = false;
                        break;
                    case "4":
                        currentNum = divideNum(currentNum);
                        loop = false;
                        break;
                    case "5":
                        currentNum = sqrtNum(currentNum);
                        loop = false;
                        break;
                    case "6":
                        // currentNum = squareNum(currentNum);
                        loop = false;
                        break;
                    case "7":
                        // currentNum = raiseNum(currentNum);
                        loop = false;
                        break;
                    case "8":
                        // currentNum = changeSignNum(currentNum);
                        loop = false;
                        break;
                    case "0":
                        loop = false;
                        menuLoop = false; // Stop menu loop and exit program
                        break;
                    default: // User enters invalid input (no exceptions for erroneous user inputs)
                        System.out.println("Please choose a valid option, try again...\n");
                }
            }
        }
    }


    public static void main(String[] args) { 

        menu();
        System.out.println("Goodbye!"); // User has exited the main menu interface

    }
}
