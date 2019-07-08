package assignment8;

public class Student_G implements Comparable<Student_G>{

    String F_name;
    String L_Name;
    String Number;
    String G_Year;

    @Override
    public String toString() {
        return Number +"\t"+ F_name + "\t" + L_Name + "\t" + G_Year;
    }

    @Override
    public int compareTo(Student_G student_g) {
        return this.Number.compareTo(student_g.Number);
    }
}
