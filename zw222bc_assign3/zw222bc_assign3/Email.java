/**
 * Date: 2021-07-03
 * File Name: Email.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: Email class extends from Message class 
 *                    withe other data memebers sender, receiver, and subject
 * 
 * @version 1.0 03 July 2021
 * @auther Zhicheng Wang
 */

public class Email extends Message
{
    private Contact sender;
    private Contact receiver;
    private String subject;

    // constuctors
    public Email(String newText, Contact newSender, Contact newReceiver, String newSubject)
    {
        super(newText);
        sender = newSender;
        receiver = newReceiver;
        subject = newSubject;
    }
    public Email() {}

    // Mutator methods
    public void setSender(Contact newSender) {sender = newSender;}
    public void setReceiver(Contact newReceiver) {receiver = newReceiver;}
    public void setSubject(String newSubject) {subject = newSubject;}

    // Accessor methods
    public Contact getSender() {return sender;}
    public Contact getReceiver() {return receiver;}
    public String getSubject() {return subject;}

    // return all the information in the SMS instance
    public String toString()
    {
        return "Sender: " + sender.toStringEmail() + "Receiver: " + receiver.toStringEmail() + "Subject: " + subject + "\nThe message: " + getText();
    }


}
