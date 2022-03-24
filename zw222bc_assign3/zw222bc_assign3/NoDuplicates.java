/**
 * Date: 2021-06-28
 * File Name: NoDuplicates.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Description: This class is to prompt a user to enter five unique numbers, 
 *                    each between 10 and 100, with no duplicate values.
 *                    Five numbers will be stored in an array and sorted in the descending order.
 *                    Every time entering a number, display the entered numbers in the descending order.
 *                    While entering numbers out of range or duplacate, display error message and enter again.
 * 
 * @version 1.1 02 July 2021
 * @auther Zhicheng Wang
 */

public class NoDuplicates 
{
    // The "descendOrder" method is to sort an array in a descending order (lagest first)
    // This method uses counting the comparing results to sort (Number of times greater than other values)
    public static int[] descendOrder(int[] intArray) 
    {
        int length = intArray.length;           // the length of the array
        int[] sortedArray = new int[length];    // sortedArray as a return array
        int count = 0;                          // count is used to determine the order of each number in the array

        // Count the number of times greater than other values (nested loop)
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                // Comparing and counting
                if (i == j)
                    ;                           // jump comparing the same value
                else if (intArray[i] > intArray[j])
                    count++;                    // counting

                    // initialize the count to 0 while finshing comparing (for each number)
                    if (j == length - 1)
                    {
                        sortedArray[length - 1 - count] = intArray[i];
                        count = 0;
                    }
            }
        }
        return sortedArray;
    }

    // The "isDuplicate" method return true if "inputInteger" is a duplicate value 
    // (if there is already a same value in the "intArray")
    public static boolean isDupliacte(int[] intArray, int inputInteger) 
    {
        boolean duplication = false;                    // the returned value, initialized by "false"
        int length = intArray.length;                   // the length of the array

        // traverse all the numbers in the array and break the loop if there is any duplicate number
        for (int i = 0; i < length; i++)
        {
            if (intArray[i] == inputInteger)
            {    
                duplication = true;
                System.out.println(inputInteger + " has already been entered.");    // Display the error message
                break;
            }
        }
        return duplication;
    }

    // The "outRange" method return true if the "inputInteger" is out of range [10, 100]
    public static boolean outRange(int inputInteger) 
    {
        boolean outside = false;                        // the returned value, intialized by "false"

        // judge if the inputInteger is out of range
        if (inputInteger < 10 || inputInteger > 100)
        {    
            System.out.println("Number must be between 10 and 100.");                // dispaly the error message
            outside = true;
        }
        return outside;    
    }

    // The "dispplayArray" method prints "intArray" in one line, separated by a space
    public static void displayArray(int[] intArray) 
    {
        int length = intArray.length;                   // the length of the array

        // display values in the array one by one in a line, separated by a space 
        for (int i = 0; i < length; i++)
            System.out.print(intArray[i] + " ");
        System.out.println();
    }

    // The main function to excute the program
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);                    // input stream
        int[] uniqueNumbers = {-1000, -1000, -1000, -1000, -1000};      // uniqueNumbers is to store entered numbers successively
        int[] orderedNumbers = {-1000, -1000, -1000, -1000, -1000};     // orderedNumbers is to store ordered/sorted array
        int inputInteger = 0;                                           // inputInteger is to store the imput number

        System.out.println("Please enter five unique numbers.");

        // Enter 5 numbers in turn 
        for (int i = 0; i < 5; i++)
        {
            // judge if the entered number is a right input type or out of range or a duplicate number
            do
            {
                Boolean notInteger = true;                              // a marker to show the enter number is an integer or not

                //judge if the entered number is an integer
                do
                {
                    // catch the InputMismatchException error if the entered value is not an integer
                    try
                    {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        inputInteger = keyboardin.nextInt();
                        notInteger = false;
                    } catch (InputMismatchException e)
                    {
                        notInteger = true;
                        System.out.println("You enter a non-integer value. Please enter again.");
                        keyboardin.nextLine();
                    }
                }
                while (notInteger);
            }
            while (outRange(inputInteger) || isDupliacte(uniqueNumbers, inputInteger));

            uniqueNumbers[i] = inputInteger;                            // store input numbers in "uniqueNumbers"
            orderedNumbers = descendOrder(uniqueNumbers);               // sort the entered numbers in "uniqueNumbers" and assign to "orderedNumbers"
            
            // Print the entered numbers in the descending order
            for (int j = 0; j <= i; j++)
            {
                System.out.print(orderedNumbers[j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("Numbers in the Entered Order: ");
        displayArray(uniqueNumbers);                                    // display the entered array

        System.out.print("Numbers in the Sorted Order: ");
        displayArray(orderedNumbers);                                   // display the orderd array

        keyboardin.close();
    }    
}
