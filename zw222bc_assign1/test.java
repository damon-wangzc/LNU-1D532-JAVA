import java.util.Scanner;
import java.util.InputMismatchException;

class BreakContinueDemo {
    public static void main(String[] args) 
    {
        for (int i = 1; i <= 20; ++i) 
        {
            if (i == 10) 
            { //break the loop when i is 10
                break; 
            }
            if(i%2==0)
            { //continuetheloopifiis // an even number
                continue; 
            }
            System.out.println(i); 
        }
    } 
}