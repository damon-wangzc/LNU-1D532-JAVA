/**
 * Date: 2021-06-22
 * File Name: Pizza.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;
import java.util.Scanner;

/**
 * Class Description: the class is to create Pizza class with basic set and get functions
 *                    , the price calculation function and information print functions
 * 
 * @version 1.0 22 June 2021
 * @auther Zhicheng Wang
 */

public class Pizza 
{
    // four private instance variables
    private String pizzaSize;           // size of a pizza (either small, medium, or large)
    private int cheeseNum;              // number of cheese toppings
    private int pepperoniNum;           // number of pepperoni toppings
    private int hamNum;                 // number of ham toppings

    // the function to set the size of a pizza
    public void setPizzaSize(String size) {pizzaSize = size.toLowerCase();}

    // the function to set the number of cheese toppings
    public void setCheeseNum(int n) {cheeseNum = n;}

    // the function to set the number of pepperoni toppings
    public void setPepperoniNum(int n) {pepperoniNum = n;}

    // the function to set the number of ham toppings
    public void setHamNum(int n) {hamNum = n;}

    // the function to get the size of a pizza
    public String getPizzaSize() {return pizzaSize;}

    // the function to get the number of cheese toppings
    public int getCheeseNum() {return cheeseNum;}

    // the function to get the number of pepperoni toppings
    public int getPepperoniNum() {return pepperoniNum;}

    // the function to get the number of ham toppings
    public int getHamNum() {return hamNum;}

    // the function to calculate the price of the ordered pizza
    public double calcCost() 
    {
        double price = 0;               // the price of the pizza

        // use swith-statement to calculate the price with different size
        switch (getPizzaSize())
        {
            case "small":
                price = 10 + 3 * (getCheeseNum() + getPepperoniNum() + getHamNum());
            case "medium":
                price = 15 + 2.5 * (getCheeseNum() + getPepperoniNum() + getHamNum());
            case "large":
                price = 20 + 2 * (getCheeseNum() + getPepperoniNum() + getHamNum());
        }

        return price;  
    }

    // the function to generate the order information (including the pizza information and price)
    public String getDescription()
    {
        String topping;                 // the type of topping
        int num = (getCheeseNum() + getPepperoniNum() + getHamNum());   // the number of toppings

        // judge which topping is using the number of toppings
        if (getCheeseNum() > 0)
            topping = "Chesse";
        else if (getPepperoniNum() > 0)
            topping = "Pepperoni";
        else  
            topping = "Ham";

        return ("Thank you!\n" + "“You ordered a " + getPizzaSize() + 
                " pizza with " + num + " " + topping + " toppings." + 
                "Your bill is " + calcCost() + " kr.”\n" + "Enjoy your meal!"); // the order information
    }

    
}
