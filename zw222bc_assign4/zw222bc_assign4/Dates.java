/**
 * Date: 2021-07-10
 * File Name: Dates.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;
import java.util.Scanner;

/**
 * Class Description: to convert the date format from mm/dd/yyyy to Month Day, Year, like July 10, 2021
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class Dates 
{
    /**
     * The method to convert the data format
     * @param inputDate
     * @return dateOutput
     */
    public static String dateDisplay (String inputDate)
    {
        String dateOutput = null;           // the output date
        String monthStr = null;             // month using complete representation, like "July"
        int month;                          // month using digits
        int day;                            // day using digits
        int year;                           // year using digits

        // get the digital form of month, day and year from the inputDate
        month = (inputDate.charAt(0) - 48) * 10 + (inputDate.charAt(1) - 48);
        day = (inputDate.charAt(3) - 48) * 10 + (inputDate.charAt(4) - 48);
        year = (inputDate.charAt(6) - 48) * 1000 + (inputDate.charAt(7) - 48) * 100 + (inputDate.charAt(8) - 48) * 10 + (inputDate.charAt(9) - 48);

        // replace the digitial month to String complete representation
        switch (month)
        {
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            case 12:
                monthStr = "December";
                break;
            default:
                break;
        }

        dateOutput = monthStr + " " + day + ", " + year; // output formate
        
        return dateOutput;
    }

    /**
     * The method to check the formate of the input date if it is a mm/dd/yyyy
     * @param inputDate
     * @return formatCorrect
     */
    public static boolean checkFormat(String inputDate) 
    {
        boolean formatCorrect = true;               // the return boolean value 

        if (inputDate.length() != 10)
            // if the length is not 10, return false
            formatCorrect = false;
        else
        {
            // check digits and delimiter "/"
            for (int i = 0; i < 10; i++)
            {
                if (i == 2 || i == 5)
                {
                    // if the indexs of 2 and 5 are not "/", return false
                    if (inputDate.charAt(i) != '/')
                    {    
                        formatCorrect = false;
                        break;
                    }
                }
                else 
                {
                    // if one character is not a digit, return false
                    if (inputDate.charAt(i) < 48 || inputDate.charAt(i) > 57)
                    {    
                        formatCorrect = false;
                        break;
                    }
                }           
            }
        }
  
        return formatCorrect;
    }

    /**
     * The method to check month
     * @param inputDate
     * @return monthCorrect
     */
    public static boolean checkMonth(String inputDate) 
    {
        boolean monthCorrect = true;                // the return boolean value
        int month;                                  // the digital form of month

        // get the month
        month = (inputDate.charAt(0) - 48) * 10 + (inputDate.charAt(1) - 48);

        // if month is not between 1 and 12, return false
        if (month < 1 || month > 12)
            monthCorrect = false;
        
        return monthCorrect;
    }

    /**
     * The method to check day
     * @param inputDate
     * @return
     */
    public static boolean checkDay(String inputDate) 
    {
        boolean dayCorrect = true;                  // the return boolean value
        int month, day, year;                       // the digital form of month, day and year

        // get month, day and year
        month = (inputDate.charAt(0) - 48) * 10 + (inputDate.charAt(1) - 48);
        day = (inputDate.charAt(3) - 48) * 10 + (inputDate.charAt(4) - 48);
        year = (inputDate.charAt(6) - 48) * 1000 + (inputDate.charAt(7) - 48) * 100 + (inputDate.charAt(8) - 48) * 10 + (inputDate.charAt(9) - 48);


        if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) && ((day > 31) || (day < 1)))
            // if the month with 31 days got a non-positive number or larger than 31, return false
            dayCorrect = false;
        else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) && ((day > 30) || (day < 1)))
            // if the month with 30 days got a non-positive number or larger than 30, return false
            dayCorrect = false;
        else if ((month == 2) && ((year % 4 != 0) || ((year % 100 == 0) && (year % 400 != 0))) && ((day > 28) || (day < 1)))
            // if it's February but not a leap year, getting a non-positive number or larger than 28, return false
            dayCorrect = false;
        else if ((month == 2) && (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) && ((day > 29) || (day < 1)))
            // if it's February and a leap year, getting a non-positive number or larger than 29, return false
            dayCorrect = false;
        
        return dayCorrect;
    }

    /**
     * the method to check the year
     * @param inputDate
     * @return yearCorrect
     */
    public static boolean checkYear(String inputDate) 
    {
        boolean yearCorrect = true;                 // the return boolean value
        int year;                                   // the digitial form year

        // get the year
        year = (inputDate.charAt(6) - 48) * 1000 + (inputDate.charAt(7) - 48) * 100 + (inputDate.charAt(8) - 48) * 10 + (inputDate.charAt(9) - 48);

        if ((year < 1000) || (year > 2500))
            // if the year is out of thr range [1000, 2500], return false
            yearCorrect = false;
        
        return yearCorrect;
    }

    /**
     * the main function
     * @param args
     */
    public static void main(String[] args) 
    {
        Scanner keyboardin = new Scanner(System.in); // a Scanner instance using keyboard typing
        String inputDate = null;                     // the initialized input date
        String inputMonth = null;                    // the new input month if getting an exception
        String inputDay = null;                      // the new input day if getting an exception
        String inputYear = null;                     // the new input year if getting an exception
        boolean done = false;                        // the index to show the input is correct

        // input the date
        System.out.print("Please enter date in following numerical format (mm/dd/yyyy): ");
        inputDate = keyboardin.nextLine();
        
        do
        {
            try
            {
                if (checkFormat(inputDate) == false)
                {    
                    // get the wrong formate
                    System.out.println("Your input format is not correct. Use mm/dd/yyyy.");
                    System.out.println();
                    System.out.print("Please enter date in following numerical format (mm/dd/yyyy): ");
                    inputDate = keyboardin.nextLine();
                }
                else if (checkMonth(inputDate) == false)
                    // catch the MonthException
                    throw new MonthException("The input month is invalid. Please enter the month again.");
                else if (checkDay(inputDate) == false)
                    // catch the DayException
                    throw new DayException("The input day is invalid. Please enter the day again.");
                else if (checkYear(inputDate) == false)
                    // catch the YearException
                    throw new YearException("The input year is invalid. Please enter the year again.");
                else 
                    done = true;
            } 
            catch (MonthException e_month)
            {
                // print the exception message and re-input the month
                System.out.println(e_month.getMessage());
                System.out.println();
                System.out.print("Please enter month in following numerical format (mm) between 1 and 12: ");
                inputMonth = keyboardin.nextLine();
                inputDate = inputMonth + inputDate.substring(2);
            }
            catch (DayException e_day)
            {
                // print the exception message and re-input the day
                System.out.println(e_day.getMessage());
                System.out.println();
                System.out.print("Please enter day in following numerical format (dd) after checking the month and the year: ");
                inputDay = keyboardin.nextLine();
                inputDate = inputDate.substring(0, 3) + inputDay + inputDate.substring(5, 10);
            }
            catch (YearException e_year)
            {
                // print the exception message and re-input the year
                System.out.println(e_year.getMessage());
                System.out.println();
                System.out.print("Please enter year in following numerical format (yyyy) between 1000 and 2500: ");
                inputYear = keyboardin.nextLine();
                inputDate = inputDate.substring(0, 6) + inputYear;
            }
        } while (! done);
   
        // print the converted date
        System.out.println();
        System.out.println("Done! Your input date is " + dateDisplay(inputDate) + ".");
        keyboardin.close();
    }    
}
