/**
 * Date: 2021-07-10
 * File Name: RandomFaculty.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;
import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/**
 * Class Description: Create 1000 random faculties with first name, last name, rank and salary,  
 *                    store the information in the file and read file to get faculty members 
 *                    who are ranked as “associate” and display first name, last name, 
 *                    and salary of the “associate” ranked faculty member(s) with lowest and highest salaries.
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class RandomFaculty 
{
    /**
     * A method to generate ranks for faculties randomly
     * @return rank
     */
    public static String rankGenerator()
    {
        String rank = null;                 // initialize the rank
        Random rankRandom = new Random();   // create a Random instance

        // generate the rank randomly by generating a random integer among 0, 1, 2
        switch (rankRandom.nextInt(3)) 
        {
            case 0:
                rank = "assistant";
                break;
            case 1:
                rank = "associate";
                break;
            case 2:
                rank = "full";    
                break;
            default:
                break;
        }
        return rank;
    }

    /**
     * A method to generate salaries randomly accordint the ranks
     * @param rank
     * @return salary
     */
    public static String salaryGenerator(String rank) 
    {
        double salary = 0;                  // initialize the salary
        Random salaryRandom = new Random(); // create a Random instance

        // generate a random salary acooding to the ranks
        switch (rank)
        {
            case "assistant":               // The salary for an assistant professor is from 50,000 to 80,000
                salary = 50000 + 30000 * salaryRandom.nextDouble();
                break;
            case "associate":               // The salary for an associate professor is from 60,000 to 110,000
                salary = 60000 + 50000 * salaryRandom.nextDouble();
                break;
            case "full":                    // The salary for a full professor is from 75,000 to 130,000
                salary = 75000 + 55000 * salaryRandom.nextDouble();
                break;
            default:
                break;
        } 

        return String.format("%.2f", salary); // with two digits after the decimal point
    }

    /**
     * the main function
     * @param args
     */
    public static void main(String[] args) 
    {
        /**
         * The first part to generate faculties randomly and write to a file
         */
        PrintWriter pw = null;             // create a PrintWrite instance with null
        FileOutputStream outStream = null; // create a FileOutputStream instance with null
        String fileOut = "faculty.txt";    // the output file name
        String rankName = null;            // initialize the rank with null 
        String salary = null;              // initialize the salary as null

        // creat the output file
        try
        {
            outStream = new FileOutputStream(fileOut);
            pw = new PrintWriter(outStream);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File " + fileOut + " was not found.");
            System.exit(0);
        }

        // create and write 1000 faculties information into the file
        for (int i = 1; i <= 1000; i++)
        {
            rankName = rankGenerator();
            salary = salaryGenerator(rankName);
            pw.println("FirstName" + i + " LastName" + i + " " + rankName + " " + salary);
        } 

        pw.close();                        // close the output stream
        
        /**
         * The second part read information from the file and get the information of associate professors who with the lowest and highest salaries
         */
        String fileName = "faculty.txt";   // the file name to be read
        Scanner inputStream = null;        // create a Scanner instance 
        double maxSalary = 50000;          // intialize the max salary to 50000, the possible lowest
        double minSalary = 130000;         // initialize the min salary to 130000, the possible highest
        double readSalary;                 // the salary read from the file
        String readRank;                   // the rank read from the file
        String firstName, maxFirstName = null, minFirstName = null; // the read first name, the first names who has the higest salary and lowest salary
        String lastName, maxLastName = null, minLastName = null;    // the read last name, the last names who has the higest salary and lowest salary

        // read the file
        try
        {
            inputStream = new Scanner(new FileInputStream(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File " + fileName + " was not found.");
            System.exit(0);
        }

        // read the information line by line and get the information of associate professors the who has the higest salary and lowest salary
        for (int i = 0; i < 1000; i++)
        {
            firstName = inputStream.next();
            lastName = inputStream.next();
            readRank = inputStream.next();
            readSalary = inputStream.nextDouble();

            if ((readRank.equals("associate")) && (readSalary > maxSalary))
            {  
                // find an associate professor who has a higher salary than the previous one  
                maxSalary = readSalary;
                maxFirstName = firstName;
                maxLastName = lastName;
            }
            
            if ((readRank.equals("associate")) && (readSalary < minSalary))    
            {    
                // find an associate professor who has a lower salary than the previous one 
                minSalary = readSalary;
                minFirstName = firstName;
                minLastName = lastName;
            }           
        }

        // display the results
        System.out.println("The faculty members who are ranked as “associate” : ");
        System.out.println(minFirstName + " " + minLastName + " has the lowest salary: " + minSalary);
        System.out.println(maxFirstName + " " + maxLastName + " has the higest salary: " + maxSalary);   
    }    
}
