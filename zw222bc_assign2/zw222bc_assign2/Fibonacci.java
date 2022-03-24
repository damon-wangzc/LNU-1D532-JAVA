/**
 * Date: 2021-06-20
 * File Name: Fibonacci.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;

/**
 * Class Description: the class is to print a Fibonacci sequence starting with 1 and 2 and whose values do not exceed one thousand
 * 
 * @version 1.1 25 June 2021
 * @auther Zhicheng Wang
 */

public class Fibonacci 
{
    public static void main(String[] args) 
    {
        int lastnumber = 1;                         // use "lastnumber" to store the first number of the previous terms, start with 1
        int nextnumber = 2;                         // use "nextnumber" to store the second number of the previous terms, start with 2
        int number;                                 // use "number" as an intermediate storage in while-statement
        int oddsum = 0;                             // use "oddsum" to store the sum of odd integers in a Fibonacci sequence

        System.out.println("Fibonacci sequence starting with 1 and 2 while last number is less than 1000");
        
        // judge if the first number of the previous terms is an odd
        if (lastnumber % 2 == 1)
            oddsum += lastnumber;

        System.out.print(lastnumber);

        // use while-statement to get all the Fibonacci numbers and plus them to "oddsum"
        while (nextnumber <= 1000)
        {
            // judge if the second number of the previous terms is an odd
            if (nextnumber % 2 == 1)
                oddsum += nextnumber;

            System.out.print(", " + nextnumber);
            number = nextnumber;
            nextnumber = lastnumber + nextnumber;
            lastnumber = number;
        }
        
        System.out.println();
        System.out.println("The sum of the odd-valued Fibonacci numbers is " + oddsum);
    }    
}
