
/*
File Name:  Main.java
Programmer:  Dante F
Date:  Sunday, October 9, 2022
Description:  Program that displays powers for a base
              from exponent 1 up to the number inputted by the user.
*/

import java.util.Scanner;  // Import scanner for user inputs

// Main Class
class Main {

	// Prints bases to power of exponent to stdout
	// WITHOUT math.pow() method. 
	static void printPowers(int[] nums) {

		// Get base and exponent from array
		int base = nums[0];
		int exponent = nums[1];

        // Print exponent to base of 1
        System.out.println(base + " to the exponent 1 is " + base);

		if (exponent > 1) { // User inputted exponent greater than 1

			// Set the current base
			long currentBase = base;

			// Loop through exponents and print answers
			for (int i = 2; i <= exponent; i++) {

                // set calculated value to newNum
				long newNum = currentBase * base;

                // Print the base to the power of exponent with calculated value
				System.out.println(base + " to the exponent "  + i + " is " + newNum);

                // Set the calculated value to the currentBase to be used next loop
				currentBase = newNum;
			}
		}
	}


	// Store base and exponent from user and return 
	// array with base and nums
	static int[] getNums() {
		Scanner sc = new Scanner(System.in);

		// Store base from user input 
		System.out.println("Enter BASE of number:");
		int base = sc.nextInt();	

		// Store exponent from user input
		System.out.println("Enter EXPONENT of number:");
		int exponent = sc.nextInt();	

		// Create nums array with base and exponent
		int[] nums = {base,exponent};

		// Return base and exponent in form of int[] array
		return nums;
	}


	// Main
	public static void main(String[] args) {
		
		// Get base and exponent from user
		int[] nums = getNums();  

		// Print powers to stdout
		printPowers(nums);
	}	
}
