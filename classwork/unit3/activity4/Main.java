/*
File Name:  Main.java
Programmer:  Dante F
Date:  Friday, December 8, 2022
Description: - Display a list of 10 random numbers from a range of -1000 to +1000 //
             - Sort the original unsorted numbers in ascending order //
             - sort 4 separate times //
             - using selection, bubble, insertion, and quick sort algorithms //

             - For each method:
             - output name of method // 
             - output 10 random numbers sorted //
             - output number of times a loop while sorting was executed
             - output number of times numbers were compared 
             - output number of times a number's position was changed
*/

import java.util.ArrayList;  // Import ArrayLists used for database
import java.util.concurrent.ThreadLocalRandom;  // used for random nums


class Main {

    // global variables for counting
    // quicksort algorithm counters
    static int quickLoop = 0;  // loop counter for quicksort
    static int quickComparison = 0;  // comparison counter for quicksort
    static int quickShift = 0;  // shift counter for quicksort


    // swaps two values
    static void swap(ArrayList<Integer> nums, int index1, int index2) {
        int temp= nums.get(index1);
        quickShift++;

        nums.set(index1, nums.get(index2));
        quickShift++;

        nums.set(index2, temp);
    }


    // return a random pivot index between low and high
    static int getPivot(int low, int high) {
        return ThreadLocalRandom.current().nextInt(0, (high - low) + 1) + low;
    }


    // partition method
    // goes through each value, compares to pivot value
    // swaps items to left or right or pivot if needed
    static int partition(ArrayList<Integer> nums, int low, int high) {

        // swaps pivot value into leftmost position
        swap(nums, low, getPivot(low, high));

        // set a border just to right of pivot location
        int border = low + 1;

        // iterate through items in partition
        // compare each item to pivot
        for (int i = border; i <= high; i++) {
            quickLoop++;
            quickComparison++;

            // if item is lower than low array item then 
            // swap them
            if (nums.get(i) < nums.get(low)) {
            swap(nums, i, border++);
            }
        }

        // when finished swap pivot into proper position
        swap(nums, low, border-1);

        // return index of pivot value
        return border-1;
    }


    // quick sort algothim starter procedure
    static void quickSort(ArrayList<Integer> nums, int low, int high) {
        quickComparison++;
        
        // if there is more than 1 item to sort
        // in the list
        if (low < high + 1) {

            // get new pivot value from partition method (p)
            int p = partition(nums, low, high);

            // call quicksort on left and right partition
            quickSort(nums, low, p-1);
            quickSort(nums, p+1, high);
        }
    }


    // quick sort algorithm
    // calls the quicksort algorithm
    // sort arraylist using quicksort sorting algorithm
    static void quick(ArrayList<Integer> nums) {

        // pass in arraylist and first and last indexes of nums arraylist
        quickSort(nums, 0, nums.size() - 1);
        System.out.println("Quick Sort:\n" + nums);
        displayCounters(quickLoop, quickComparison, quickShift);
    }


    // insertion sort
    // sort arraylist using insertion sort algorithm
    static void insertion(ArrayList<Integer> nums) {

        int loopCounter = 0;
        int comparisonCounter = 0;
        int shiftCounter = 0;

        // outer loop i
        // inner loop counter j
        // temp var for swaps
        int i, j, key, temp;

        for (i = 1; i < nums.size(); i++) {
            loopCounter++;

            // initialize key to list of i
            key = nums.get(i);

            // element to i's left
            j = i - 1;

            // iterate through list of items to left of i
            while (j >= 0 && key < nums.get(j)) {

                comparisonCounter++;
                loopCounter++;

                temp = nums.get(j);
                shiftCounter++;

                nums.set(j, nums.get(j+1));
                shiftCounter++;

                nums.set(j+1, temp);
                j--;
            }
        }
        System.out.println("Insertion Sort:\n" + nums);
        displayCounters(loopCounter, comparisonCounter, shiftCounter);
    }


