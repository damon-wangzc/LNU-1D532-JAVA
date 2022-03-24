/**
 * BMI.java
 * Author: Zhicheng Wang
 * Student ID: zw222bc
 */

package zw222bc_assign1;
import java.util.Scanner;
import java.util.Locale;

/**
 * A program to calculate BMI when inputing the weight in pounds
 * and the height in inches
 */

public class BMI {
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);                    // use Scanner to read input
        keyboardin.useLocale(Locale.ENGLISH);                           // use "." in the input
        Double weight, height, bmi;
        System.out.print("Enter weight in pounds: ");
        weight = keyboardin.nextDouble();
        System.out.print("Enter height in inches: ");
        height = keyboardin.nextDouble();
        bmi = 0.45359237 * weight / (height * height * 0.0254 * 0.0254);
        System.out.println("BMI is " + String.format("%.4f", bmi));
        keyboardin.close();
    }
}