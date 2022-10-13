
/*
File Name:  Main.java
Programmer:  Dante F
Date:  Sunday, October 9, 2022
Description:  Text-based non-scientific calculator.
              Has interactive menu
*/


import java.util.Scanner;  // Used for user inputs

class Main {


    // Set currentNum in display to 0
    // return new currentNum (0) or original currentNum if user
    // didn't confirm reset
    static double resetCalculator(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        System.out.println("Are you sure you want to set number in display to 0?");

        // Confirm user wants to continue
        if (getUserConfirmaton()) {  // User wants to square the number
            currentNum = 0;
            System.out.println("NEW! CURRENT NUMBER in Display: " + currentNum);
        }
        else {  // User doesn't want to square the number
            System.out.println("CURRENT NUMBER NOT changed: " + currentNum);
        }

        // Return final value
        return currentNum;

    }


    // Change sign of currentNum aka emulate (+/-) button
    // return new currentNum after changing sign
    static double changeSignNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        System.out.println("Are you sure you want to flip sign of " + currentNum + "?");

        // Confirm user wants to continue
        if (getUserConfirmaton()) {  // User wants to flip sign of num
            currentNum *= -1;
            System.out.println("NEW! CURRENT NUMBER in Display: " + currentNum);
        }
        else {  // User doesn't want to flip sign of num
            System.out.println("CURRENT NUMBER NOT changed: " + currentNum);
        }

