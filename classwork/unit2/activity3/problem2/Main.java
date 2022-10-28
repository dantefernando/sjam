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
    static void compareWords(String word0, String word1) {

        // Convert strings to char arrays without spaces and all lowercase
        char[] word0Array = word0.replaceAll(" ", "").toLowerCase().toCharArray();
        char[] word1Array = word1.replaceAll(" ", "").toLowerCase().toCharArray();

        // Array to keep count of how many times each letter
        // appears in each word
        int[] letterCount = new int[26];

        // Iterate through characters of word0
        for (char letter: word0Array) {
            int ascii = letter;  // Convert to ASCII 
            int letterIndex = ascii - 97;  // Index for letterCount
            letterCount[letterIndex]++;  // Add one to the count for that letter
        }

        // Iterate through characters of word1
        for (char letter: word1Array) {
            int ascii = letter;  // Convert to ASCII 
            int letterIndex = ascii - 97;  // Index for letterCount
            letterCount[letterIndex]--;  // takeaway one to the count for that letter
        }

        // Check if array is all 0's 
        // (both words are anagrams)
        boolean isAnagram = true;
        for (int i : letterCount) {
            if (i != 0) {
                isAnagram = false;
            }
        }

        if (isAnagram == true) {  // Words are anagrams
            System.out.println(word0 + " is an anagram of " + word1);
        }
        else {  // Words are not anagrams
            System.out.println(word0 + " is NOT an anagram of " + word1);
        }
    }


    // Get two words from user input
    // Return array of both words
    static String[] getWords() {
        
        Scanner sc = new Scanner(System.in);

        // Get first word 
        System.out.print("Enter first word to be checked: ");
        String word0 = sc.nextLine();

        // Get second word 
        System.out.print("Enter second word to be checked: ");
        String word1 = sc.nextLine();

        // Array with first and second word
        String[] words = {word0, word1};

        // Return array with words
        return words;

    }


    // Main
    public static void main(String[] args) {

        // Get words from user
        String[] words = getWords();

        String word0 = words[0];
        String word1 = words[1];

        // Check if words are anagrams
        compareWords(word0, word1);

    }
}
