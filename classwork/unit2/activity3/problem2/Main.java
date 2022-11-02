/*
File Name:  Main.java
Programmer:  Dante F
Date:  Sunday, October 28, 2022
Description: A program that checks if two words are
             anagrams of each other WITHOUT USING SORTING METHODS.
*/


import java.util.Scanner;  // User stdin inputs 

class Main {

    // Method that compares two words and checks if they are
    // anagrams of each other WITHOUT using sorting methods
    // returns true if words are anagram and returns false if words aren't anagrams.
    static boolean isAnagram(String word0, String word1) {

        // Convert strings to char arrays without spaces and all lowercase
        char[] word0Array = word0.replaceAll(" ", "").toLowerCase().toCharArray();
        char[] word1Array = word1.replaceAll(" ", "").toLowerCase().toCharArray();

        // Array to keep count of how many times each letter
        // appears in each word
        int[] letterCount = new int[26];

        // Iterate through characters of word0
        // and count appearance of each letter in word
        // and incremend count in letterCount[]
        for (char letter: word0Array) {
            int ascii = letter;  // Convert char to ASCII int value
            int letterIndex = ascii - 97;  // Index for letterCount
            letterCount[letterIndex]++;  // Add one to the count for that letter
        }

        // Iterate through characters of word1
        // and count appearance of each letter in word
        // and store in letterCount[]
        for (char letter: word1Array) {
            int ascii = letter;  // Convert char to ASCII int value
            int letterIndex = ascii - 97;  // Index for letterCount
            letterCount[letterIndex]--;  // subtract one from the count for that letter
        }

        // If letterCount is all 0's, that means that both
        // words are anagrams of each other.

        // Check if array is all 0's 
        // (both words are anagrams)
        boolean anagram = true;
        for (int i : letterCount) {  // Iterate through elements of array
            if (i != 0) {  // Words are not anagrams of each other
                anagram = false; 
                break;  // break loop to prevent checking rest of letters
                        // unnecessarily
            }
        }

        return anagram;
    }


    // Get two words from user input
    // Return array of both words
    static String[] getWords() {
        
        Scanner sc = new Scanner(System.in);

        // Get first word from user
        System.out.print("Enter first word to be checked: ");
        String word0 = sc.nextLine();

        // Get second word from user
        System.out.print("Enter second word to be checked: ");
        String word1 = sc.nextLine();

        // Array with first and second word
        String[] words = {word0, word1};

        // Return array with words
        return words;

    }


    // Interactive MENU acts as user interface 
    // for user to choose operations
    // and calculate values.
    static void menu() {

        // Loop until user wants to exit program
        boolean menuLoop = true;
        while (menuLoop == true) {

            // Format Menu
            String message = "\n===== Anagram Main Menu =====\n"+
                             "1: Anagram Checker\n"+
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
                    case "1":  // User wants to check if the words are anagrams

                        // Get words from user stored in array
                        String[] words = getWords();

                        // Get individual words from array
                        String word0 = words[0];
                        String word1 = words[1];

                        // Check if words are anagrams
                        if (isAnagram(word0, word1) == true) {  // Words are anagrams
                            System.out.println(word0 + " is an anagram of " + word1);
                        }
                        else {  // Words are not anagrams
                            System.out.println(word0 + " is NOT an anagram of " + word1);
                        }

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


    // Main
    public static void main(String[] args) {

        // Menu
        menu();

        System.out.println("Exited, Goodbye!"); // User has exited the main menu interface
    }
}

