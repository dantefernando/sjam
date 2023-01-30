/*
File Name:  Student.java
Programmer:  Dante F
Date:  Monday, 30th of January
Description: Student class, contains blueprint for 
information about student and their grades
can also do calculations.
            
*/

import java.util.Scanner;  // For User stdin inputs 

// student class with information about legal names and test grades
// can change student attributes and perform calculations if needed
// getters and setters available

class Student {

    String first, last;  // first and last names
    double test1, test2, test3;  // test scores


    // Change the name of a student
    // nameToChange: first or last name
    // newName: new name to change
    public void changeName(int nameToChange, String newName) {

        if (nameToChange == 0) {  // first name
            this.first = newName;
        }
        else {
            this.last = newName;
        }
    }


    // return the test score of student
    // test: test to return the score of
    public double getTestScore(int test) {

        double testScore;

        if (test == 1) {  // test 1
            testScore = this.test1;
        }
        else if (test == 2) {  // test 2
            testScore = this.test2;
        }
        else {  // test 3
            testScore = this.test3;
        }

        // return  test score that the user is requesting
        return testScore;

    }


    // set a student's test score give the test number and score
    // testChoic: the test to set the new score to
    // newMark: the test's new mark assigned by user
    public void setTestScore(int testChoice, double newMark) {

        if (testChoice == 1) {  // test1
            this.test1 = newMark;
        }
        else if (testChoice == 2) {  // test2
            this.test2 = newMark;
        }
        else {  // test3
            this.test3 = newMark;
        }

    }


    // return a student's average over three tests
    public double getAverage() {

        // calculate average (sum of grades divided by total num of tests)
        double average = (this.test1 + this.test2 + this.test3) / 3;

        return average;

    }


    // Constructor for Student with name and grades.
    // first: first name
    // last: last name
    // test1: test1 score
    // test2: test2 score
    // test3: test3 score
    public Student(String first, String last, String test1, String test2, String test3) {
        this.first = first; // First name
        this.last = last; // Last name
        this.test1 = Double.parseDouble(test1);  // test 1 score
        this.test2 = Double.parseDouble(test2);  // test 2 score
        this.test3 = Double.parseDouble(test3);  // test 3 score

    }

}

