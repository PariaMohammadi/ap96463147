package assignment8;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Manager {

    public void File_Writer_G (Student_G student_g) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("G_Student.txt",true));
        bufferedWriter.write("\n" + String.valueOf(student_g));
        bufferedWriter.close();
    }

    public void File_Writer_S (Student_S student_s) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("S_Student.txt",true));
        bufferedWriter.write("\n" + String.valueOf(student_s));
        bufferedWriter.close();

    }

    public ArrayList<Student_G> G_Reader () throws FileNotFoundException {

        String filepath = "G_Student.txt";
        Scanner x = new Scanner(new File(filepath));
        x.useDelimiter("[\t\n]");

        ArrayList<Student_G> arrayList = new ArrayList<>();

        while(x.hasNext())
        {
            Student_G student_g = new Student_G();

            student_g.Number = x.next();
            student_g.F_name = x.next();
            student_g.L_Name = x.next();
            student_g.G_Year = x.next();

            arrayList.add(student_g);

        }

        return arrayList;
    }

    public ArrayList<Student_S> S_Reader () throws FileNotFoundException {

        String filepath = "S_Student.txt";
        Scanner x = new Scanner(new File(filepath));
        x.useDelimiter("[,\n]");

        ArrayList<Student_S> student_s = new ArrayList<>();

        while (x.hasNext())
        {
            Student_S student_s1 = new Student_S();

            student_s1.Number = x.next();
            student_s1.F_name = x.next();
            student_s1.L_Name = x.next();
            student_s1.Units = x.next();

            student_s.add(student_s1);
        }

        return student_s;


    }


}
