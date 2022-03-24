/**
 * Numbers.java
 * Author: Zhicheng Wang
 * Student ID: zw222bc
 */

package zw222bc_assign1;
import java.util.Scanner;

/**
 * A program to calculate the sum and product of a single three-digit integer number
 */

public class Numbers {
    public static void main(String[] args)
    {
        Scanner keyboardin = new Scanner(System.in);
        int digit, digsum, digpro;

        System.out.print("Enter a three-digit integer number: ");
        digit = keyboardin.nextInt();

        digsum = digit / 100 + (digit % 100) / 10 + digit % 10;           // get the sum
        digpro = (digit / 100) * ((digit % 100) / 10) * (digit % 10);     // get the product

        System.out.println("Sum of the digits of the integer number is: " + digsum);
        System.out.println("Product of the digits of the integer number is: " + digpro);

        keyboardin.close();
    }
}
