/**
 * Grades.java
 * Author: Zhicheng Wang
 * Student ID: zw222bc
 */

package zw222bc_assign1;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A program to calculate the grade using the total mark and the mark obtained
 */

public class Grades {
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);
        int total = 0, marks = 0;
        double grades;
        Boolean done = false;                                              // Use as an index to end the loop

        // To repeat the input if the input can't meet the requirement
        while (! done)
        {
            // Use try-catch to check if there is a wrong type input
            try                                                            
            {
                System.out.print("Please enter total marks: ");
                total = keyboardin.nextInt();

                if (total < 0)                                             // If-else statement to check if the input is a negative value
                {
                    System.out.println("You enter a negative value");
                    System.out.println("Please enter again");
                }
                else
                    done = true;
            }
            catch (InputMismatchException e)
            {
                keyboardin.nextLine();
                System.out.println("You enters a non-integer value");
                System.out.println("Please enter again");
            }
        }

        done = false;                                                      // initialize the "done"

        while (! done)
        {
            try
            {
                System.out.print("Please enter marks obtained: ");
                marks = keyboardin.nextInt();

                if (marks < 0)
                {
                    System.out.println("You enter a negative value");
                    System.out.println("Please enter again");
                }
                else if (marks > total)
                {    System.out.println("You enter a mark larger than the total mark");
                    System.out.println("Please enter again");
                }
                else
                    done = true;
            }
            catch (InputMismatchException e)
            {
                keyboardin.nextLine();
                System.out.println("You enters a non-integer value");
                System.out.println("Please enter again");
            }
        }

        grades = marks * 100.0 / total;

        if (grades >= 90)
            System.out.println("Congratulations, you have passed the course with grade A");
        else if (grades >= 80)
            System.out.println("Congratulations, you have passed the course with grade B");
        else if (grades >= 75)
            System.out.println("Congratulations, you have passed the course with grade C");
        else if (grades >= 70)
            System.out.println("Congratulations, you have passed the course with grade D");
        else if (grades >= 60)
            System.out.println("Congratulations, you have passed the course with grade E");
        else
            System.out.println("You could not pass this time :(, please try again! Your grade is F");

        keyboardin.close();
    }
}