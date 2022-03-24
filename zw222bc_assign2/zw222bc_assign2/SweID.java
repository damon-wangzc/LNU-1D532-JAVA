/**
 * Date: 2021-06-21
 * File Name: SweID.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;

/**
 * Class Description: The class is to get relevant information from an input Swedish ID
 * 
 * @version 1.0 21 June 2021
 * @auther Zhicheng Wang
 */

public class SweID 
{
    private String sweID;                               // data member sweID
    
    // the function to get first part about birth information
    public static String getFirstPart(String sweID) {return sweID.substring(0, 6);}

    // the function to get the unique 3 digits and the check digit
    public static String getSecondPart(String sweID) {return sweID.substring(7);}

    // the function to judge if the ID belongs to a female, return a Boolean value
    // "true" means the ID belongs to a female
    public static boolean isFemaleNumber(String sweID) 
    {
        boolean gender = false;                     // initialize "gender" with "false"
        int genderNum = sweID.charAt(9);            // get the number which represents the information of gender
        if (genderNum % 2 == 0) {gender = true;}    // if the number is an even, the ID belongs to a female
        return gender;        
    }

    // the function is to judge if two IDs are the same
    // if yes, return ture, else return false
    public static boolean areEqual(String id1, String id2) 
    {
        boolean equalID = false;                    // initialize "equalID" with "false"
        if (id1.equals(id2)) {equalID = true;}      // if two IDs are the same, assign "true" to "equalID"
        return equalID;
    }

    // the function is to judge if a given ID is correct (legal, the format is right except for the unique digits)
    // suppose the range of the years is between 1921 and 2021 (the past 100 years)
    // the years (the same as the last two digits, including 2000) divisible by 4 are leap years
    public static boolean isCorrect(String sweID) 
    {
        boolean correct = false;                    // initialize "correct" with "false"
        int[] sweid = new int[10];                  // creat an array to store the ID
        int j = 0;                                  // "j" is used as the index of the created array
        int year;                                   // the year of ID (last 2 digits of years)
        int month;                                  // the month of ID (use 2 digits)
        int date;                                   // the date of ID (use 2 digits)
        int luhn;                                   // the check digit (the last digit of the ID)
        int luhnComputing = 0;                      // the computing check digit (initialize with "0")

        // use for-loop to get all digits of ID and store in the array
        for (int i = 0; i <= 11; i++)
        {
            // use if-else to judge if the ID uses digits and "-" between the first 6 and last 4 digits
            if (i == 6)                             // the position of "-"
            {   
                if (sweID.charAt(i) != '-')         // any other char, break and return false
                    break;
                else
                    continue;
            }
            else
            {   
                sweid[j] = sweID.charAt(i) - 48;    // converse string to char, then to integer

                // use if-else to computing the intermediate value (sum) of the check digit using Luhn algorithm
                // Luhn algorithm: see https://en.wikipedia.org/wiki/Luhn_algorithm 
                if (j == 9)                         // break loop with the last digit, when j = 9
                    break;
                else if (sweid[j] < 0 || sweid[j] > 10)     // if there is other char than digits, return false
                    break;
                else if (j % 2 == 0)                // the special computing for the even index
                    // add the sum of each digit of the number (doubling the even index digit)    
                    luhnComputing += (sweid[j] * 2) % 10 + (sweid[j] * 2) / 10;
                else
                    luhnComputing += sweid[j];
                j++;                                // use independent indexs to avoiding the "-"
            }
        }

        year = sweid[0] * 10 + sweid[1];            // use integer to represent "year" (last two digits)
        month = sweid[2] * 10 + sweid[3];           // use integer to represent "month" (two digits)
        date = sweid[4] * 10 + sweid[5];            // use integer to represent "date" (two digits)
        luhn = sweid[9];                            // the check number
        luhnComputing = (10 - luhnComputing % 10) % 10;     // get the final value of the check digit

        // use if-else statement to judge if the formate of ID is correct
        // if not correct, don't execute any code
        // exclude all considering incorrect situations, assign "true" to the "correct"      
        if (luhn != luhnComputing)                  // the check digit is not correct
            ;
        else if (month == 0 || month > 12)          // month is not correct
            ;
        else if (date == 0 || date > 31)            // date is not correct for all months
            ;
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && date > 30)
            ;                                       // date is not correct for the months of 30 days
        else
        {
            if (month != 2)                         // if not Feb., the format is correct
                correct = true;
            else 
                if (year % 4 == 0 && date > 29)     // if Feb. and leap year, date larger than 29 is incorrect
                    ;
                else if (year % 4 != 0 && date > 28)    // if Feb. and not leap year, date larger than 28 is incorrect
                    ;   
                else 
                    correct = true;                 // assign "true" to "correct" when excluding all the incorrect situations
        } 

        return correct;
    }

    // the testing main function
    /*
    public static void main(String[] args) 
    {
        System.out.println(getFirstPart("890408-6850"));
        System.out.println(getSecondPart("890408-6850"));
        System.out.println(isFemaleNumber("890408-6850"));
        System.out.println(areEqual("890408-6850", "890408-6850"));
        System.out.println(isCorrect("890408-6850"));
    }
    */

}