        // Return final value
        return currentNum;

    }


    // Get num from user input raise the currentNum to num entered by user
    // return new currentNum after raising currentNum to num entered
    // by user
    static double raiseNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        // User enter number to raise by

        Scanner sc = new Scanner(System.in);

        System.out.print("Number to raise " + currentNum + " by: ");

        // Get user input
        double num = sc.nextDouble();

        // Raise number to given power
        currentNum = Math.pow(currentNum, num);

        System.out.println("Number raised! CURRENT NUMBER in Display: " + currentNum);

        // Return final value
        return currentNum;

    }


    // Get num from user input and square currentNum 
    // return new currentNum after x^2 operation
    static double squareNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        System.out.println("Are you sure you want to square: " + currentNum + "?");

        // Confirm user wants to continue
        if (getUserConfirmaton()) {  // User wants to square the number
            currentNum = currentNum * currentNum;
            System.out.println("NEW! CURRENT NUMBER in Display: " + currentNum);
        }
        else {  // User doesn't want to square the number
            System.out.println("CURRENT NUMBER NOT changed: " + currentNum);
        }

        // Return final value
        return currentNum;

    }


    // Get num from user input and sqrt currentNum by user num
    // return new currentNum after sqrt operation
    static double sqrtNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        System.out.println("Are you sure you want to square root: " + currentNum + "?");

        // Confirm user wants to continue
        if (getUserConfirmaton()) {  // User wants to sqrt the number
            currentNum = Math.sqrt(currentNum);
            System.out.println("NEW! CURRENT NUMBER in Display: " + currentNum);
        }
        else {  // User doesn't want to sqrt the number
            System.out.println("CURRENT NUMBER NOT changed: " + currentNum);
        }

        // Return final value
        return currentNum;

    }


    // Get num from user input and divide currentNum by user num
    // return new currentNum after division operation
    static double divideNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        // get user num from user input to divide by
        double num = getUserNum("Number to divide by: ");

        // division Calculation
        double total = currentNum / num;
        
        // print operation verbosely
        System.out.println(currentNum + "/" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // assign new currentNum to total
        currentNum = total;

        // Return final value
        return currentNum;

    }


    // Get num from user input and multiply currentNum by user num
    // return new currentNum after multiplication operation
    static double multiplyNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        // get num from user input to multiply by
        double num = getUserNum("Number to multiply by: ");

        // Multplication Calculation
        double total = currentNum * num;
        System.out.println(currentNum + "x" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // assign new currentNum to new total
        currentNum = total;

        // Return final value
        return currentNum;

    }


    // Subtract user input number from currentNum in calculator "display"
    // return new currentNum after subtraction operation
    static double subtractNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        // get number to subtract by from user input
        double num = getUserNum("Number to subtract: ");

        // Subtraction Calculation with new num entered by user
        double total = currentNum - num;
        System.out.println(currentNum + "-" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // assign new currentNum to new total
        currentNum = total;

        // Return final value
        return currentNum;

    }


    // Add user input number to currentNum in calculator "display"
    // return new currentNum after addition operation
    static double addNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        // get num to add to currentNum from user input
        double num = getUserNum("Number to add: ");

        // Addition calculation
        double total = num + currentNum;
        System.out.println(currentNum + "+" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        // assign new currentNum to new total after addition
        currentNum = total;

        // Return final value
        return currentNum;

    }


    // Set number in calculator to value from user
    // return new currentNum set by user
    static double setNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        // get num to be changed to from user input
        double num = getUserNum("Set CURRENT NUMBER to: ");

        System.out.println("CURRENT NUMBER changed from " + currentNum + " to " + num + ".");

        // Set the new currentNum as the num entered by user
        currentNum = num;

        // Return final value
        return currentNum;

    }


    // Confirm that the user wants to continue with a mathematical operation
    // return true if user wants to continue
    // return false if user doesn't want to continue
    static boolean getUserConfirmaton() {

        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        boolean confirmed = false; // User confirmation status

        // Keep looping until user enters valid input
        // (loop until user chooses either YES or NO
        while (loop == true) {  // Basic error check loop
                           
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
                default: // User inputs invalid input / none of defined options
                    System.out.println("Please enter a valid input try again...");
                    break;
            }
        }

        return confirmed;  // Return answer
    }


    // Get number from user input
    // return number entered by user
    static double getUserNum(String message) {

            Scanner sc = new Scanner(System.in);

            // Get num from user from stdin
            System.out.print(message);
            double num = sc.nextDouble();

            // return num entered by user
            return num;

    }


    // Interactive MENU acts as user interface 
    // for user to choose operations
    // and calculate values.
    static void menu() {

        // Default value when calculator starts up
        double currentNum = 0;

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n===== Math Main Menu =====\n"+
                             "S: [=]     Enter NUMBER\n"+
                             "1: [+]     ADD number\n"+
                             "2: [-]     SUBTRACT number\n"+
                             "3: [x]     MULTIPLY number\n"+
                             "4: [/]     DIVIDE number\n"+
                             "5: [sqrt]  SQUARE ROOT number\n"+
                             "6: [x^2]   SQUARE number\n"+
                             "7: [x^y]   RAISE number TO POWER\n"+
                             "8: [+/-]   CHANGE SIGN\n"+
                             "9: [AC/CE] CLEAR DISPLAY\n"+
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
            // if loop == false break loop
            while (loop == true) {

                System.out.print("Your choice: ");

                // format input
                String choice = sc.nextLine().toLowerCase();

                switch (choice) {
                    case "s":  // User wants to set the currentNum to another num
                        currentNum = setNum(currentNum);
                        loop = false;
                        break;
                    case "1":  // User wants to add a num to the currentNum
                        currentNum = addNum(currentNum);
                        loop = false;
                        break;
                    case "2":  // User wants to subtract the currentNum by another num
                        currentNum = subtractNum(currentNum);
                        loop = false;
                        break;
                    case "3":  // User wants to multiply the currentNum by another num
                        currentNum = multiplyNum(currentNum);
                        loop = false;
                        break;
                    case "4":  // User wants to divide the currentNum
                        currentNum = divideNum(currentNum);
                        loop = false;
                        break;
                    case "5":  // User wants to sqrt the currentNum
                        currentNum = sqrtNum(currentNum);
                        loop = false;
                        break;
                    case "6":  // User wants to square the currentNum
                        currentNum = squareNum(currentNum);
                        loop = false;
                        break;
                    case "7":  // User wants to raise currentNum
                        currentNum = raiseNum(currentNum);
                        loop = false;
                        break;
                    case "8":  // User wants to change sign of currentNum
                        currentNum = changeSignNum(currentNum);
                        loop = false;
                        break;
                    case "9":  // User wants to reset calculator
                        currentNum = resetCalculator(currentNum);
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
        System.out.println("Goodbye!"); // User has exited the main menu interface

    }
}
