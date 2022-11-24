/*
File Name:  Main.java
Programmer:  Dante F
Date:  Friday, Novemember 11, 2022
Description: Simulates a teacher grade book with
             5 students
*/


import java.util.Scanner;  // For User stdin inputs 

class Main {

    // fibonacci recursion func
    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        else if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    // get num for fib sequence
    static void getFibNumber() {

        Scanner sc = new Scanner(System.in);

        // n
        System.out.print("Which nth Fibonacci number would you like to see: ");
        int n = sc.nextInt();

        // get answer
        int answer = fibonacci(n+1);

        // print answer
        System.out.println("The answer is: " + answer);

    }


    // greatest common factor recursion func
    static int gcd(int a, int b ) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }


    // reduce any given fraction to simplest terms
    static void fractionReducer() {

        Scanner sc = new Scanner(System.in);

        // get numerator from user
        System.out.print("Enter your numerator: ");
        int numerator = sc.nextInt();

        // get denominator from user
        System.out.print("Enter your denominator: ");
        int denominator = sc.nextInt();


        // get gcd from func
        int answer = gcd(numerator, denominator);

        // calculator simplified numerators and denominators
        int reducedNumerator = numerator / answer;
        int reducedDenominator = denominator / answer;

        // print answer
        System.out.println(numerator + "/" + denominator + " in lowest terms is " + reducedNumerator + "/" + reducedDenominator);

    }


    // factorial recursion func
    static double fact(double num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        else {
            return (num * fact(num-1));
        }
    }


    // nCr calculator for user to enter two nums
    static void nChooseR() {

        Scanner sc = new Scanner(System.in);

        // get number of total objects to choose from (n)
        System.out.print("How many objects are there to choose from in your group: ");
        double n = sc.nextDouble();

        // get number of objects to choose (r)
        System.out.print("How many objects are you choosing: ");
        double r = sc.nextDouble();

        // calculations for nCr
        double top = fact(n);  // return factorial
        double bottom = (fact(r)) * fact(n-r);  // return several factorials using func
        double answer = top / bottom; // get answer for nCr calculation

        // print to stdout
        System.out.println(n + " choose " + r + " is " + answer);

    }


    // Interactive MENU acts as user interface 
    // Choose options from the recursion example program
    static void menu() {

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n==== Recursion ====\n"+
                             "1: Combinations n choose r\n"+
                             "2: Fraction Reducer\n"+
                             "3: Fibonacci Numbers\n"+
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
                    case "1":  // nCr calculation
                        nChooseR();
                        loop = false;  // User valid input break loop
                        break;
                    case "2":  // reduce fraction given by user
                        fractionReducer();
                        loop = false;  // User valid input break loop
                        break;
                    case "3":  // calcuator n of fibonacci sequence from user
                        getFibNumber();
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

