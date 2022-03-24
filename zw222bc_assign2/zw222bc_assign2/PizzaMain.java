/**
 * Date: 2021-06-22
 * File Name: PizzaMain.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Description: the main function to execute a pizza ordering
 * 
 * @version 1.1 25 June 2021
 * @auther Zhicheng Wang
 */

public class PizzaMain
{
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);        // input stream
        Date dateNow = new Date();                          // create a data for the order information
        String size;                                        // the size of pizza
        String topping;                                     // the type of topping
        int toppingNum;                                     // the number of the topping
        Pizza pizza = new Pizza();                          // create a new pizza variable 

        System.out.println(dateNow + "\n");                 // print the date
        System.out.println("Welcome to the Café LNU!\n");   // print the welcome information
    
        // set the pizza size
        System.out.print("Please enter size of your pizza [small, medium, or large]: ");    
        int index = 0;                                      // initialize index to 0
        
        // judge if the typing is correct
        do
        {
            // jump over the if statement if index = 0 (the first time)
            if (index != 0)
            {   
                System.out.println("You typed the wrong size. Please type again.");
                System.out.print("Please enter size of your pizza [small, medium, or large]: ");
            }
            size = keyboardin.nextLine().toLowerCase();
            index += 1;
        }
        while (! (size.equals("small") || size.equals("medium") || size.equals("large")));
        pizza.setPizzaSize(size);          // set the size of pizza to the variable "pizza"

        // set the type of topping
        System.out.print("Please enter type of topping [cheese, pepperoni, ham]: ");       
        index = 0;                         // initialize index to 0
        
        // judge if the typing is correct
        do
        {
            // jump over the if statement if index = 0 (the first time)
            if (index != 0)
            {   
                System.out.println("You typed the wrong topping. Please type again.");
                System.out.print("Please enter type of topping [cheese, pepperoni, ham]: ");
            }
            topping = keyboardin.nextLine().toLowerCase();
            index += 1;
        }
        while (! (topping.equals("cheese") || topping.equals("pepperoni") || topping.equals("ham")));

        // enter the number of topping
        System.out.print("Please enter number of toppings you want: ");  

        // judge if the input is a positive integer
        do
        {
            // catch the error if the input is not an integer
            try
            {
                toppingNum = keyboardin.nextInt();

                if (toppingNum < 0)
                {
                    System.out.println();
                    System.out.println("The topping number can't be a negative integer. Please enter again!");
                    System.out.print("Please enter number of toppings you want: ");
                    keyboardin.nextLine(); 
                }
                else
                {
                    // using different set functions according to the value of "topping"
                    if (topping.equals("chesse"))
                        pizza.setCheeseNum(toppingNum);
                    else if (topping.equals("pepperoni"))
                        pizza.setPepperoniNum(toppingNum);
                    else
                        pizza.setHamNum(toppingNum); 
                    index = 0;
                }
            } catch (InputMismatchException e)
            {
                System.out.println();
                System.out.println("You enters a non-integer value. Please enter again!");
                System.out.print("Please enter number of toppings you want: ");
                keyboardin.nextLine(); 
            }
        } while (index != 0);

        System.out.println();                               // print a blank line
        System.out.println(pizza.getDescription());         // print the order information

        keyboardin.close();
    }
    
}
