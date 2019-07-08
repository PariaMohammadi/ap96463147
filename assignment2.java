package assignment2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.format("please enter an odd number of stars in the middle row:");
        int n=input.nextInt();
        while(n%2==0)
        {
            System.out.format("please enter an >>odd<< number of stars in the middle row:");
            n=input.nextInt();
        }
        n=(n+1)/2;
        for (int i = 1; i <= 2 * n - 1; i++)
        {
            for (int k = 1; k <= Math.abs(n - i); k++)
            {
                System.out.format(" ");
            }
            for (int j = 1; j <= 2 * (n - Math.abs(n - i)) - 1; j++)
            {
                System.out.format("*");
            }
            System.out.format("\n");
        }
    }
}
