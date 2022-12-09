/*
File Name:  Main.java
Programmer:  Dante F
Date:  Friday, December 8, 2022
Description: - Display a list of 10 random numbers from a range of -1000 to +1000 //
             - Sort the original unsorted numbers in ascending order
             - sort 4 separate times
             - using selection, bubble, insertion, and quick sort algorithms

             - For each method:
             - output name of method
             - output 10 random numbers sorted
             - output number of times a loop while sorting was executed
             - output number of times numbers were compared 
             - output number of times a number's position was changed
*/

import java.util.ArrayList;  // Import ArrayLists used for database
import java.util.concurrent.ThreadLocalRandom;  // used for random nums


class Main {


    // display randomly generated nums to user
    static void displayNums(ArrayList<Integer> nums) {

        System.out.println("Randomly generated list of numbers:\n" + nums + "\n");

    }


    // return a random array of nums between
    // -1000 and +1000
    // static int[] getNums() {
    static ArrayList<Integer> getNums() {

//         // int[] array method
//         // array for 10 random nums
//         int[] nums = new int[10];
        
//         for (int i = 0; i < 10; i++) {
//             //            arguments = MIN, MAX (exclusive of top value)
//             nums[i] = ThreadLocalRandom.current().nextInt(-1000, 1001);
//         }

//         for (int i = 0; i < 10; i++) {
//             System.out.println(nums[i]);
//         }


        // array for 10 random nums
        ArrayList<Integer> nums = new ArrayList<Integer>(); // Create an ArrayList object
        
        // generate 10 random numbers and add them
        // to the array list
        for (int i = 0; i < 10; i++) {
            //            arguments = MIN, MAX (exclusive of top value)
            // generate random number between -1000 and 1000 (inclusive)
            nums.add(ThreadLocalRandom.current().nextInt(-1000, 1001));
        }

        // for (int i = 0; i < 10; i++) {
        //     System.out.println(nums.get(i));
        // }

        // System.out.println(nums);

        return nums;

    }


    // Main method
    public static void main(String[] args) {

        // int[] nums = getNums();

        // get array list of 10 random nums between
        // -1000 and 1000
        ArrayList<Integer> nums = getNums();

        // display formatted nums 
        displayNums(nums);

        // sort algorithms
        // selection(nums);
        // bubble(nums);
        // insertion(nums);
        // quick(nums);

    }
}

