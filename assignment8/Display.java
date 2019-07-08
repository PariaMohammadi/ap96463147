package assignment8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Display {

    public void Menu() throws IOException {

        for (;;)
        {
            System.out.println("What Do you want to do ?");
            System.out.println("1- Add");
            System.out.println("2- Report");
            System.out.println("3- exit");

            int a;
            Scanner input = new Scanner(System.in);
            a = input.nextInt();

            if (a == 1)
            {
                System.out.println("1- G_Student");
                System.out.println("2- S_Student");

                int b;
                Scanner B = new Scanner(System.in);
                b = B.nextInt();

                if (b == 1)
                {
                    Add_G_Student();
                }else if (b == 2)
                {
                    Add_S_Student();
                }else
                {
                    System.out.println("You shuold choose one or two ... !");
                }
            }else if (a == 2)
            {
                System.out.println("1- G_Student");
                System.out.println("2- S_Student");

                int c;
                Scanner C = new Scanner(System.in);
                c = C.nextInt();

                if (c == 1)
                {
                    G_Stdent_Report();
                }else if (c == 2)
                {
                    S_Student_Report();
                }else
                {
                    System.out.println("You shuold choose one or two ... !");
                }
            }
            else if (a==3)
            {
                return;
            }
            else
            {
                System.out.println("You shuold choose one or two or three ... !");
            }
        }

    }

    public void Add_G_Student() throws IOException {

        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);

        Student_G student_g = new Student_G();

        System.out.println("Enter Number :");
        student_g.Number = input.nextLine();
        System.out.println("Enter First Name : ");
        student_g.F_name = input1.nextLine();
        System.out.println("Enter Last Name :");
        student_g.L_Name = input2.nextLine();
        System.out.println("Enter Graduated Year :");
        student_g.G_Year = input3.nextLine();
        try
        {
            if(Integer.parseInt(student_g.G_Year) > 1380)
            {

            }
            else
            {
                throw new ArithmeticException("graduated year should be bigger than 1380...!");
            }
        }catch (ArithmeticException e)
        {
            System.out.println("units should be under 250...!");
            student_g.G_Year = input3.nextLine();
        }

        File_Manager file_manager = new File_Manager();
        file_manager.File_Writer_G(student_g);

    }

    public void Add_S_Student () throws IOException {

        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);

        Student_S student_s = new Student_S();

        System.out.println("Enter Number :");
        student_s.Number = input.nextLine();
        System.out.println("Enter First Name : ");
        student_s.F_name = input1.nextLine();
        System.out.println("Enter Last Name :");
        student_s.L_Name = input2.nextLine();
        System.out.println("Enter Units :");
        student_s.Units = input3.nextLine();
        try
        {
            if(Integer.parseInt(student_s.Units) < 250)
            {

            }
            else
            {
                throw new ArithmeticException("units should be under 250...!");
            }
        }catch (ArithmeticException e)
        {
            System.out.println("units should be under 250...!");
            student_s.Units = input3.nextLine();
        }


        File_Manager file_manager = new File_Manager();
        file_manager.File_Writer_S(student_s);
    }

    public void G_Stdent_Report () throws FileNotFoundException {

        File_Manager file_manager = new File_Manager();

        ArrayList<Student_G> student_gs = file_manager.G_Reader();
        //Collections.sort(student_gs,new Sorter());
        student_gs.sort((o1, o2) -> o1.Number.compareTo(o2.Number));
        for (Student_G student_g : student_gs)
        {
            System.out.println(student_g);
        }

    }

    public void S_Student_Report() throws FileNotFoundException {

        File_Manager file_manager = new File_Manager();

        ArrayList<Student_S> student_ss = file_manager.S_Reader();

        for (Student_S student_s : student_ss)
        {
            System.out.println(student_s);
        }
    }

}