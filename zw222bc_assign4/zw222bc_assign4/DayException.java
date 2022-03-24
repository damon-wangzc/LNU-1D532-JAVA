/**
 * Date: 2021-07-10
 * File Name: DayException.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;

/**
 * Class Description: the DayException extends from Exception
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class DayException extends Exception
{
    private int invalidDay;

    public DayException(int day)
    {
        super("DayException");
        invalidDay = day;
    }

    public DayException()
    {
        super("DayException");
    }    

    public DayException(String message)
    {
        super(message);
    }

    public int getInvaildDay()
    {
        return invalidDay;
    }
}
