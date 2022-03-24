/**
 * Date: 2021-06-25
 * File Name: DisplayMessageMain.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;

/**
 * Class Description: The main class of DisplayMessage
 * 
 * @version 1.0 25 June 2021
 * @auther Zhicheng Wang
 */

public class DisplayMessageMain 
{
    public static void main(String[] args) 
    {
        DisplayMessage dm = new DisplayMessage();
        dm.setDisplayMessage("Hello 1DV532!");
        dm.setDisplayCount(3);
        dm.display();
        
        dm.display("Goodbye 1DV532!", 2);
        System.out.println("Current Message: "+ dm.getDisplayMessage());
    }
}
