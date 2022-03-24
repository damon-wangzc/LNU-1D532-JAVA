/**
 * Date: 2021-07-03
 * File Name: Contact.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: The Contract class is to store contract's information including name, telephone number and email
 * 
 * @version 1.0 03 July 2021
 * @auther Zhicheng Wang
 */

public class Contact 
{
    private String name;                    // Name
    private String telephonenumber;         // Telephone Number
    private String email;                   // Email
    
    // constructor
    public Contact(String newName, String newTele, String newEmail)
    {
        name = newName;
        telephonenumber = newTele;
        email = newEmail;
    }
    public Contact() {}

    // Accessor methods
    public void setName(String newName) {name = newName;}
    public void setTelephonenumber(String newTele) {telephonenumber = newTele;}
    public void setEmail(String newEmail) {email = newEmail;}

    // Mutator methods
    public String getName() {return name;}
    public String getTelephonenumber() {return telephonenumber;}
    public String getEmail() {return email;}

    // return  all informtion
    public String toString()
    {
        return "Name: " + name + "\nTelephone Number: " + telephonenumber + "\nEmail: " + email; 
    }

    //return information for SMS class
    public String toStringSMS()
    {
        return "Name: " + name + "\nTelephone Number: " + telephonenumber + "\n";
    }

    // return information for Email class
    public String toStringEmail()
    {
        return "Name: " + name + "\nEmail: " + email + "\n";
    }
}
