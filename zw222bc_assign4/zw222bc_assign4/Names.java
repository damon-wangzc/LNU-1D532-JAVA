/**
 * Date: 2021-07-10
 * File Name: Names.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Class Description: find the information of the input name in both boynames and girlnames files
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class Names 
{
    /**
     * the main function
     * @param args
     */
    public static void main(String[] args) 
    {
        String fileBoyName = "boynames.txt";            // the boy name file
        String fileGirlName = "girlnames.txt";          // the girl name file
        Scanner fileBoyScanner = null;                  // a Scanner instance for boy name
        Scanner fileGirlScanner = null;                 // a Scanner instance for girl name
        Scanner keyboardin = new Scanner(System.in);    // keyboard input
        String[] boyName = new String[1000];            // an array to sore boy names
        String[] girlName = new String[1000];           // an array to store girl names
        int[] boyNameCount = new int[1000];             // an array to store the numbers of registered boy names
        int[] girlNameCount = new int[1000];            // an array to store the numbers of registered girl names
        String inputName = null;                        // the inpurt name
        int boyRank = 0, girlRank = 0;                  // initilize the rank of boy and girl names to 0
        int boyCount = 0, girlCount = 0;                // initlize the numbers of registered boy and girl names to 0

        // find and read the boyname file
        try 
        {
            fileBoyScanner = new Scanner(new FileInputStream(fileBoyName));        
        } catch (FileNotFoundException e_boyFileNotFound) 
        {
            System.out.println("File " + fileBoyName + " was not found.");
            System.exit(0);
        }

        // find and read the girlname file
        try 
        {
            fileGirlScanner = new Scanner(new FileInputStream(fileGirlName));
        } catch (FileNotFoundException e_girlFileNotFound) 
        {
            System.out.println("File " + fileGirlName + " was not found.");
            System.exit(0);
        }

        // read all the information from 2 files and store them into 4 arrays
        for (int i = 0; i < 1000; i++)
        {
            boyName[i] = fileBoyScanner.next();
            boyNameCount[i] = fileBoyScanner.nextInt();
            girlName[i] = fileGirlScanner.next();
            girlNameCount[i] = fileGirlScanner.nextInt();
        }

        // input a name by typing 
        System.out.print("Please enter a name: ");
        inputName = keyboardin.nextLine();
        
        // seach name arrays to find the corresponding name
        for (int i = 0; i < 1000; i++)
        {
            if (boyName[i].equals(inputName))
            {  
                // find name in the boy name array 
                boyRank = i + 1;        // the boyRank will be assigned an index if found, otherwise still be -1
                boyCount = boyNameCount[i];
            }

            if (girlName[i].equals(inputName))
            {
                // find name in the girl name array
                girlRank = i + 1;       //the girlRank will be assigned an index if found, otherwise still be -1
                girlCount = girlNameCount[i];
            }
        }

        // display the results 
        if (girlRank != 0)
            System.out.println(inputName + " is ranked " + girlRank + " in popularity among girls with " + girlCount + " namings.");
        else
            System.out.println(inputName + " is not ranked among the top 1000 girl names.");

        if (boyRank != 0)
            System.out.println(inputName + " is ranked " + boyRank + " in popularity among boys with " + boyCount + " namings.");
        else
            System.out.println(inputName + " is not ranked among the top 1000 boy names.");

        keyboardin.close();
    } 
}
