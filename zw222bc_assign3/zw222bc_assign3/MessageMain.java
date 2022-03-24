/**
 * Date: 2021-07-03
 * File Name: MessageMain.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: The main function is to test the methods of classes "Message", "SMS", "Email"
 * 
 * @version 1.0 03 July 2021
 * @auther Zhicheng Wang
 */

public class MessageMain 
{
    public static void main(String[] args) 
    {
        /* Test Class "Message" */
        Message message = new Message();
        
        System.out.println("This is to test the Message class.");

        message.setText("This is Java!!#@#$%^^&**()");                  // invode "setText" method
        System.out.println();

        System.out.println("The getText() methods: ");
        System.out.println(message.getText());                          // invode "getText" method
        System.out.println();

        System.out.println("The toString() methods: ");
        System.out.println(message.toString());                         // invode "toString" method
        System.out.println();

        System.out.println("The encode() methods: ");
        System.out.println(message.encode());                           // invode "encode" method
        System.out.println();

        System.out.print("========================================");
        System.out.println();

        /* Test Class "SMS" */     
        System.out.println("This is to test the SMS class.");

        SMS sms = new SMS();
        Contact recipient = new Contact();                              // create a Contact instance
        recipient.setName("Damon");                                     // invode the set methods of "Contact"
        recipient.setTelephonenumber("0738998200");
        sms.setRecipientContactNo(recipient);                           // invode the set method from "SMS"
        sms.setText("This is a message for the SMS class. damon@lun.se");   // invode the set method from "Message"         
        System.out.println();

        System.out.println("The getText() methods: ");
        System.out.println(sms.getText());                              // invode "getText" method from "Message"
        System.out.println();

        System.out.println("The getRecipientContactNo() methods: ");
        System.out.println(sms.getRecipientContactNo().toStringSMS());  // invode "getRecipientContactNo" method from "SMS" and "toStringSMS" method from "Contract"
        System.out.println();

        System.out.println("The toString() methods: ");
        System.out.println(sms.toString());                             // invode "toString" method from "SMS"
        System.out.println();

        System.out.println("The encode() methods: ");
        System.out.println(sms.encode());                               // invode "encode" method from "Message"
        System.out.println();

        System.out.print("========================================");
        System.out.println();

        /* Test Class "Email" */     
        System.out.println("This is to test the Email class.");

        Contact sender = new Contact("Lynn", "0738998202", "lynn@lnu.se");
        Contact receiver = new Contact("Lars", "0738998203", "lars@lnu.se");
        String subject = "A Test Email";
        String text = "This is a message for the Email class, containing sender, recevier, subject and message.";
        Email email = new Email(text, sender, receiver, subject);       // use contructor to set all information
        System.out.println();

        System.out.println("The getSender() methods: ");
        System.out.println(email.getSender().toStringEmail());          // invode "getSender" method from "Email" and "toStringEmail" method from "Contact"
        System.out.println();

        System.out.println("The getReceiver() methods: ");
        System.out.println(email.getReceiver().toStringEmail());       // invode "getReceiver" method from "Email" and "toStringEmail" method from "Contact"
        System.out.println();

        System.out.println("The getSubject() methods: ");
        System.out.println(email.getSubject());                        // invode "getSubject" method from "Email"
        System.out.println();

        System.out.println("The getText() methods: ");
        System.out.println(email.getText());                           // invode "getText" method from "Message"
        System.out.println();

        System.out.println("The toString() methods: ");
        System.out.println(email.toString());                          // invode "toString" method from "Email"
        System.out.println();

        System.out.println("The encode() methods: ");
        System.out.println(email.encode());                            // invode "encode" method from "Meaasge"
        System.out.println();
    }    
}
