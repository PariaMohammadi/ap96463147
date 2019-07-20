package amoozeshGah;

import java.util.ArrayList;
import java.util.List;

public class Clas {
	private String name;
	private String teacherUsername;
	private String timeDay;
	private int timeHour;
	private List<String> classStudents = new ArrayList<String> ();
	
	public void addClass (String ClassName, String TeacherUsername, String TimeDay, int TimeHour) {
		name = ClassName;
		teacherUsername = TeacherUsername;
		timeDay = TimeDay;
		timeHour = TimeHour;
	}
	public void addStudent(String studentName) {
		classStudents.add(studentName);
	}
	public void removeStudent(int studentIndex) {
		classStudents.remove(studentIndex);
	}
	
	public String getClassName() {
		return name;
	}
	public String getClassTeacherUsername() {
		return teacherUsername;
	}
	public String getClassTimeDay() {
		return timeDay;
	}
	public int getClassTimeHour() {
		return timeHour;
	}
	public String getIthClassStudent(int i) {
		return classStudents.get(i);
	}
	public int classStudentsNumber() {
		return classStudents.size();
	}
}
