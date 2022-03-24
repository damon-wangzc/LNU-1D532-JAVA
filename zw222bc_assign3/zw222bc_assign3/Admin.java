/**
 * Date: 2021-07-02
 * File Name: Admin.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: The class Employee is inherited from SalariedEmployee
 *                    has its own data members, title, admin area and superior name.
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class Admin extends SalariedEmployee
{
    private String title;               // title: the administrator’s title (such as "Director" or "Vice President")
    private String adminArea;           // admin area: the administrator’s area of responsibility (such as "Production", "Accounting", or "Personnel")
    private String superiorName;        // Superior Name: the name of this administrator’s immediate supervisor or manager

    // the empty constructor ()
    public Admin()
    {
        super();
        title = "Director";
        adminArea = "Production";
        superiorName = "Damon";
    }

    // the constructor with arguments
    /**
     Precondition: Neither theName nor theDate are null, theSalary is nonnegative; 
     theTitle, theAdminArea, theSuperiorName can't be null
    */
    public Admin(String theName, Date theDate, double theSalary, String theTitle, String theAdminArea, String theSuperiorName)
    {
        super(theName, theDate, theSalary);         // the super constructor from SalariedEmployee

        if (theTitle == null || theAdminArea == null || theSuperiorName == null)
            System.out.println("Fatal Error creating admin.");
            System.exit(0);
        
        title = theTitle;
        adminArea = theAdminArea;
        superiorName = theSuperiorName;
    }

    public Admin(Admin originalObject )
    {
        super(originalObject);
        title = originalObject.title;
        adminArea = originalObject.adminArea;
        superiorName = originalObject.superiorName;
    }

    // Three acessor mthods
    public String getTitle()
    {
        return title;
    }

    public String getAdminArea()
    {
        return adminArea;
    }

    public String getSuperiorName()
    {
        return superiorName;
    }

    // Three mutator methods
    public void setTitle(String newTitle)
    {
        if (newTitle == null)
        {
            System.out.println("Fatal Error setting admin title.");
            System.exit(0);
        }
       else
            title = newTitle;
    }

    public void setAdminArea(String newAdminArea) 
    {
        if (newAdminArea == null)
        {
            System.out.println("Fatal Error setting admin area.");
            System.exit(0);
        }
       else
            adminArea = newAdminArea;  
    }

    public void setSuperiorName(String newSuperiorName) 
    {
        if (newSuperiorName == null)
        {
            System.out.println("Fatal Error setting the superior name of admin.");
            System.exit(0);
        }
       else
            superiorName = newSuperiorName;  
    }

    // prompts user to enter data for all data members of the Admin class
    public void readData(String theName, Date theDate, double theSalary, String theTitle, String theAdminArea, String theSuperiorName) 
    {
        this.setName(theName);
        this.setHireDate(theDate);
        this.setSalary(theSalary);
        setTitle(theTitle);
        setAdminArea(theAdminArea);
        setSuperiorName(theSuperiorName);
    }

    // return the information of admin
    public String toString( )
    {
        return (getName() + " " + getHireDate().toString() 
                                + "\n$" + getSalary() + " per year"
                                + "\nThe title: " + title
                                + "\nThe area of responsibility: " + adminArea
                                + "\nThe name of this immediate supervisor: " + superiorName);
    }

    public boolean equals(Admin other)
    {
        return (getName().equals(other.getName()) 
                && getHireDate().equals(other.getHireDate())
                && getSalary() == other.getSalary()
                && title.equals(other.title)
                && adminArea.equals(other.adminArea)
                && superiorName.equals(other.superiorName));
    }
}