    // bubble sort algorithm
    // sorts an arraylist using bubble sort
    static void bubble(ArrayList<Integer> nums) {

        int loopCounter = 0;
        int comparisonCounter = 0;
        int shiftCounter = 0;

        // i for outer loop
        // j for inner loop
        // temp for swaps
        int i, j, temp = 0;

        // outer loop
        for (i = 0; i < nums.size() - 1; i++) {
            loopCounter++;
            
            // inner loop
            for (j = 0; j < nums.size() - 1 - i; j++) {
                loopCounter++;
                comparisonCounter++;

                // compare item to item on it's right
                if (nums.get(j) > nums.get(j+1)) {
                    temp = nums.get(j);

                    shiftCounter++;
                    nums.set(j, nums.get(j+1));
                    shiftCounter++;
                    nums.set(j+1, temp);
                }
            }
        }

        System.out.println("Bubble Sort:\n" + nums);
        displayCounters(loopCounter, comparisonCounter, shiftCounter);
    }


    // selection sort
    // sorts an arraylist using the selection
    // sort algorithm
    static void selection(ArrayList<Integer> nums) {

        // index counters
        int i, j, minValue, minIndex, temp = 0;

        // Loop counters and comparisonCounter

        int loopCounter = 0;
        int comparisonCounter = 0;
        int shiftCounter = 0;

        // loop through arraylist
        for (i = 0; i < nums.size(); i++) {
            loopCounter++;

            // initialize minValue and minIndex
            // to first unsorted item 
            minValue = nums.get(i);
            minIndex = i;

            // start at first unsorted item and 
            // loop through last item in list
            for (j = i; j< nums.size(); j++) {
                loopCounter++;
            
                comparisonCounter++;
                
                // if list item is less than minValue
                // change the minValue to that index
                if (nums.get(j) < minValue) {
                    minValue = nums.get(j);
                    minIndex = j;
                }
            }

            comparisonCounter++;
            // check if minimum value was the 
            // first value
            // if not no need to swap
            if (minValue < nums.get(i)) {
                temp = nums.get(i);
                nums.set(i, nums.get(minIndex));

                shiftCounter++;
                nums.set(minIndex, temp);
                shiftCounter++;
            }
        }

        System.out.println("Selection Sort:\n" + nums);
        displayCounters(loopCounter, comparisonCounter, shiftCounter);
    }


    // Display the counters for each sorting algorithm
    static void displayCounters(int loopCounter, int comparisonCounter, int shiftCounter) {
        System.out.println("Number of times a loop was executed: " + loopCounter);
        System.out.println("Number of times a comparison was made: " + comparisonCounter);
        System.out.println("Number of times a value was shifted: " + shiftCounter + "\n");
    }


    // display randomly generated nums to user
    static void displayNums(ArrayList<Integer> nums) {

        System.out.println("Randomly generated 10 numbers UNSORTED:\n" + nums + "\n");

    }


    // return a random array list of nums between
    // -1000 and +1000
    static ArrayList<Integer> getNums() {

        // array for 10 random nums
        ArrayList<Integer> nums = new ArrayList<Integer>(); // Create an ArrayList object
        
        // generate 10 random numbers and add them
        // to the array list
        for (int i = 0; i < 10; i++) {
            //            arguments = MIN, MAX (exclusive of top value)
            // generate random number between -1000 and 1000 (inclusive)
            nums.add(ThreadLocalRandom.current().nextInt(-1000, 1001));
        }

        return nums;

    }


    // Main method
    public static void main(String[] args) {

        // get array list of 10 random nums between
        // -1000 and 1000
        ArrayList<Integer> nums = getNums();

        // display unsorted list of nums
        displayNums(nums);

        // copies of nums arraylist for each sorting algorithm
        // using original 'nums' arraylist will sort an already
        // sorted list. so I had to make copies.
        ArrayList<Integer> nums1 = new ArrayList<>(nums);
        ArrayList<Integer> nums2 = new ArrayList<>(nums);
        ArrayList<Integer> nums3 = new ArrayList<>(nums);
        ArrayList<Integer> nums4 = new ArrayList<>(nums);

        // sorting algorithms
        // sorts each arraylist individually
        selection(nums1);
        bubble(nums2);
        insertion(nums3);
        quick(nums4);

    }
}

