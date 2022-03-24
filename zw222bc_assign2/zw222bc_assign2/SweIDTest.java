/**
 * Date: 2021-06-25
 * File Name: SweIDTest.java
 * Auther: Zhicheng Wang
 */

package zw222bc_assign2;

/**
 * Class Description: test if the SweID class works as expected
 * 
 * @version 1.0 25 June 2021
 * @auther Zhicheng Wang
 */

public class SweIDTest 
{
    public static void main(String[] args) 
    {
        System.out.println(SweID.getFirstPart("890408-6850"));
        System.out.println(SweID.getSecondPart("890408-6850"));
        System.out.println(SweID.isFemaleNumber("890408-6850"));
        System.out.println(SweID.areEqual("890408-6850", "890408-6850"));
        System.out.println(SweID.isCorrect("890408-6850"));

        System.out.println(SweID.isFemaleNumber("640123-8826"));
        System.out.println(SweID.isFemaleNumber("550414-0913"));
        System.out.println(SweID.isCorrect("551314-0913"));
        System.out.println(SweID.isCorrect("550414-0912"));        
    }
    
}