package assignment4;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.format("please enter number of rows:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.format("please enter number of coloumns:");
        int m = input.nextInt();
        int a[][];
        a = new int[n][m];
        Random r = new Random();
        for (int k = 0; k <= n - 1; k++)
        {
            for (int l = 0; l <= m - 1; l++)
            {
                a[k][l] = r.nextInt(99 - 1 + 1) + 1;
            }
        }
        for (int t = 0; t <= n - 1; t++)
        {
            for (int u = 0; u <= m - 1; u++)
            {
                System.out.format("%4d", a[t][u]);
            }
            System.out.format("\n");
        }
        System.out.format("enter number of row or coloumns:");
        String s = input.next();
        String s1 = s.substring(0, 1); //s1,ya r ya k
        int num = Integer.parseInt(s.substring(1));
        if (s1.compareTo("r")==0)
        {
            for(int i=n-1;i>=0;i--)
            {
                for(int j=0;j<=i;j++)
                {
                    if(a[num][j]>a[num][j+1])
                    {
                        for(int h=0;h<=n-1;h++)
                        {
                            int temp=a[h][j];
                            a[h][j]=a[h][j+1];
                            a[h][j+1]=temp;
                        }
                    }
                }
            }
        }
        if (s1.compareTo("c")==0)
        {
            for(int i=n-1;i>0;i--)
            {
                for(int j=0;j<i;j++)
                {
                    if(a[j][num]>a[j+1][num])
                    {
                        for(int h=0;h<=m-1;h++)
                        {
                            int temp=a[j][h];
                            a[j][h]=a[j+1][h];
                            a[j+1][h]=temp;
                        }
                    }
                }
            }
        }
        for (int x = 0; x <= n - 1; x++)
        {
            for (int y = 0; y <= m - 1; y++)
            {
                System.out.format("%4d", a[x][y]);
            }
            System.out.format("\n");
        }
    }
}