/**
 * Print.java
 * Author: Zhicheng Wang
 * Student ID: zw222bc
 */

package zw222bc_assign1;
import java.util.Collections;

/**
 * A program to print in different form
 */

public class Print {
    public static void main(String[] args) {
        System.out.println("Write once, run everywhere!");
        System.out.println("Write\nonce,\nrun\neverywhere!");
        System.out.println(String.join(" ", Collections.nCopies(18, "*")));             // print 18 "*" with a space between them
        /* System.out.println("*                                 *"); */
        System.out.println("*" + String.join("", Collections.nCopies(33, " ")) + "*");  
        System.out.println("*   Write once, run everywhere!   *");
        System.out.println("*                                 *");
        System.out.println(String.join(" ", Collections.nCopies(18, "*")));
    }
}
