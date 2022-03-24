/**
 * Date: 2021-07-10
 * File Name: YearException.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;

/**
 * Class Description: the YearException extends from Exception
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class YearException extends Exception
{
    private int invalidYear;

    public YearException(int year)
    {
        super("YearException");
        invalidYear = year;
    }

    public YearException()
    {
        super("YearException");
    }    

    public YearException(String message)
    {
        super(message);
    }

    public int getInvalidYear()
    {
        return invalidYear;
    }
}
