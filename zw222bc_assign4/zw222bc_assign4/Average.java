/**
 * Date: 2021-07-10
 * File Name: Average.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Class Description: calculate the input numbers' average
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class Average 
{
    /**
     * The main function
     * @param args
     */
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);            // a Scanner instance
        int numCount = 1;                                       // the number of number-input times
        double numCountDouble;                                  // used to calculate in a double form
        double sumNumbers = 0;                                  // the sum of the numbers
        double numberEntered = 0;                               // each entered numbers
        boolean done = false;                                   // index to finish input
        DecimalFormat df = new DecimalFormat("0.00");           // output decimal formate

        // get how many numbers will be inputed
        do
        {
            try
            {
                System.out.print("How many numbers do you want to enter? ");
                numCount = keyboardin.nextInt();

                if (numCount <= 0)
                    // throw the NonPositiveException if the input number is less than 1
                    throw new NonPositiveException("Number must be greater than 0.");
                else
                    done = true;
            } 
            catch (NonPositiveException e_nonPositive)
            {
                // catch the NonPositiveException and display the error message
                System.out.println(e_nonPositive.getMessage());
            }
            catch (InputMismatchException e)
            {
                // catch the InputMismatchException, if the input value is not an integer
                System.out.println("You input is not an integer. Please enter again.");
                keyboardin.nextLine();
            }
        } while (! done);
        
        // input numbers
        for (int i = 0; i < numCount; i++)
        {
            done = false;
            do
            {
                try 
                {
                    System.out.println("Enter number " + (i + 1));
                    numberEntered = keyboardin.nextDouble();
                    sumNumbers += numberEntered;
                    done = true;    
                } 
                catch (InputMismatchException e_entered) 
                {
                    // catch InputMismatchException, if the input is not a double form
                    System.out.println("You entered a non numeric value which is not allowed.\nPlease enter the number again.");
                    keyboardin.nextLine();
                }
            } while (! done);
        }

        // calculate and display the average value
        numCountDouble = numCount;
        System.out.println("Average of the entered numbers is " + df.format(sumNumbers / numCountDouble));
        keyboardin.close();
    }    
}
