/**
 * Date: 2021-07-02
 * File Name: Person.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: The superclass/base class Person 
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class Person 
{
    private String name;                // name 
    private String address;             // address
    private String phoneNumber;         // Phone number
    private String emailAddress;        // Email Address

    // the constructor with arguments and 
    public Person(String n, String a, String p, String e)
    {
        name = n; address = a; phoneNumber = p; emailAddress = e;
    }

    // the empty constructor
    public Person() {}

    // Accessor methods for all four data members
    public String getName() {return name;}
    public String getAddress() {return address;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmailAddress() {return emailAddress;}

    // Mutator methods for all four data members
    public void setName(String n) {name = n;}
    public void setAddress(String a) {address = a;}
    public void setPhoneNumber(String p) {phoneNumber = p;}
    public void setEmailAddress(String e) {emailAddress = e;}

    // toString method to return all the information of a Person instance
    public String toString() 
    {
        return "Person:\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress;
    }
}
