package assignment3;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        System.out.format("type the number of rows & coloumns=");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int a[][];
        a=new int[n][n];
        Random r=new Random();
        int x,y; //mokhtasat arraye haye matris
        for(int i=0;i<=n-1;i++) //meghdar dehii b ghesmat balaye ghotr asli
        {
            x=i; //peymayesh ax satr i om shuru mishavad
            y=0; //peymayesh ax sutun j om shuru mishavad
            for(int j=1;j<=i+1;j++)
            {
                a[x][y]=r.nextInt(99 - 1 + 1) + 1;
                x--;
                y++;
            }
            x++; //be khater meghdar dehi exafe dar marhale akhar
            y--; //be khater meghdar dehi exafe dar marhale akhar
        }
        for(int i=1;i<=n-1;i++) //meghdar dehii b ghesmat payine ghotr asli
        {
            x=n-1; //peymayesh ax satr n-1 om shuru mishavad
            y=i; //peymayesh ax sutun i om shuru mishavad
            for(int j=1;j<=n-i;j++)
            {
                a[x][y]=r.nextInt(99 - 1 + 1) + 1;
                x--; //be khater meghdar dehi exafe dar marhale akhar
                y++; //be khater meghdar dehi exafe dar marhale akhar
            }
            x++;
            y--;
        }
        for(int k=0;k<=n-1;k++)
        {
            for(int l=0;l<=n-1;l++) //chap sutun ba satr k om
            {
                System.out.format("%4d",a[k][l]);
            }
            System.out.format("\n");
        }
    }
}