/**
 * Date: 2021-07-03
 * File Name: SMS.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: SMS class extends from Message class 
 *                    withe other data memeber recipientContactNo
 * 
 * @version 1.0 03 July 2021
 * @auther Zhicheng Wang
 */

public class SMS extends Message
{
    private Contact recipientContactNo;

    // constructors
    public SMS(String newText, Contact newContact)
    {
        super(newText);
        recipientContactNo = newContact;
    }
    public SMS() {}

    // Mutator method
    public void setRecipientContactNo(Contact newContact) {recipientContactNo = newContact;}

    //Accessor method
    public Contact getRecipientContactNo() {return recipientContactNo;}

    // return all the information in the SMS instance
    public String toString() 
    {
        return "The recipient: \n" + recipientContactNo.toStringSMS() + "The message: " + getText() + "\n";  
    }
}
