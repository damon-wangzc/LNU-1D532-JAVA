/**
 * Date: 2021-06-29
 * File Name: CardsMatch.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class Description: a card match game to find two card (represented by *) with the same number 
 * 
 * @version 1.1 02 July 2021
 * @auther Zhicheng Wang
 */

public class CardsMatch 
{
    // This is a card shuffle function to return a 2-dim array 
    // total 16 instances, each with the first value as numbers
    // the second value as status, 0 (face down, initial value) and 1 (face up)
    public static int[][] cardShuffle() 
    {
        int[][] cards = new int[16][2];                 // store 16 cards with flip status (first value as numbers, the second as status 0 or 1)
        int indexOne;                                   // the index where store one of the duplicate numbers
        int indexTwo;                                   // the index where store the other of the duplicate numbers
        Random cardGenerator = new Random();            // a Random generator

        // to assign 8 different numbers in turn to an unique index in the 2-dim array
        for (int i = 0; i < 8; i++)
        {
            // check if two random generated indexs are the same or they have been filled
            do
            {
                indexOne = cardGenerator.nextInt(16);
                indexTwo = cardGenerator.nextInt(16);                
            }
            while ((indexOne == indexTwo) || (cards[indexOne][0] != 0) || (cards[indexTwo][0] != 0));
            cards[indexOne][0] = i + 1;
            cards[indexTwo][0] = i + 1;
        }

        return cards;
    }

    // the function to display the card status, face up or down
    // display the card by 4 x 4
    public static void displayCards(int[][] cards) 
    {
        System.out.printf("%11s", "1 2 3 4");
        System.out.println();
        System.out.printf("%12s", "=========");
        System.out.println();

        // display the card by 4 x 4, if status value is 0, use *, or show the numbers
        for (int i = 0; i < 16; i++)
        {
            if ((i + 1) % 4 == 1)
                System.out.print(((i / 4) + 1) + " | ");

            if (cards[i][1] == 0)
                System.out.print("* ");
            else
                System.out.print(cards[i][0] + " ");

            if ((i + 1) % 4 == 0)
                System.out.println("|");
        }
        System.out.printf("%13s", "=========\n");
    }

    // the function to generate x and y axis values (1, 2, 3, 4)
    public static int valueGenerate() 
    {
        Scanner keyboardin = new Scanner(System.in);
        Boolean done = false;                       // the index to show the entered value is acceptiable
        int value = 0;                              // the returned value

        // check if enter an integer out of range [1, 4] or a wrong type
        do
        {
            try
            {
                value = keyboardin.nextInt();

                if (value > 4 || value < 1)
                    System.out.println("Please enter integers (1, 2, 3, 4)");
                else 
                    done = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter integers (1, 2, 3, 4)");
                keyboardin.nextLine();
            }
        } while (! done);

        return value;    
    }

    // the function to press enter to continue and print 50 space line to clean the current display
    public static void enterCom() 
    {
        Scanner keyboardin = new Scanner(System.in);
        System.out.println("Hit enter to continue."); 
        keyboardin.nextLine(); 
        
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

    // The function to check if the entered position is already flipped
    public static boolean checkFlip(int[][] cards, int value) 
    {
        boolean correctFlip = false;                // the returned value

        // check the status value
        if (cards[value][1] == 0)
            correctFlip = true;
        else
            System.out.println("The card has been flipped. Please enter again.");
        
        return correctFlip;
    }

    // the function to flip cards
    public static void flipCards(int[][] cards) 
    {
        int one;                                   // the firt calculate index of the entered x and y
        int oneX, oneY;                            // the first entered position by axis x and y
        int two;                                   // the second calculate index of the entered x and y
        int twoX, twoY;                            // the second entered position by axis x and y
       
        // check if the first entered position has been flipped by "checkFlip" function
        do
        {
            System.out.println("Enter an x and y position of the first card to flip.");
            oneX = valueGenerate();
            oneY = valueGenerate();
            one = (oneX - 1) * 4 + (oneY - 1);     // the firt calculate index 
        } while (! checkFlip(cards, one));
        cards[one][1] = 1;                         // change the status

        // check if the second entered position has been flipped by "checkFlip" function
        do
        {
            System.out.println("Enter an x and y position of the second to flip.");
            twoX = valueGenerate();
            twoY = valueGenerate();
            two = (twoX - 1) * 4 + (twoY -1);      // the second calculate index 
        } while (! checkFlip(cards, two));
        cards[two][1] = 1;                         // change the status

        // check if two flipped cards match or not
        if (cards[one][0] == cards[two][0])
        {
            // if match, dispay the cards (keep the flipped cards face up)
            System.out.println("Match found!");
            displayCards(cards);           
        }
        else
        {
            // if not match, face down the flipped cards and clear the current display
            // and display the previous dispay without flipping the last two cards
            displayCards(cards);
            cards[one][1] = 0;
            cards[two][1] = 0;
            enterCom();
            displayCards(cards);
        }
    }

    // check if all the cards face up
    public static boolean checkComplete(int[][] cards) 
    {
        boolean done = false;

        int count = 0;

        // count the status values
        for (int i = 0; i < 16; i++)
        {
            if (cards[i][1] == 1)
                count ++;
        }

        if (count == 16)
            done = true;

        return done;    
    }

    // The main function to run the game
    public static void main(String[] args) 
    {
        int[][] cards = new int[16][2];          // create the card array
        System.out.println("Find all the matching pairs on the board.");
        cards = cardShuffle();                   // shuffle cards
        displayCards(cards);                     // display the face down cards

        // flip cards until completing the game
        do
        {
            flipCards(cards);
        }
        while (! checkComplete(cards));

        System.out.println("Congratulation, you found all the matching pairs! Game over.");
    }  
}