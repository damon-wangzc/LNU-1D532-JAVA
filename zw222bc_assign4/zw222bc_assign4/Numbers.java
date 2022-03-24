/**
 * Date: 2021-07-10
 * File Name: Numbers.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Class Description: Read numbers from a file and calculate the average and standard deviation, display and store the results in the file
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class Numbers
{
    /**
     * The method sqrtRootNewton uses Newton's Method to calculate the square root
     * @param num
     * @return x1
     */
    public static double sqrtRootNewton(double num)
    {
        double x0 = num;                // the value before iteration
        double x1 = 0.0;                // the value after iteration
        double precision = 1e-6;        // the precision
        boolean done = false;           // for iteration ending
        double diff;                    // the difference of the value before iteration and after iteration                  

        // iteration
        while (! done)
        {   
            x1 = (x0 * x0 + num) / (2 * x0);        // the Newton's method
            diff = x1 * x1 - num;

            // judge if the value meet the requirement of the precision
            if ((diff > precision) || (diff < - precision))
                x0 = x1;
            else
                done = true;
        }
        
        return x1;
    }

    /**
     * The method sqrtRootBabylonian uses the Babylonian algorithm to calculate square root
     * @param num
     * @return guess
     */
    public static double sqrtRootBabylonian (double num)
    {
        double guess = num / 2.0;       // a guess value of the square root
        double diff = 1;                // initilize the different of guess value and the calculated value
        double current;                 // store the guess value before updating the guess value

        // update the guess value, until the different between the updated value and the stored value is less than 0.001
        while (diff >= 0.001) 
        {
            current = guess;            // assign the guess value to current
            guess = (guess + num / guess) / 2.0;        // the Babylonian algorithm

            // judge if the value meet the requirement of the precision (less than 0.001)
            if ((current - guess) > 0)
                diff = current - guess;
            else
                diff = guess - current;
        }

        return guess;
    }

    /**
     * The method getLine is to get the lines of the text in the file (how many numbers in the file)
     * @param fileName
     * @return line
     */
    public static int getLine(String fileName) 
    {
        int line = 0;
        Scanner inputStream = null;

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

        // read one line each time until there is no more lines of text
        while (inputStream.hasNext())
        {
            inputStream.nextInt();
            line ++;
        }
        
        return line;
    }

    /**
     * the main function
     * @param args
     */
    public static void main(String[] args) 
    {
        /**
         * The first part is to read numbers from file and calculation the average and the standard deviation
         */
        String fileName = "numbers.txt";        // the file name
        Scanner inputStream = null;             // the input stream
        int total = getLine(fileName);          // the total numbers of the numbers in the file
        int[] numArray = new int[total];        // initialize the array to store all the numbers
        int count = 0;                          // use as a index for the "numArray"
        double avg = 0;                         // store average and the intermediate calculation
        double std = 0;                         // store standard deviation and the intermediate calculation

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

        // read each line and store numbers into the "numArray"
        while (inputStream.hasNext())
        {
            int num = inputStream.nextInt();
            numArray[count] = num;
            avg += num;
            count ++;
        }

        avg /= total;                           // get the value of average

        // calculate the sum of squared differences
        for (int i = 0; i < total; i++)
        {
            std += (numArray[i] - avg) * (numArray[i] - avg);
        }
        
        // std = sqrtRootNewton(std);
        std = sqrtRootBabylonian(std);          // get the standard deviation


        /**
         * The second part is to display and store the average and the standard deviation
         */
        PrintWriter pw = null;                  // define a PrintWriter instance
        FileOutputStream outStream;             // file output stream
        String fileOut = "analysis.txt";        // the name of the output file

        // creat the output file and the output stream
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

        // display the results on the screen
        System.out.println("Average: " + avg);
        System.out.println("Standard Deviation: " + std);

        // store the results in the file
        pw.println("Average: " + avg);
        pw.print("Standard Deviation: " + std);

        inputStream.close();
        pw.close();
    }
}