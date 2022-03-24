/**
 * Date: 2021-07-02
 * File Name: PersonMain.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign3;
import java.util.Date;

/**
 * Class Description: This the main function to test all the classes
 * 
 * @version 1.0 02 July 2021
 * @auther Zhicheng Wang
 */

public class PersonMain 
{
    public static void main(String[] args) 
    {
        // Test Class Person (Assuming all input formats are correct)
        Person person01 = new Person("Emil", "Professorsslingan 1", "0738998201", "emil@lnu.se");
        System.out.println(person01.toString());

        System.out.println();

        Person person02 = new Person();
        person02.setName("Eva");
        person02.setAddress("Professorsslingan 2");
        person02.setPhoneNumber("0738998202");
        person02.setEmailAddress("eva@lun.se");
        System.out.println(person02.toString());

        System.out.println();

        // Test Class Employee (Assuming all input formats are correct, use current date)
        Employee employee01 = new Employee("Leo", "Professorsslingan 3", "0738998203", "Leo@lnu.se", 40000, new Date());
        System.out.println(employee01.toString());

        System.out.println();

        Employee employee02 = new Employee();
        employee02.setName("Lily");
        employee02.setAddress("Professorsslingan 4");
        employee02.setPhoneNumber("0738998204");
        employee02.setEmailAddress("lily@lun.se");
        employee02.setSalary(45000);
        employee02.setDateHired(2021, 7, 1); // Set the date
        System.out.println(employee02.toString());

        System.out.println();

        // Test Class Student (Assuming all input formats are correct)
        Student student01 = new Student("Lars", "Professorsslingan 5", "0738998205", "lars@lnu.se", "freshman");
        System.out.println(student01.toString());

        System.out.println();

        Student student02 = new Student();
        student02.setName("Lucas");
        student02.setAddress("Professorsslingan 6");
        student02.setPhoneNumber("0738998206");
        student02.setEmailAddress("lucas@lun.se");
        student02.setClassStatus("Senior");
        System.out.println(student02.toString());

        System.out.println();

        // Test class Faculty (Assuming all input formats are correct, use current date)
        Faculty faculty01 = new Faculty("Lynn", "Professorsslingan 7", "0738998207", "Lynn@lnu.se", 60000, new Date(), "Mon-Fri: 09-17", "Professor");
        System.out.println(faculty01.toString());

        System.out.println();

        Faculty faculty02 = new Faculty();
        faculty02.setName("Karl");
        faculty02.setAddress("Professorsslingan 8");
        faculty02.setPhoneNumber("0738998208");
        faculty02.setEmailAddress("karl@lun.se");
        faculty02.setSalary(55000);
        faculty02.setDateHired(2021, 6, 25);    // set the date
        faculty02.setOfficeHours("Mon-Fri: 08-16");
        faculty02.setRank("Senior Lecturer");
        System.out.println(faculty02.toString());

        System.out.println();

        // Test class Faculty (Assuming all input formats are correct, use current date)

        Staff staff01 = new Staff("Jack", "Professorsslingan 9", "0738998209", "jack@lnu.se", 52000, new Date(), "Director");
        System.out.println(staff01.toString());

        System.out.println();

        Staff staff02 = new Staff();
        staff02.setName("Carolina");
        staff02.setAddress("Professorsslingan 10");
        staff02.setPhoneNumber("0738998210");
        staff02.setEmailAddress("carolina@lun.se");
        staff02.setSalary(60000);
        staff02.setDateHired(2020, 12, 12); //set the date
        staff02.setTitle("Vice President");
        System.out.println(staff02.toString());
    }    
}
