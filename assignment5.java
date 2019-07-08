package assignment5;

public class Main {

    public static void main(String[] args) {
        Long startTime=System.currentTimeMillis();
        float function,min=0,max=0;
        for (float i = 0; i <= 999; i++)
        {
            for (float j = 0; j <= 999; j++)
            {
                function = (float) ((Math.abs(i * i + j * j)) / (i * Math.sin(i + j) + j * Math.cos(i + j)));
                if (function > max)
                {
                    max = function;
                }
                if (function < min)
                {
                    min = function;
                }
            }
        }
        System.out.format("the MAX value in %f\n",max );
        System.out.format("the MIN value in %f\n",min );
        System.out.println((System.currentTimeMillis()-startTime)+" ms");
    }
}