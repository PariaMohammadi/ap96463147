package assignment8;

import java.util.Comparator;

public class Sorter implements Comparator<Student_G> {
    @Override
    public int compare(Student_G o1, Student_G o2) {
        return o1.Number.compareTo(o2.Number);
    }
}
