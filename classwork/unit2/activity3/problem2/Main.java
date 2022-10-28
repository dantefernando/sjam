/*
File Name:  Main.java
Programmer:  Dante F
Date:  Sunday, October 27, 2022
Description: A program that checks if two words are
             anagrams of each other WITHOU USING SORTING METHODS.
*/


import java.util.Scanner;  // User stdin inputs 
import java.util.Arrays;  // For Array sorting


class Main {

    static void compareWords(String word0, String word1) {

        // Convert strings to char arrays without spaces and all lowercase
        char[] word0Array = word0.replaceAll(" ", "").toLowerCase().toCharArray();
        char[] word1Array = word1.replaceAll(" ", "").toLowerCase().toCharArray();

        // Sort arrays alphabetically
        Arrays.sort(word0Array);
        Arrays.sort(word1Array);

        // Convert arrays to strings
        String word0Sorted = new String(word0Array);
        String word1Sorted = new String(word1Array);

        // Check if strings are equal
        if (word0Sorted.equals(word1Sorted)) {
            System.out.println(word0 + " is an anagram of " + word1);
        }
        else {
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
