/**
 * Date: 2021-06-20
 * File Name: SquareRoot.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;

/**
 * Class Description: Use the Babylonian algorithm to compute square root of a positive number
 * 
 * @version 1.1 25 June 2021
 * @auther Zhicheng Wang
 */

public class SquareRoot 
{
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);    // Use Scanner to read the input from keyboard
        keyboardin.useLocale(Locale.ENGLISH);
        int n = 0;                                          // n is used to store the input integer
        double guess;                                   // guess is used to store the new guess
        double current;                                 // current is used to store the current guess
        double diff = 1;                                // diff is the diffenece of current guess and the new guess
        Boolean done = false;                           // a boolean index to end the input when input data type is correct
        
        System.out.println("This program estimate square roots.");
        
        // To repeat the input if the input is not a integer
        while (! done)
        {
            // Use try-catch to check if there is a wrong type input
            try                                                            
            {
                System.out.print("Enter an integer to estimate the square root of: ");
                n = keyboardin.nextInt();

                if (n <= 0)                                             // If-else statement to check if the input is a non positive value
                {
                    System.out.println();
                    System.out.println("You enter a non-positive integer. Please enter again!");
                    keyboardin.nextLine();
                }
                else
                    done = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println();
                System.out.println("You enters a non-integer value. Please enter again!");
                keyboardin.nextLine();
            }
        }
        
        guess = n / 2.0;                                // The initial guess uses the half of the input integer

        // while-loop stops when the difference of the current guess and the new guess is smaller than 1%
        while (diff >= 0.001)
        {
            current = guess;
            guess = (guess + n / guess) / 2.0;
            System.out.println("Current guess: " + guess);
            diff = Math.abs(current - guess);
        }

        System.out.println();
        System.out.println("The estimated square root of " + n + " is   " + String.format("%.2f", guess));  //print the newest guess number

        keyboardin.close();
    }
}
