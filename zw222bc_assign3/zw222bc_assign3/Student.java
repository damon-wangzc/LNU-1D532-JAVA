/**
 * Date: 2021-07-02
 * File Name: Student.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: The class Student is inherited from Person
 *                    has its own data member, class status.
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class Student extends Person
{
    private String classStatus;             // class status (freshman, sophomore, junior, or senior)
    
    // the constructor with arguments
    public Student(String n, String a, String p, String e, String c)
    {
        super(n, a, p, e);
        classStatus = c;
    }

    // the empty constructor
    public Student() {}

    // Accessor mthod to return class status
    public String getClassStatus() {return classStatus;}

    // Mutator method to set class status
    public void setClassStatus(String c) {classStatus = c;}
 
    // return all the information of an Student instance
    public String toString() 
    {
        String strClass = "Student:";
        String strName = "\nName: " + getName();
        String strAddress = "\nAddress: " + getAddress();
        String strPhoneNumber = "\nPhone Number: " + getPhoneNumber();
        String strEmailAddress = "\nEmail Address: " + getEmailAddress();
        String strClassStatus = "\nClass Status: " + classStatus;
        return strClass + strName + strAddress + strPhoneNumber + strEmailAddress + strClassStatus;    
    }
}
