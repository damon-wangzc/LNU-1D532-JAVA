/**
 * Date: 2021-07-10
 * File Name: BankAccount.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Description: to open a bank account with customer ID, account number, and initial balance 
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class BankAccount 
{
    /**
     * the method to judge if the account number has seven digits
     * @param str
     * @return isSevenDigits
     */
    public static boolean sevenDigits(String str) 
    {
        boolean isSevenDigits = true;           // the return boolean value, initialize with true
        int length = str.length();              // the length of the account number

        if (length != 7)
            // if the length of the account number is not 7, return false
            isSevenDigits = false;
        else
            // check if all the characters are digits
            for (int i = 0; i < length; i++)
            {
                // if one character is not digit, return false
                if ((str.charAt(i) < 48) || (str.charAt(i) > 57))
                    isSevenDigits = false;        
            }

        return isSevenDigits;
    }

    /**
     * the method to judge if the customer ID is correct
     * @param str
     * @return correct
     */
    public static boolean idCorrect(String str) 
    {
        boolean correct = true;                 // the return boolean value
        int length = str.length();              // the length of the customer ID

        if (length != 4)
            // if the length is not correct, return false
            correct = false;
        else
        {
            if (! (((str.charAt(0) >= 65) && (str.charAt(0) <= 90)) || ((str.charAt(0) >= 97) && (str.charAt(0) <= 122))))
                // if the first character is not letter, return false
                correct = false;
            else
            { 
                // if the last 3 characters are not digits, return false   
                for (int i = 1; i < 4; i++)
                {
                    if ((str.charAt(i) < 48) || (str.charAt(i) > 57))
                        correct = false;
                }
            }
        }

        return correct;
    }

    /**
     * the main function
     * @param args
     */
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in);    // a Scanner instance to read from keyboard
        boolean done = false;                           // the index to get valid information for each instance
        String customerID = null;                       // the customer ID
        String accountNo = null;                        // the account number
        int balance = 0;                                // the initial balance

        // the welcome words
        System.out.println("Welcome to the Bank of Students, By the Students, for the Students!");

        // get customer ID
        do
        {
            try
            {
                System.out.print("Enter customer ID: ");
                customerID = keyboardin.nextLine();

                if (! idCorrect(customerID))
                    // throw the exceprion message if the customer ID is not correct
                    throw new Exception("Incorrect Customer ID. The Customer ID must start with a letter followed by three digits.");
                else
                    done = true;
            } catch(Exception e_ID)
            {
                String message = e_ID.getMessage();     // get the the error message
                System.out.println(message);    
                System.out.println("Please input again.");
                System.out.println();
            }
        } while (! done);

        done = false;                                   // re-initialize done to false

        // get the account number
        do
        {
            try
            {
                System.out.print("Enter account no: ");
                accountNo = keyboardin.nextLine();

                if (! sevenDigits(accountNo))
                    // throw the exception mesage if the account number doesn't consist of 7 digits
                    throw new Exception("Incorrect Account No. The Account number must be of seven digits.");
                else
                    done = true;
            } catch(Exception e_Seven)
            {
                String message = e_Seven.getMessage();
                System.out.println(message);    
                System.out.println("Please input again.");
                System.out.println();
            }
        } while (! done);

        done = false;                                   // re-initialize done to false

        // get the balance
        do
        {
            try
            {
                System.out.print("Enter balance: ");
                balance= keyboardin.nextInt();

                if (balance < 1000)
                    // throw the exception mesage if balance is less than 1000
                    throw new Exception("Initial balance must be equal to or higher than 1000.");
                else
                    done = true;
            }
            catch (InputMismatchException e)
            {
                // catch the InputMismatchException if the input is not a number
                System.out.println("Your input is not a number!\nPlease input again.");
                System.out.println();
                keyboardin.nextLine();
            } 
            catch(Exception e_Balance)
            {
                String message = e_Balance.getMessage();
                System.out.println(message);    
                System.out.println("Please input again.");
                System.out.println();
            }
            
        } while (! done);

        // display the results
        System.out.println();
        System.out.println("Congratulations, your account has been created successfully!");
        System.out.println("Your customer ID is " + customerID);
        System.out.println("Your account number is " + accountNo);
        System.out.println("Your balance is " + balance);
        keyboardin.close();
    }    
}
