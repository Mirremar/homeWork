package Java;

import java.util.Random;
import java.util.Scanner;
/**
 * program
 */
public class Lesson1 {

    public static void main(String[] args) 
    {
        System.out.println("enter k");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int k = 0;
        k = Integer.parseInt(sc.nextLine());
        int[] coefficients = new int[k+1];
        for (int i =0;i<coefficients.length;i++)
        {
            coefficients[i] = rd.nextInt(100);
        }
        String result = "";
        for (int i =0;i<coefficients.length-2;i++)
        {
            if (coefficients[i] == 0)
            {
                continue;
            }
            result+=String.valueOf(coefficients[i]).concat("x^").concat(String.valueOf(k-i)).concat(" + ");
        }
            result+=String.valueOf(coefficients[coefficients.length-2]).concat("x + ").concat(String.valueOf(coefficients[coefficients.length-1]));

        System.out.println(result);
        //s
    }
}