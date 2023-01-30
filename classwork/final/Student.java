/*
File Name:  Student.java
Programmer:  Dante F
Date:  Monday, 30th of January
Description: Student class, information about student and their grades
            
*/

import java.util.Scanner;  // For User stdin inputs 

// student class with information about legal names and test grades
class Student {

    // first and last names are strings
    String first, last;

    // test scores are doubles
    double test1, test2, test3;

    // return the test score of student
    public double getTestScore(int test) {

        double testScore;

        if (test == 1) {
            testScore = this.test1;
        }
        else if (test == 2) {
            testScore = this.test2;
        }
        else {
            testScore = this.test3;
        }

        return testScore;

    }


    // set a student's test score give the test number and score
    public void setTestScore(int testChoice, double newMark) {

        if (testChoice == 1) {
            this.test1 = newMark;
        }
        else if (testChoice == 2) {
            this.test2 = newMark;
        }
        else {
            this.test3 = newMark;
        }

    }


    // return a student's average over three tests
    public double getAverage() {

        double average = (this.test1 + this.test2 + this.test3) / 3;

        return average;

    }

    // Constructor for Student with name and grades.
    public Student(String first, String last, String test1, String test2, String test3) {
        this.first = first; // First name
        this.last = last; // Last name
        this.test1 = Double.parseDouble(test1);  // test 1 score
        this.test2 = Double.parseDouble(test2);  // test 2 score
        this.test3 = Double.parseDouble(test3);  // test 3 score

    }

}

