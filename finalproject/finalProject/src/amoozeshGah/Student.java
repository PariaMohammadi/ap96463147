package amoozeshGah;

import java.util.ArrayList;
import java.util.List;

class Student {
	private String name;
	private String username;
	private String password;
	private int age;
	List<String> className = new ArrayList<String> ();
	List<Double> classGrade = new ArrayList<Double> ();
	
	private boolean addNewClass = false;
	private boolean addNewTeacher = false;
	private boolean addNewStudent = false;
	private boolean seeAllClasses = false;
	private boolean seeClassInfo = false;
	private boolean seeTeacherClassInfo = false;
	private boolean seeClassStudents = false;
	private boolean removeSudentFromClass = false;
	private boolean setStudentGrades = false;
	private boolean seeAllOfferedClasses = true;
	private boolean removeStudentClass = true;
	private boolean studentUnitSelection = true;
	private boolean seeStudentClassInfo = true;
	
	public void addStudent(String Name, String User, String Pass, int Age) {
		name = Name;
		username = User;
		password = Pass;
		age = Age;
	}
	public void addClassGrade(String ClassName, Double ClassGrade) {
		className.add(ClassName);
		classGrade.add(ClassGrade);
	}
	public void removeClass(int index) {
		className.remove(index);
		classGrade.remove(index);
	}
	public void setClassGrade(int index, Double ClassGrade) {
		classGrade.set(index, ClassGrade);
	}
	
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getIthClassName (int i) {
		return className.get(i);
	}
	public int ClassNumber() {
		return className.size();
	}
	public Double getIthClassGrade (int i) {
		return classGrade.get(i);
	}
	
	public boolean addNewClassAccess() {
		return addNewClass;
	}
	public boolean addNewTeacherAccess() {
		return addNewTeacher;
	}
	public boolean addNewStudentAccess() {
		return addNewStudent;
	}
	public boolean seeAllClassesAccess() {
		return seeAllClasses;
	}
	public boolean aseeClassInfoAccess() {
		return seeClassInfo;
	}
	public boolean seeTeacherClassInfoAccess() {
		return seeTeacherClassInfo;
	}
	public boolean seeClassStudentAccess() {
		return seeClassStudents;
	}
	public boolean removeStudentFromClassAccess() {
		return removeSudentFromClass;
	}
	public boolean setStudentGradesAccess() {
		return setStudentGrades;
	}
	public boolean seeAllOfferedClassesAccess() {
		return seeAllOfferedClasses;
	}
	public boolean removeStudentClassAccess() {
		return removeStudentClass;
	}
	public boolean studentUnitSelectionAccess() {
		return studentUnitSelection;
	}
	public boolean seeStudentClassInfoAccess() {
		return seeStudentClassInfo;
	}
}