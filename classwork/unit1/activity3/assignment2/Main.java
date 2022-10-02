// Written by Dante Fernando 2022

import java.util.Scanner;

public class Main {

    // Print Days alive and hours slept to stdout
    static void displayFinalCalculations(int daysAlive, int hoursSlept) {

        System.out.println("Days alive since birth: " + daysAlive);
        System.out.println("Hours slept each night since birth: " + hoursSlept);

    }


    // Return hours user has slept since birth
    static int getSleep(int daysAlive) {

        int hoursSlept = daysAlive * 8;

        return hoursSlept;
    }


    // Return the number of days the user has been alive since birth
    static int getDaysAlive(int[] birthday, int[] today) {

        // Calculate days since start of time til birthday
        int totalDaysBirthday = (birthday[0]) + (birthday[1]*30) + (birthday[2]*365);

        // Calculate days since start of time til today
        int totalDaysToday = (today[0]) + (today[1]*30) + (today[2]*365);

        // Calculate days alive since birthday
        int daysAlive = totalDaysToday - totalDaysBirthday;

        // Return Days alive since birth til todays date (specified by user)
        return daysAlive;
    }


    // Get today's/birthday date from user and return info as array
    static int[] getDate(boolean isBirthday) {

        String msgDay, msgMonth, msgYear;

        if (isBirthday == true) { // Display messages about users's birthday
            msgDay = "Enter DAY of Birth: e.g. \"10\" and press enter:";
            msgMonth = "Enter MONTH of Birth:";
            msgYear = "Enter YEAR of Birth:";
        }
        else { // Display messages for today's date
            msgDay = "Enter Today's DAY: e.g. \"10\" and press enter:";
            msgMonth = "Enter Today's MONTH::";
            msgYear = "Enter Today's YEAR::";
        }

        Scanner sc = new Scanner(System.in);

        System.out.println(msgDay);
        int day = sc.nextInt();  // Get day from user input

        System.out.println(msgMonth);
        int month = sc.nextInt();  // Get month from user input

        System.out.println(msgYear);
        int year = sc.nextInt(); // Get year from user input

        System.out.println("\n\n");

        int[] date = {day,month,year};  // Store birthday information in array

        return date;  // Return birthday array info
    }


    // Send welcome message to user at runtime
    static void sendWelcome() {
        System.out.println("##############################");
        System.out.println("Author: Dante Fernando");
        System.out.println("A Program to Calculate number of hours");
        System.out.println("a person has spent sleeping from birth");
        System.out.println("to date today. (both specified by user.)\n\n");
    }


    // Main
    public static void main(String[] args) {
        sendWelcome();                  // Welcome user to program.
        int[] birthday = getDate(true); // Get User's birthday from user
        int[] today = getDate(false);                   // Get Today's date from user
        int daysAlive = getDaysAlive(birthday, today);              // Returns Number of days alive since birth
        int hoursSlept = getSleep(daysAlive);                  // Returns time slept in hours since birth
        displayFinalCalculations(daysAlive, hoursSlept);  // Print days user has been alive for and slept during
                                                          // lifetime
    }
}
