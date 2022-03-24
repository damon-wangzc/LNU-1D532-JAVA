/**
 * Date: 2021-07-02
 * File Name: Faculty.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;
import java.util.Date;

/**
 * Class Description: The class Faculty is inherited from Employee
 *                    has its own data members, office hours and rank.
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class Faculty extends Employee
{
    private String officeHours;             // office time
    private String rank;                    // rank

    // the constructor with arguments
    public Faculty(String n, String a, String p, String e, int s, Date d, String o, String r)
    {
        super(n, a, p, e, s, d);            // the super constructor from Employee 
        officeHours = o;
        rank = r;
    }
    // the empty constructor
    public Faculty(){}

    // Accessor mthods to return office time and rank
    public String getOfficeHours() {return officeHours;}
    public String getRank() {return rank;}

    // Mutator methods to set office time and rank
    public void setOfficeHours(String o) {officeHours = o;}
    public void setRank(String r) {rank = r;}

    // return all the information of an Faculty instance
    public String toString() 
    {
        String strClass = "Faculty:";
        String strName = "\nName: " + getName();
        String strAddress = "\nAddress: " + getAddress();
        String strPhoneNumber = "\nPhone Number: " + getPhoneNumber();
        String strEmailAddress = "\nEmail Address: " + getEmailAddress();
        String strSalary = "\nSalary: " + getSalary() + " kr/month";
        String strDateHired = "\nDate Hired: " + dateFormat(getDateHired());
        String strOfficeHours = "\nOffice Hours: " + officeHours;
        String strRank = "\nRank: " + rank;
        return strClass + strName + strAddress + strPhoneNumber + strEmailAddress + strSalary + strDateHired + strOfficeHours + strRank;    
    }
}
