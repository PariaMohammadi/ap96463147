package amoozeshGah;

class Admin {
	private String username;
	private String password;
	
	private boolean addNewClass = true;
	private boolean addNewTeacher = true;
	private boolean addNewStudent = true;
	private boolean seeAllClasses = true;
	private boolean seeClassInfo = true;
	private boolean seeTeacherClassInfo = false;
	private boolean seeClassStudents = false;
	private boolean removeSudentFromClass = false;
	private boolean setStudentGrades = false;
	private boolean seeAllOfferedClasses = false;
	private boolean removeStudentClass = false;
	private boolean studentUnitSelection = false;
	private boolean seeStudentClassInfo = false;
	
	Admin() {
		username = "admin";
		password = "admin";
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
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
	public boolean seeClassInfoAccess() {
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