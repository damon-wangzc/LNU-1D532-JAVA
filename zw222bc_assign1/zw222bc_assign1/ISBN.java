/**
 * ISBN.java
 * Author: Zhicheng Wang
 * Student ID: zw222bc
 */

package zw222bc_assign1;
import java.util.Scanner;

/**
 * A program to calculate the ISBN
 */

public class ISBN {
    public static void main(String[] args)
    {
        Scanner keyboardin = new Scanner(System.in);
        int isbn, isbncp, checksum, total = 0, count = 9;

        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        isbn = keyboardin.nextInt();
        isbncp = isbn;

        // calculate the checksum
        while (isbncp != 0)
        {
            total += (isbncp % 10) * count;
            count --;
            isbncp /= 10;
        }

        checksum = total % 11;

        // if the checksum is 10, add X; at the same time to add 0 if the input starting with o
        if (checksum == 10)
            System.out.println("The ISBN-10 number is " + String.format("%09d", isbn) + "X");
        else
            System.out.println("The ISBN-10 number is " + String.format("%09d", isbn) + checksum);

        keyboardin.close();
    }
}