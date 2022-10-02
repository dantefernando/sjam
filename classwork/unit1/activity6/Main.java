// Dante Fernando 2022

// getUserNums() is the function in this program
// getUserNums() is the only function that returns something
// But it's a function that's used in every single math method.

import java.util.Scanner;

class Main {

    // User enters two numbers to divide together and value is printed to stdout
    static void mathDivide() {

        System.out.println("Enter two numbers to divide by each other.");

        double[] nums = getUserNums(2);
        double num1 = nums[0];
        double num2 = nums[1];

        System.out.println("Answer: " + num1/num2);

    }


    // User enters two numbers to multiply together and value is printed to stdout
    static void mathMultiply() {

        System.out.println("Enter two numbers to multiply together.");

        double[] nums = getUserNums(2);
        double num1 = nums[0];
        double num2 = nums[1];

        System.out.println("Answer: " + num1*num2);

    }


    // User enters a value square root of value is printed to stdout
    static void mathSqrt() {

        System.out.println("Enter a number to square root it.");

        double[] nums = getUserNums(1);
        double num1 = nums[0];

        System.out.println("Square root of " + num1 + " is: " + Math.sqrt(num1));

    }


    // User enters a number and prints rounded value
    static void mathRound() {

        System.out.println("Enter a number to round it.");

        double[] nums = getUserNums(1);
        double num1 = nums[0];

        System.out.println("Rounded value: " + Math.round(num1));

    }


    // Random number between 0 and 1 is printed to stdout
    static void mathRandom() {

        System.out.println("Random number between 0-1.00: " + Math.random());

    }


    // User enters two numbers and prints first number to the power of the second
    static void mathPow() {

        System.out.println("Enter two numbers to print the first value to the power of the second value.");

        double[] nums = getUserNums(2);
        double num1 = nums[0];
        double num2 = nums[1];

        System.out.println("Answer: " + Math.pow(num1, num2));

    }


    // Return numbers from user input (numberCount = number of numbers needed to be returned)
    static double[] getUserNums(int numberCount) {

            Scanner sc = new Scanner(System.in);


        if (numberCount == 1) {  // Only one number needs to be returned from user

            System.out.println("Your Number:");
            double num1 = sc.nextDouble();

            double[] nums = {num1};

            return nums;

        }
        else {  // Two numbers need to be returned from user

            System.out.println("Your Number 1:");
            double num1 = sc.nextDouble();

            System.out.println("Your Number 2:");
            double num2 = sc.nextDouble();

            double[] nums = {num1, num2};

            return nums;

        }
    }


    // User enters two numbers and prints largest number
    static void mathMax() {

        System.out.println("Enter two numbers to see which is largest.");

        double[] nums = getUserNums(2);
        double num1 = nums[0];
        double num2 = nums[1];

        System.out.println("Largest number is: " + Math.max(num1, num2));
    }


    // Acts as an user interface for user to test math methods etc.
    static void menu() {

        boolean menuLoop = true;
        while (menuLoop == true) {

            System.out.println("\n===== Math Main Menu =====");
            System.out.println("1: Math.max()");
            System.out.println("2: Math.pow()");
            System.out.println("3: Math.random()");
            System.out.println("4: Math.round()");
            System.out.println("5: Math.sqrt()");
            System.out.println("6: User-created - multiply()");
            System.out.println("7: User-created - divide()");
            System.out.println("==========================");
            System.out.println("8: Exit Program");
            System.out.println("==========================\n");

            Scanner sc = new Scanner(System.in);

            boolean loop = true;
            while (loop == true) {

                System.out.println("Your choice:");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        mathMax();
                        loop = false;
                        break;
                    case 2:
                        mathPow();
                        loop = false;
                        break;
                    case 3:
                        mathRandom();
                        loop = false;
                        break;
                    case 4:
                        mathRound();
                        loop = false;
                        break;
                    case 5:
                        mathSqrt();
                        loop = false;
                        break;
                    case 6:
                        mathMultiply();
                        loop = false;
                        break;
                    case 7:
                        mathDivide();
                        loop = false;
                        break;
                    case 8:
                        loop = false;
                        menuLoop = false; // Stop menu loop and exit program
                        break;
                    default: // If user inputs wrong int (no exceptions for erroneous user inputs)
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
