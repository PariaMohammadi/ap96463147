package amoozeshGah;

import java.util.ArrayList;
import java.util.List;

class Teacher {
	private String name;
	private String username;
	private String password;
	private int age;
	private List<String> className = new ArrayList<String>();
	private List<String> classTimeDay = new ArrayList<String> ();
	private List<Integer> classTimeHour = new ArrayList<Integer> ();
	
	private boolean addNewClass = false;
	private boolean addNewTeacher = false;
	private boolean addNewStudent = false;
	private boolean seeAllClasses = false;
	private boolean seeClassInfo = false;
	private boolean seeTeacherClassInfo = true;
	private boolean seeClassStudents = true;
	private boolean removeSudentFromClass = true;
	private boolean setStudentGrades = true;
	private boolean seeAllOfferedClasses = false;
	private boolean removeStudentClass = false;
	private boolean studentUnitSelection = false;
	private boolean seeStudentClassInfo = false;
	
	public void addTeacher(String Name, String User, String Pass, int Age) {
		name = Name;
		username = User;
		password = Pass;
		age = Age;
	}
	public void addClass(String ClassName, String ClassTimeDay, int ClassTimeHour) {
		className.add(ClassName);
		classTimeDay.add(ClassTimeDay);
		classTimeHour.add(ClassTimeHour);
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
	public int classNumber() {
		return className.size();
	}
	public String getIthClassName(int i) {
		return className.get(i);
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