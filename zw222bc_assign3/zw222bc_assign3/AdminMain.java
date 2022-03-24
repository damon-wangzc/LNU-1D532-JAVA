/**
 * Date: 2021-07-02
 * File Name: AdminMain.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;

/**
 * Class Description: The class is to test different methods in Admin Class
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class AdminMain 
{
    public static void main(String[] args) 
    {
        // using accessor methods
        System.out.println("This is the result using accessor methods\nThe 1st administrator is:");
        System.out.println();
        Admin admin01 = new Admin();
        admin01.setName("Damon");
        admin01.setHireDate(new Date(7, 2, 2021));
        admin01.setSalary(50000);
        admin01.setTitle("Director");
        admin01.setAdminArea("Production");
        admin01.setSuperiorName("Lucy");;
        System.out.println(admin01.toString());
        System.out.println();

        // using the constuctor to get all the information from admin01
        System.out.println("This is the result using the constuctor using argument\nThe 2nd administrator is:");
        System.out.println();
        Admin admin02 = new Admin(admin01);
        System.out.println(admin02.toString());
        System.out.println();
        if (admin02.equals(admin01))
            System.out.println("The 1st administrator and the 2nd administrator are the same employee.");
        else
            System.out.println("The 1st administrator and the 2nd administrator are different employees.");
        
        System.out.println();

        // using readData methods
        System.out.println("This is the result using readData methods\nThe 3rd administrator is:");
        System.out.println();
        Admin admin03 = new Admin();
        admin03.readData("Lars", new Date(7, 1, 2021), 80000, "Vice President", "Board of Directors", "Jobs");
        System.out.println(admin03.toString());
        System.out.println();
        if (admin03.equals(admin01))
            System.out.println("The 1st administrator and the 3rd administrator are the same employee.");
        else
            System.out.println("The 1st administrator and the 3rd administrator are different employees.");
    }    
}
