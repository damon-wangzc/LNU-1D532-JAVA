/**
 * Date: 2021-06-20
 * File Name: ArmstrongNumber.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class Description: the class is to get all Armstrong numbers between two input integers
 * 
 * @version 1.1 25 June 2021
 * @auther Zhicheng Wang
 */

public class ArmstrongNumber 
{
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);
        String yesorno = "Y";                           // yesorno is used to determine if stop or continue entering range
        int start = 0;                                  // the starting number of the range
        int end = 1;                                    // the ending mumber of the range
        int number;                                     // "number" is used to replace "i" to computing in the for-loop
        int armstrongnum;                               // store the Armstrong Number
        
        // do-while statement is to stop or continue entering range by judging "yesorno"
        do
        {
            Boolean done = false;                       // a boolean index to end the input when input data type is correct
            
            // To repeat the input if the input is not correct
            while (! done)
            {
                // Use try-catch to check if there is a wrong input type
                try                                                            
                {
                    System.out.print("Enter the starting number of the range: ");
                    start = keyboardin.nextInt();

                    if (start <= 0)                      // If-else statement to check if the input is a non positive value
                    {
                        System.out.println();
                        System.out.println("The starting number can't be a non positive integer. Please enter again!");
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

            done = false;

            // To repeat the input if the input is not correct
            while (! done)
            {
                // Use try-catch to check if there is a wrong input type 
                try                                                            
                {
                    System.out.print("Enter the ending number of the range: ");
                    end = keyboardin.nextInt();

                    if (end <= start)                    // If-else statement to check if the input is a non positive value
                    {
                        System.out.println();
                        System.out.println("The ending number should be larger than the starting number. Please enter again!");
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

            System.out.println();
            System.out.println("The Armstrong numbers between the given range are: ");
            
            // for-loop traverse all the integers between "start" and "end" to find the all Armstrong numbers 
            for (int i = start; i <= end; i++)
            {
                number = i;                             // "number" is used to computing and "i" for the if judgement
                armstrongnum = 0;                       // initialize the armstrongnum for each loop
                int nth = 0;                            // nth power acoording to the number of digits

                // get the number of digits
                for (int j = 10; ; j *= 10)
                {
                    nth++;
                    if (number / j == 0)    
                        break;
                }
                
                // Computing the armstrongnum from the most right/lowest-place digit 
                while (number >= 10)
                {
                    armstrongnum += Math.pow(number % 10, nth);   // use Math.pow to computing the nth power of the individual digits
                    number /= 10;                       // delete the most right/lowest-place digit using dividing
                }
                armstrongnum += Math.pow(number, nth);    // add the nth power of the most left/highest-place digits
                
                // if Armstrong number, print it
                if (i == armstrongnum)
                    System.out.println(i);

            }

            done = false;

            // judge if type Y/y or N/n
            while (! done)
            {
                System.out.print("Do you want to repeat? (Y/N) : ");
                yesorno = keyboardin.next().toLowerCase();      // input the string to determin if ending or continue, can use both Lower/Upper case
                
                // if entering correct y or n, end while-loop
                if ((! yesorno.equals("y")) && (! yesorno.equals("n")))
                {   
                    System.out.println();
                    System.out.println("Please enter Y/y (Yes) or N/n (No)");  
                    keyboardin.nextLine();
                } 
                else
                    done = true;     
            }

            System.out.println();
        } while (yesorno.equals("y"));

        keyboardin.close();
    }
}
