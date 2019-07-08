package assignment6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input1=new Scanner(System.in);
        System.out.print("type x:");
        int x=input1.nextInt();
        Random r=new Random();
        int row=r.nextInt(x-0+1);
        ArrayList<ArrayList<Integer>> twoArray=new ArrayList<ArrayList<Integer>>();
        Random r1=new Random();
        for (int i=0;i<=row-1;i++)
        {
            int coloumn=r1.nextInt(x-0+1);
            Random r2=new Random();
            ArrayList<Integer> array=new ArrayList<Integer>();
            for (int j=0;j<=coloumn-1;j++)
            {
                int number=r2.nextInt(x-0+1);
                array.add(number);
            }
            twoArray.add(array);
        }

        for (int k=0;k<=twoArray.size()-1;k++)
        {
            System.out.println(twoArray.get(k));
            System.out.format("\n");
        }
    }
}