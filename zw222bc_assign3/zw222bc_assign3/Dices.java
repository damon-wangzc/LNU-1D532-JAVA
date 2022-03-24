/**
 * Date: 2021-06-29
 * File Name: Dices.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;
import java.util.Random;

/**
 * Class Description: the class shows the frequency table (sum, count) for rolling two dices 10000 times 
 * 
 * @version 1.0 29 June 2021
 * @auther Zhicheng Wang
 */

public class Dices {
    public static void main(String[] args) 
    {
        Random diceRoll = new Random();             // Creat a Random object to generate random numbers
        int diceOne;                                // the number of the 1st dice
        int diceTwo;                                // the number of the 2nd dice
        int[] countArray = new int[11];             // the array to store the frequency of the sum (diceOne + diceTwo)

        // generate 10000 pairs of numbers and store the frequency in countArray
        for (int i = 0; i < 10000; i++)
        {
            diceOne = diceRoll.nextInt(6) + 1;      // generate a random integer between [1, 6]
            diceTwo = diceRoll.nextInt(6) + 1;
            countArray[diceOne + diceTwo - 2] ++;   // count the occurrences of possible dice numbers' sum ("- 2" aims to pair the index of the array)
        }
        
        System.out.println("Frequency table (sum, count) for rolling two dices 10000 times is:");

        // display the countArray
        for (int i = 0; i < 11; i++)
        {
            System.out.printf("%-10d%-5d", i + 2, countArray[i]);       // use left-justified ("+ 2" is back to the sum)
            System.out.println();
        }
    }  
}
