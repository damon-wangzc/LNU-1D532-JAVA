/**
 * Date: 2021-06-21
 * File Name: DisplayMessage.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;

/**
 * Class Description: The class is to dispy the specified message with the times of the repetitions
 *                    and also can show the current message (the last specific message)
 * 
 * @version 1.1 25 June 2021
 * @auther Zhicheng Wang
 */

public class DisplayMessage 
{
    private String message;      // To store the input message in the type of String
    private int count;           // The times of display (print)

    public void setDisplayMessage(String s) {message = s;}      // the function to set message
    public void setDisplayCount(int n) {count = n;}             // the function to set the display times

    // the function to dispy message without arguments
    public void display()
    {
        // use for-loop to dispy(print) the specified times of message
        for (int i = 1; i <= count; i++)
            System.out.println(message);
    }

    // the function to dispy message with arguments
    public void display(String s, int n) 
    {
        setDisplayMessage(s);
        setDisplayCount(n);
        display();
    }

    public String getDisplayMessage() {return message;}         // The function to get the message

    // The main function to vertify the functions of DisplayMessage in the same class
    // The separate main file is "DispalyMessageMain.java"
    /*
    public static void main(String[] args) 
    {
        DisplayMessage dm = new DisplayMessage();
        dm.setDisplayMessage("Hello 1DV532!");
        dm.setDisplayCount(3);
        dm.display();
        
        dm.display("Goodbye 1DV532!", 2);
        System.out.println("Current Message: "+ dm.getDisplayMessage());
    }
    */
}