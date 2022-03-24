/**
 * Date: 2021-07-02
 * File Name: Employee.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * Class Description: The class Employee is inherited from Person
 *                    has its own data members, salary and date hired.
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class Employee extends Person
{
    private int salary;                 // Salary
    private Date dateHired;             // Date hired
    
    // the constructor with arguments
    public Employee(String n, String a, String p, String e, int s, Date d)
    {
        super(n, a, p, e);              // the super constructor from the base class 
        salary = s;
        dateHired = d;
    }

    // the empty constructor
    public Employee(){}


    // Accessor mthods to return two specific data members of Employee
    public int getSalary() {return salary;}
    public Date getDateHired() {return dateHired;}

    // Mutator method to set salary
    public void setSalary(int s) {salary = s;}

    // Mutator method to use Calendar and GregorianCalendar to set the date (the Date type removes the constructor)
    public void setDateHired(int year, int month, int day)
    {
        Calendar dateSet = new GregorianCalendar(year, month - 1, day);
        dateHired = dateSet.getTime();
    }

    // the method to get the String format of the date
    public String dateFormat(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
    
    // return all the information of an Employee instance
    public String toString() 
    {
        String strClass = "Employee:";
        String strName = "\nName: " + getName();
        String strAddress = "\nAddress: " + getAddress();
        String strPhoneNumber = "\nPhone Number: " + getPhoneNumber();
        String strEmailAddress = "\nEmail Address: " + getEmailAddress();
        String strSalary = "\nSalary: " + salary + " kr/month";
        String strDateHired = "\nDate Hired: " + dateFormat(dateHired);
        return strClass + strName + strAddress + strPhoneNumber + strEmailAddress + strSalary + strDateHired;    
    }
}
