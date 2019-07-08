package assignment1;

public class Main {
	public static void main(String[] args) {
        int n=4;
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
