/**
 * Date: 2021-07-02
 * File Name: Staff.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;
import java.util.Date;

/**
 * Class Description: The class Staff is inherited from Employee
 *                    has its own data member, title.
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class Staff extends Employee
{
    private String title;               // title

    // the constructor with arguments
    public Staff(String n, String a, String p, String e, int s, Date d, String t)
    {
        super(n, a, p, e, s, d);        // the super constructor from Employee
        title = t;
    }

    // the empty constructor
    public Staff() {}

    // Accessor mthods to return title
    public String getTitle() {return title;}

    // Mutator methods to set office time and rank
    public void setTitle(String t) {title = t;}

    // return all the information of an Staff instance
    public String toString() 
    {
        String strClass = "Staff:";
        String strName = "\nName: " + getName();
        String strAddress = "\nAddress: " + getAddress();
        String strPhoneNumber = "\nPhone Number: " + getPhoneNumber();
        String strEmailAddress = "\nEmail Address: " + getEmailAddress();
        String strSalary = "\nSalary: " + getSalary() + " kr/month";
        String strDateHired = "\nDate Hired: " + dateFormat(getDateHired());
        String strTitle = "\nTitle: " + title;
        return strClass + strName + strAddress + strPhoneNumber + strEmailAddress + strSalary + strDateHired + strTitle;    
    }
}
