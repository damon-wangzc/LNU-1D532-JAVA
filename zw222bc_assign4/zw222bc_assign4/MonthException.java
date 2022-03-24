/**
 * Date: 2021-07-10
 * File Name: MonthException.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;

/**
 * Class Description: the MonthException extends from Exception
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class MonthException extends Exception
{
    private int invalidMonth;

    public MonthException(int inputmonth)
    {
        super("MonthException");
        invalidMonth = inputmonth;
    }

    public MonthException()
    {
        super("MonthException");
    }

    public MonthException(String message)
    {
        super(message);
    }

    public int getInvalidMonth()
    {
        return invalidMonth;
    }
}
