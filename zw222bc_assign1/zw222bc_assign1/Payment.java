/**
 * Payment.java
 * Author: Zhicheng Wang
 * Student ID: zw222bc
 */

package zw222bc_assign1;

import java.util.Scanner;
import java.lang.Math;
import java.util.Locale;

/**
 * A program to calculate the change with a price and a payment
 */

public class Payment {
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);
        keyboardin.useLocale(Locale.ENGLISH);

        Double price, payment;
        long change, quotient;
        int [] bills = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};    // use an array to sore the bills and coins

        System.out.print("Price: ");
        price = keyboardin.nextDouble();
        System.out.print("Payment: ");
        payment = keyboardin.nextDouble();
        change = Math.round(payment - price);
        System.out.println();
        System.out.println("Change: " + change + " kronor");

        for (int i: bills)
        {
            quotient = change / i;
            if (i > 10)
                System.out.println(String.format("%4d", i) + "kr bills: " + quotient);  // use String.format to align output
            else
                System.out.println(String.format("%4d", i) + "kr coins: " + quotient);
            change -= quotient * i;
        }
       
        keyboardin.close();    
    }
}