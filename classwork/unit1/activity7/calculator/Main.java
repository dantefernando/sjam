
/*
File Name:  Main.java
Programmer:  Dante F
Date:  Sunday, October 9, 2022
Description:  Text-based non-scientific calculator.
              Has interactive menu
*/


import java.util.Scanner;

class Main {


    // Set number in calculator to value from user
    static double addNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        double num = getUserNum("Number to add: ");

        double total = num + currentNum;
        System.out.println(currentNum + "+" + num + "=" + total);

        System.out.println("CURRENT NUMBER: " + total);

        currentNum = total;
        return currentNum;

    }


    // Set number in calculator to value from user
    static double setNum(double currentNum) {

        System.out.println("CURRENT NUMBER in Display: " + currentNum);

        double num = getUserNum("Set CURRENT NUMBER to: ");

        System.out.println("CURRENT NUMBER changed from " + currentNum + " to " + num + ".");
        currentNum = num;

        return currentNum;

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
                        // currentNum = subtractNum(currentNum);
                        loop = false;
                        break;
                    case "3":
                        // currentNum = multiplyNum(currentNum);
                        loop = false;
                        break;
                    case "4":
                        // currentNum = divideNum(currentNum);
                        loop = false;
                        break;
                    case "5":
                        // currentNum = sqrtNum(currentNum);
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
