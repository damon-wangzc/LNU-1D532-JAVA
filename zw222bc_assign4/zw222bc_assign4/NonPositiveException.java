/**
 * Date: 2021-07-10
 * File Name: NonPositiveException.java 
 * Auther: Zhicheng Wang
 */

package zw222bc_assign4;

/**
 * Class Description: the NonPositiveException extends from Exception
 *
 * @version 1.0 10 July 2021
 * @auther Zhicheng Wang 
 */

public class NonPositiveException extends Exception
{
    private int nonPositive;
    
    public NonPositiveException(int number)
    {
        super("NonPositiveException");
        nonPositive = number;
    }

    public NonPositiveException()
    {
        super("NonPositiveException");
    }

    public NonPositiveException(String message)
    {
        super(message);
    }

    public int getNonPositive()
    {
        return nonPositive;
    }
}
