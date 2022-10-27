import java.util.Scanner;  // User stdin inputs 

class Main {


    // Get two words from user input
    static String[] getWords() {
        
        Scanner sc = new Scanner(System.in);

        // Get first word 
        System.out.println("Enter first word to be checked: ");
        String word0 = sc.nextLine();

        // Get second word 
        System.out.println("Enter second word to be checked: ");
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
        // compareWords(word0, word1);

    }


}
