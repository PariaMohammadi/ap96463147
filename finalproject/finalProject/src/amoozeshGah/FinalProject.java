package amoozeshGah;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FinalProject extends Application {
	
	int loginWidth = 300;
	int loginHeight = 275;
	
	int panelWidth = 750;
	int panelHeight = 450;
	
	int globalHelper = 0;

	Admin adminUser = new Admin();
	List<Teacher> teacherUser = new ArrayList<Teacher> ();
	List<Student> studentUser = new ArrayList<Student> ();
	List<Clas> clas = new ArrayList<Clas> ();
	
	boolean isNumber(String s) {
		/*
        for (int i = 0; i < s.length(); i++) { 
        	if (Character.isDigit(s.charAt(i)) == false) { 
        		return false;
        	}
        }
        return true;
        */
		try {
			Double.valueOf(s);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
    } 
	
	void addNewClass (Stage stage, String Name, int user) {
		
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Add New Class");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label className = new Label("Class Name:");
        grid.add(className, 0, 1);
        TextField classNameTextField = new TextField();
        grid.add(classNameTextField, 1, 1);
        
        Label TeacherName = new Label("Teacher's Name:");
        grid.add(TeacherName, 0, 2);
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < teacherUser.size(); i++) {
        	comboBox.getItems().add(
        				teacherUser.get(i).getUsername() + " - " +  teacherUser.get(i).getName()
        			);
        }
        grid.add(comboBox, 1, 2);
        
        Label classTimeDay = new Label("Class's Time - Day:");
        grid.add(classTimeDay, 0, 3);
        TextField classTimeDayTextField = new TextField();
        grid.add(classTimeDayTextField, 1, 3);
        
        Label classTimeHour = new Label("Class's Time - Hour:");
        grid.add(classTimeHour, 0, 4);
        TextField classTimeHourTextField = new TextField();
        grid.add(classTimeHourTextField, 1, 4);
        
        Button addClassBtn = new Button("Add Class");
        grid.add(addClassBtn, 2, 5);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 3, 5);
        
        final Text log = new Text();
        grid.add(log, 1, 6);
        
        addClassBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if ( (classNameTextField.getText().equals("")) || (classTimeDayTextField.getText().equals(""))
            	  || (classTimeHourTextField.getText().equals("")) || (! isNumber(classTimeHourTextField.getText()))
            	  || (comboBox.getValue().equals("Not Selected")) ) {
            		log.setFill(Color.FIREBRICK);
	                log.setText("Wrong Input(s)");
            	}
            	else {
            		Clas tempClass = new Clas();
	                tempClass.addClass(classNameTextField.getText(), comboBox.getValue(), classTimeDayTextField.getText(), Integer.parseInt(classTimeHourTextField.getText()));
            		
            		log.setFill(Color.GREEN);
	                log.setText("Class Added");
	                
	                classNameTextField.setText("");
	                comboBox.getSelectionModel().selectFirst();
	                classTimeDayTextField.setText("");
	                classTimeHourTextField.setText("");
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel(stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("Add Class");
        stage.setScene(scene);
        stage.show();
	}
	
	void addNewTeacher(Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Add New Teacher");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label teacherName = new Label("Name:");
        grid.add(teacherName, 0, 1);
        TextField teacherNameTextField = new TextField();
        grid.add(teacherNameTextField, 1, 1);
        
        Label TeacherFamilyName = new Label("Family Name:");
        grid.add(TeacherFamilyName, 0, 2);
        TextField TeacherFamilyNameTextField = new TextField();
        grid.add(TeacherFamilyNameTextField, 1, 2);
        
        Label age = new Label("Age: ");
        grid.add(age, 0, 3);
        TextField ageTextField = new TextField();
        grid.add(ageTextField, 1, 3);
        
        Label teacherUsername = new Label("Teacher's Username:");
        grid.add(teacherUsername, 0, 4);
        TextField TeacherUsernameTextField = new TextField();
        grid.add(TeacherUsernameTextField, 1, 4);
        
        Label teacherPassword = new Label("Teacher's Password:");
        grid.add(teacherPassword, 0, 5);
        TextField teacherPasswordTextField = new TextField();
        grid.add(teacherPasswordTextField, 1, 5);
        
        Button addTeacherBtn = new Button("Add Teacher");
        grid.add(addTeacherBtn, 2, 6);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 3, 6);
        
        final Text log = new Text();
        grid.add(log, 1, 7);
        
        addTeacherBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if ( teacherNameTextField.getText().equals("") || TeacherFamilyNameTextField.getText().equals("")
            	|| ageTextField.getText().equals("") || TeacherUsernameTextField.getText().equals("")
            	|| teacherPasswordTextField.getText().equals("") || (! isNumber(ageTextField.getText())) ) {
              		log.setFill(Color.FIREBRICK);
  	                log.setText("Wrong Input(s)");
              	}
              	else {
              		Teacher tempTeacher = new Teacher ();
  	                tempTeacher.addTeacher(teacherNameTextField.getText() + "_" + TeacherFamilyNameTextField.getText(),
            								TeacherUsernameTextField.getText(),
            								teacherPasswordTextField.getText(),
            								Integer.parseInt(ageTextField.getText()) );

              		log.setFill(Color.GREEN);
  	                log.setText("Student Added");
  	                
  	                teacherNameTextField.setText("");
  	                TeacherFamilyNameTextField.setText("");
  	                ageTextField.setText("");
  	                TeacherUsernameTextField.setText("");
  	                teacherPasswordTextField.setText("");
              	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel(stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("Add New Teacher");
        stage.setScene(scene);
        stage.show();
	}
	
	void addNewStudent(Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Add New Student");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label studentName = new Label("Name:");
        grid.add(studentName, 0, 1);
        TextField studentNameTextField = new TextField();
        grid.add(studentNameTextField, 1, 1);
        
        Label studentFamilyName = new Label("Family Name:");
        grid.add(studentFamilyName, 0, 2);
        TextField studentFamilyNameTextField = new TextField();
        grid.add(studentFamilyNameTextField, 1, 2);
        
        Label studentMajor = new Label("Major:");
        grid.add(studentMajor, 0, 3);
        TextField studentMajorTextField = new TextField();
        grid.add(studentMajorTextField, 1, 3);
        
        Label age = new Label("Age: ");
        grid.add(age, 0, 4);
        TextField ageTextField = new TextField();
        grid.add(ageTextField, 1, 4);
        
        Label studentUsername = new Label("Student's Username:");
        grid.add(studentUsername, 0, 5);
        TextField studentUsernameTextField = new TextField();
        grid.add(studentUsernameTextField, 1, 5);
        
        Label studentPassword = new Label("Student's Password:");
        grid.add(studentPassword, 0, 6);
        TextField studentPasswordTextField = new TextField();
        grid.add(studentPasswordTextField, 1, 6);
        
        Button addStudentBtn = new Button("Add Student");
        grid.add(addStudentBtn, 2, 7);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 3, 7);
        
        final Text log = new Text();
        grid.add(log, 1, 8);
        
        addStudentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if ( studentNameTextField.getText().equals("") || studentFamilyNameTextField.getText().equals("")
            	|| studentMajorTextField.getText().equals("") || ageTextField.getText().equals("")  
            	|| studentUsernameTextField.getText().equals("")|| studentPasswordTextField.getText().equals("")
            	|| (! isNumber(ageTextField.getText())) ) {
              		log.setFill(Color.FIREBRICK);
  	                log.setText("Wrong Input(s)");
              	}
              	else {
//              		Student.add(studentNameTextField.getText() + "_" + studentFamilyNameTextField.getText());
//  	                StudentMajor.add(studentMajorTextField.getText());
//  	                StudentAge.add(Integer.parseInt(ageTextField.getText()));
//  	                StudentUsername.add(studentUsernameTextField.getText());
//  	                StudentPassword.add(studentPasswordTextField.getText());

              		log.setFill(Color.GREEN);
  	                log.setText("Teacher Added");
  	                
  	                studentNameTextField.setText("");
  	              	studentFamilyNameTextField.setText("");
  	              	studentMajorTextField.setText("");
  	                ageTextField.setText("");
  	                studentUsernameTextField.setText("");
  	                studentPasswordTextField.setText("");
              	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel(stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("Add New Student");
        stage.setScene(scene);
        stage.show();
	}
	
	void SeeAllClasses(Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(30);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
		
        Button backBtn = new Button("Back");
        grid.add(backBtn, 0, 0);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel(stage, Name, user);
            }
        });
        
        for (int i = 1; i < clas.size(); i++) {
        	Label tmp = new Label(Integer.toString(i));
	        grid.add(tmp, 0, i);
        }
        
        Label ClassLabel = new Label("Class Name");
        grid.add(ClassLabel, 1, 0);
        
        Label TeacherLabel = new Label("Teacher's Username");
        grid.add(TeacherLabel, 2, 0);
        
        Label TimeDayLabel = new Label("Time - Day");
        grid.add(TimeDayLabel, 3, 0);
        
        Label TimeHourLabel = new Label("Time - Hour");
        grid.add(TimeHourLabel, 4, 0);
        
        for (int i = 1; i < clas.size(); i++) {
        	Label tmp = new Label(clas.get(i).getClassName());
	        grid.add(tmp, 1, i);
	        
	        tmp = new Label(clas.get(i).getClassTeacherUsername());
	        grid.add(tmp, 2, i);
	        
	        tmp = new Label(clas.get(i).getClassTimeDay());
	        grid.add(tmp, 3, i);
	        
	        tmp = new Label(Integer.toString(clas.get(i).getClassTimeHour()));
	        grid.add(tmp, 4, i);
        }
        
        
		Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("See All Classes");
        stage.setScene(scene);
        stage.show();
	}
	
	void seeClassGrades (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < clas.size(); i++) {
        	comboBox.getItems().add(clas.get(i).getClassName());
        }
        grid.add(comboBox, 0, 0);
        
        final Text log = new Text("Please Select Again");
        log.setVisible(false);
        grid.add(log, 1, 0);
        
        Button showGrades = new Button("Show Classes Grades");
        showGrades.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(showGrades, 3, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 4, 0);
        
        Label classInfo = new Label("Teacher's Username:");
		grid.add(classInfo, 0, 1);
		
		classInfo = new Label("Day:");
		grid.add(classInfo, 1, 1);
		
		classInfo = new Label("Hour:");
		grid.add(classInfo, 2, 1);
		
		classInfo = new Label("Grades:");
		grid.add(classInfo, 3, 1);
		
		classInfo = new Label("Student Name:");
		grid.add(classInfo, 4, 1);
		
		Label tmp = new Label("TEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 0, 2);
		tmp = new Label("TEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 1, 2);
		tmp = new Label("42");
		tmp.setVisible(false);
		grid.add(tmp, 2, 2);
		        
        showGrades.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	int classNumber = -1;
            	for (int i = 0; i < clas.size(); i++) {
            		if (clas.get(i).getClassName().equals(comboBox.getValue())) {
            			classNumber = i;
            		}
            	}
            	
            	if (classNumber == -1) {
            		for (int i = 0; i < globalHelper; i++) {
            			grid.getChildren().remove(12);
            		}
            		globalHelper = 0;
            		
            		log.setFill(Color.RED);
                    log.setVisible(true);
            	}
            	else {
            		log.setVisible(false);
            		
            		for (int i = 0; i < globalHelper; i++) {
            			grid.getChildren().remove(12);
            		}

        			Label classInfo = new Label(clas.get(classNumber).getClassTeacherUsername());
        			grid.add(classInfo, 0, 2);
        			
        			classInfo = new Label(clas.get(classNumber).getClassTimeDay());
        			grid.add(classInfo, 1, 2);
        			
        			classInfo = new Label(Integer.toString(clas.get(classNumber).getClassTimeHour()));
        			grid.add(classInfo, 2, 2);

        			globalHelper = 3;
        			
        			for (int i = 0; i < studentUser.size(); i++) {
        				for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {
	        				if (studentUser.get(i).getIthClassName(j).equals(comboBox.getValue())) {
	        					Label tmp = new Label(Double.toString(studentUser.get(i).getIthClassGrade(j)));
	            				grid.add(tmp, 3, i+2);
	            				
	            				tmp = new Label(studentUser.get(i).getName());
	            				grid.add(tmp, 4, i+2);
	            				
	            				globalHelper += 2;
	        				}
        				}
        			}
        			
        			
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
        
        globalHelper = 0;
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("See All Grades");
        stage.setScene(scene);
        stage.show();
	}
	
	void seeTeacherClass (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < teacherUser.size(); i++) {
        	if (Name.equals(teacherUser.get(i).getName())) {
	        	for (int j = 0; j < teacherUser.get(i).classNumber(); j++) {
        			comboBox.getItems().add(teacherUser.get(i).getIthClassName(j));
	        	}
        	}
        }
        grid.add(comboBox, 0, 0);
        
        Button showGrades = new Button("Show Class Info");
        showGrades.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(showGrades, 1, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 2, 0);
        
        final Text log = new Text();
        grid.add(log, 0, 1);
        
        Label classInfo = new Label("Teacher's Userame:");
		grid.add(classInfo, 0, 2);
		
		classInfo = new Label("Day:");
		grid.add(classInfo, 1, 2);
		
		classInfo = new Label("Hour:");
		grid.add(classInfo, 2, 2);
        
		Label tmp = new Label("tmp");
		tmp.setVisible(false);
		grid.add(tmp, 0, 3);
		tmp = new Label("tmp");
		tmp.setVisible(false);
		grid.add(tmp, 1, 3);
		tmp = new Label("tmp");
		tmp.setVisible(false);
		grid.add(tmp, 2, 3);
        
        showGrades.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	int classNumber = -1;
            	for (int i = 0; i < clas.size(); i++) {
            		if (clas.get(i).getClassName().equals(comboBox.getValue())) {
            			classNumber = i;
            		}
            	}
            	
            	if (classNumber == -1) {
            		for (int i = 0; i < 3; i++) {
            			grid.getChildren().remove(7);
            		}
            		Label tmp = new Label("tmp");
            		tmp.setVisible(false);
            		grid.add(tmp, 0, 3);
            		tmp = new Label("tmp");
            		tmp.setVisible(false);
            		grid.add(tmp, 1, 3);
            		tmp = new Label("tmp");
            		tmp.setVisible(false);
            		grid.add(tmp, 2, 3);
            		
            		log.setFill(Color.RED);
                    log.setText("Please Select Again");
            	}
            	else {
            		log.setText("");
            		
            		for (int i = 0; i < 3; i++) {
            			grid.getChildren().remove(7);
            		}
        			
        			Label classInfo = new Label(clas.get(classNumber).getClassTeacherUsername());
        			grid.add(classInfo, 0, 3);
        			
        			classInfo = new Label(clas.get(classNumber).getClassTimeDay());
        			grid.add(classInfo, 1, 3);
        			
        			classInfo = new Label(Integer.toString(clas.get(classNumber).getClassTimeHour()));
        			grid.add(classInfo, 2, 3);
        			
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("See Teacher's Class Info");
        stage.setScene(scene);
        stage.show();
	}
	
	void seeClassStudents (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < teacherUser.size(); i++) {
        	if (Name.equals(teacherUser.get(i).getName())) {
	        	for (int j = 0; j < teacherUser.get(i).classNumber(); j++) {
        			comboBox.getItems().add(teacherUser.get(i).getIthClassName(j));
	        	}
        	}
        }
        grid.add(comboBox, 0, 0);
        
        Button showGrades = new Button("Show Class Students");
        showGrades.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(showGrades, 1, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 2, 0);
        
        final Text log = new Text("Please Select Again");
        log.setFill(Color.RED);
        log.setVisible(false);
        grid.add(log, 0, 1);
        
        Label classInfo = new Label("Student Name:");
		grid.add(classInfo, 0, 2);
		
		classInfo = new Label("Grades:");
		grid.add(classInfo, 1, 2);
        
		Label tmp = new Label("TEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 0, 2);
		tmp = new Label("TEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 1, 2);
		tmp = new Label("42");
		tmp.setVisible(false);
		grid.add(tmp, 2, 2);
		
        showGrades.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	int classNumber = -1;
            	for (int i = 0; i < clas.size(); i++) {
            		if (clas.get(i).getClassName().equals(comboBox.getValue())) {
            			classNumber = i;
            		}
            	}
            	
            	if (classNumber == -1) {     
            		for (int i = 0; i < globalHelper; i++) {
            			grid.getChildren().remove(9);
            		}
            		globalHelper = 0;
            		
            		log.setVisible(true);
            	}
            	else {
            		log.setVisible(false);
            		
            		for (int i = 0; i < globalHelper; i++) {
            			grid.getChildren().remove(9);
            		}
        			
            		globalHelper = 0;
            		
        			for (int i = 0; i < studentUser.size(); i++) {
        				for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {
	        				if (studentUser.get(i).getIthClassName(j).equals(comboBox.getValue())) {
	        					Double temp = studentUser.get(i).getIthClassGrade(j);
	            				if (temp != -1) {
	            					Label tmp = new Label(studentUser.get(i).getName());
		            				grid.add(tmp, 0, i+3);
		            				
		        					tmp = new Label(Double.toString(temp));
		            				grid.add(tmp, 1, i+3);
		            				
		            				globalHelper += 2;
	            				}
	        				}
        				}
        			}
        			
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
        
        globalHelper = 0;
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("See Class Students");
        stage.setScene(scene);
        stage.show();
	}
	
	void removeStudentFromClass (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < teacherUser.size(); i++) {
        	if (Name.equals(teacherUser.get(i).getName())) {
	        	for (int j = 0; j < teacherUser.get(i).classNumber(); j++) {
        			comboBox.getItems().add(teacherUser.get(i).getIthClassName(j));
	        	}
        	}
        }
        grid.add(comboBox, 0, 0);
        
        ComboBox<String> comboBox2 = new ComboBox<String>();
        comboBox2.getItems().add("Not Selected");
        comboBox2.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox2.getSelectionModel().selectFirst();
        comboBox2.setDisable(true);
        grid.add(comboBox2, 0, 1);
		
        Button showGrades = new Button("Show Class Students");
        showGrades.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(showGrades, 3, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 4, 0);
        
        final Text selectClassLog = new Text("Please Select Again");
        selectClassLog.setVisible(false);
        grid.add(selectClassLog, 1, 0);
        
        final Text selectStudentLog = new Text("Please Select Again");
        selectStudentLog.setVisible(false);
        grid.add(selectStudentLog, 1, 1);
        
        final Text removeStudentLog = new Text("                            ");
        removeStudentLog.setVisible(false);
        grid.add(removeStudentLog, 0, 3, 4, 1);
        
        Button removeStudentBtn = new Button("Remove Student");
        removeStudentBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        removeStudentBtn.setDisable(true);
        grid.add(removeStudentBtn, 3, 2);
        
        showGrades.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if (comboBox.getValue().equals("Not Selected")) {
            		selectClassLog.setFill(Color.RED);
            		selectClassLog.setText("Please Select Again");
            		selectClassLog.setVisible(true);
                    comboBox2.setDisable(true);
                    removeStudentBtn.setDisable(true);
            	}
            	else {
            		selectClassLog.setVisible(false);
            		comboBox2.setDisable(false);
            		removeStudentBtn.setDisable(false);
            		
            		for (int i = 0; i < clas.size(); i++) {
                    	if (comboBox.getValue().equals(clas.get(i).getClassName())) {
            	        	for (int j = 0; j < clas.get(i).classStudentsNumber(); j++) {
            	        		List<String> items = comboBox2.getItems();
            	        		boolean flag = true;
            	                for(String item : items){
            	                	if (item.toString().equals(clas.get(i).getIthClassStudent(j))) {
                	        			flag = false;
                	        		}
            	                }
            	                if (flag == true) {
	            	                comboBox2.getItems().add(clas.get(i).getIthClassStudent(j));
            	                }
            	        	}
                    	}
                    }
            	}
            }
        });
        
        removeStudentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if (comboBox2.getValue().equals("Not Selected")) {
            		selectStudentLog.setFill(Color.RED);
            		selectStudentLog.setText("Please Select Again");
            		selectStudentLog.setVisible(true);
            	}
            	else {
            		selectStudentLog.setVisible(false);
            		
            		for (int i = 0; i < clas.size(); i++) {
            			if (clas.get(i).getClassName().equals(comboBox.getValue())) {
	            			for (int j = 0; j < clas.get(i).classStudentsNumber(); j++) {
	            				if (clas.get(i).getIthClassStudent(j).equals(comboBox2.getValue())) {
	            					clas.get(i).removeStudent(j);
	            				}
	            			}
            			}
            		}
            		
            		for (int i = 0; i < studentUser.size(); i++) {
            			if (comboBox2.getValue().equals(studentUser.get(i).getName())) {
            				for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {
            					if (comboBox.getValue().equals(studentUser.get(i).getIthClassName(j))) {
            						studentUser.get(i).setClassGrade(j, -1.0);
            					}
            				}
            			}
            		}
            		
            		removeStudentLog.setVisible(true);
            		comboBox2.setDisable(true);
                    removeStudentBtn.setDisable(true);
                    
            		removeStudentLog.setFill(Color.GREEN);
            		removeStudentLog.setText("Student " + comboBox2.getValue() + " Removed");
	                
            		comboBox.getSelectionModel().selectFirst();
            		comboBox2.getSelectionModel().selectFirst();
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("Remove Student From Class");
        stage.setScene(scene);
        stage.show();
	}
	
	void setStudentGrades (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < teacherUser.size(); i++) {
        	if (Name.equals(teacherUser.get(i).getName())) {
	        	for (int j = 0; j < teacherUser.get(i).classNumber(); j++) {
        			comboBox.getItems().add(teacherUser.get(i).getIthClassName(j));
	        	}
        	}
        }
        grid.add(comboBox, 0, 0);
        
        ComboBox<String> comboBox2 = new ComboBox<String>();
        comboBox2.getItems().add("Not Selected");
        comboBox2.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox2.getSelectionModel().selectFirst();
        comboBox2.setDisable(true);
        grid.add(comboBox2, 0, 1);
		
        Button showStudentsBtn = new Button("Show Class Students");
        showStudentsBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(showStudentsBtn, 3, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 4, 0);
        
        final Text selectClassLog = new Text("Please Select Again");
        selectClassLog.setVisible(false);
        grid.add(selectClassLog, 1, 0);
        
        final Text selectStudentLog = new Text("Please Select Again");
        selectStudentLog.setVisible(false);
        grid.add(selectStudentLog, 0, 2);
        
        final Text setStudentGradeLog = new Text("Please Enter Valid Grade");
        setStudentGradeLog.setVisible(false);
        grid.add(setStudentGradeLog, 1, 2);
        
        Button setGradeBtn = new Button("Set Grade");
        setGradeBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        setGradeBtn.setDisable(true);
        grid.add(setGradeBtn, 3, 2);
        
        TextField gradeTextField = new TextField();
        gradeTextField.setMaxWidth(Double.POSITIVE_INFINITY);
        gradeTextField.setDisable(true);
        grid.add(gradeTextField, 1, 1);
        
        showStudentsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if (comboBox.getValue().equals("Not Selected")) {
            		selectClassLog.setFill(Color.RED);
            		selectClassLog.setVisible(true);
                    comboBox2.setDisable(true);
                    setGradeBtn.setDisable(true);
                    gradeTextField.setDisable(true);
                    selectStudentLog.setVisible(false);
                    setStudentGradeLog.setVisible(false);
            	}
            	else {
            		selectClassLog.setVisible(false);
            		comboBox2.setDisable(false);
            		setGradeBtn.setDisable(false);
            		gradeTextField.setDisable(false);
            		
            		for (int i = 0; i < clas.size(); i++) {
                    	if (comboBox.getValue().equals(clas.get(i).getClassName())) {
            	        	for (int j = 0; j < clas.get(i).classStudentsNumber(); j++) {
            	        		List<String> items = comboBox2.getItems();
            	        		boolean flag = true;
            	                for(String item : items){
            	                	if (item.toString().equals(clas.get(i).getIthClassStudent(j))) {
                	        			flag = false;
                	        		}
            	                }
            	                if (flag == true) {
	            	                comboBox2.getItems().add(clas.get(i).getIthClassStudent(j));
            	                }
            	        	}
                    	}
                    }
            		
            	}
            }
        });
        
        setGradeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if (comboBox2.getValue().equals("Not Selected")) {
            		selectStudentLog.setFill(Color.RED);
            		selectStudentLog.setText("Please Select Again");
            		selectStudentLog.setVisible(true);
            		setStudentGradeLog.setVisible(false);
            	}
            	else if ( gradeTextField.getText().equals("") || gradeTextField.getText().equals("-0") || (! isNumber(gradeTextField.getText())) || (Double.parseDouble(gradeTextField.getText()) < 0.0) || (Double.parseDouble(gradeTextField.getText())> 20.0) ) {
            		setStudentGradeLog.setFill(Color.RED);
            		selectStudentLog.setVisible(false);
            		setStudentGradeLog.setVisible(true);
            	}
            	else {
            		selectStudentLog.setVisible(false);
            		setStudentGradeLog.setVisible(false);
            		
            		for (int i = 0; i < studentUser.size(); i++) {
            			if (comboBox2.getValue().equals(studentUser.get(i).getName())) {
            				for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {
            					if (comboBox.getValue().equals(studentUser.get(i).getIthClassName(j))) {
            						studentUser.get(i).setClassGrade(j, Double.parseDouble(gradeTextField.getText()));
            					}
            				}
            			}
            		}
            		
            		selectStudentLog.setVisible(true);
            		comboBox2.setDisable(true);
            		setGradeBtn.setDisable(true);
                    gradeTextField.setDisable(true);
                    
                    selectStudentLog.setFill(Color.GREEN);
                    selectStudentLog.setText("Grade Is Set");
	                
            		comboBox.getSelectionModel().selectFirst();
            		comboBox2.getSelectionModel().selectFirst();
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("Set Student Grades");
        stage.setScene(scene);
        stage.show();
	}
	
	void seeAllOfferedClasses (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
                
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < clas.size(); i++) {
	        comboBox.getItems().add(clas.get(i).getClassName());
        }
        grid.add(comboBox, 0, 0);
        
        final Text selectClassLog = new Text("Please Select Again");
        selectClassLog.setVisible(false);
        grid.add(selectClassLog, 1, 0);
        
        Button showClassInformationBtn = new Button("Show Class Informations");
        showClassInformationBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(showClassInformationBtn, 2, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 3, 0);
        
        
        Label tmp = new Label("Teacher Name");
		grid.add(tmp, 0, 2);
		
		tmp = new Label("Time Day");
		grid.add(tmp, 1, 2);
		
		tmp = new Label("Time Hour");
		grid.add(tmp, 2, 2);
		
		tmp = new Label("Registered Students");
		grid.add(tmp, 3, 2);
		
		tmp = new Label("TEMPTEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 0, 3);
		tmp = new Label("TEMPTEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 1, 3);
		tmp = new Label("TEMPTEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 2, 3);
		tmp = new Label("TEMPTEXT2DELETE");
		tmp.setVisible(false);
		grid.add(tmp, 3, 3);
        
		showClassInformationBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	if (comboBox.getValue().equals("Not Selected")) {
            		selectClassLog.setFill(Color.RED);
            		selectClassLog.setText("Please Select Again");
            		selectClassLog.setVisible(true);
            	}
            	else {
            		selectClassLog.setVisible(false);
            		
        			for (int i = 0; i < 4; i++) {
            			grid.getChildren().remove(8);
            		}
            		
            		for (int i = 0; i < clas.size(); i++) {
            			if (comboBox.getValue().equals(clas.get(i).getClassName())) {
            				Label tmp = new Label(clas.get(i).getClassTeacherUsername());
            				grid.add(tmp, 0, 3);
            				
            				tmp = new Label(clas.get(i).getClassTimeDay());
            				grid.add(tmp, 1, 3);
            				
            				tmp = new Label(Integer.toString(clas.get(i).getClassTimeHour()));
            				grid.add(tmp, 2, 3);
            				
            				tmp = new Label(Integer.toString(clas.get(i).classStudentsNumber()));
            				grid.add(tmp, 3, 3);
            				
            				break;
            			}
            		}
            		
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("See All Offered Classes");
        stage.setScene(scene);
        stage.show();
	}
	
	void removeStudentClass (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < studentUser.size(); i++) {
	        if (Name.equals(studentUser.get(i).getName())) {
	        	for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {
	        		comboBox.getItems().add(studentUser.get(i).getIthClassName(j));
	        	}
	        }
        }
        grid.add(comboBox, 0, 0);
        
        final Text selectClassLog = new Text("Please Select Again");
        selectClassLog.setVisible(false);
        grid.add(selectClassLog, 1, 0);
        
        Button removeClassBtn = new Button("Remove Class");
        removeClassBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(removeClassBtn, 2, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 3, 0);
        
        removeClassBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	if (comboBox.getValue().equals("Not Selected")) {
            		selectClassLog.setFill(Color.RED);
            		selectClassLog.setText("Please Select Again");
            		selectClassLog.setVisible(true);
            	}
            	else {
            		selectClassLog.setVisible(false);
            		
            		for (int i = 0; i < studentUser.size(); i++) {
            			if (Name.equals(studentUser.get(i).getName())) {
            				for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {
            					if (comboBox.getValue().equals(studentUser.get(i).getIthClassName(j))) {
            						studentUser.get(i).removeClass(j);
            						break;
            					}
            				}
            			}
            		}
            		
            		for (int i = 0; i < clas.size(); i++) {
            			for (int j = 0; j < clas.get(i).classStudentsNumber(); j++) {
            				if (Name.equals(clas.get(i).getIthClassStudent(j))) {
            					clas.get(i).removeStudent(j);
            					break;
            				}
            			}
            		}
            		
            		Object selectdObject = comboBox.getValue();
            		comboBox.getItems().remove(selectdObject);
            		
            		comboBox.getSelectionModel().selectFirst();
            		selectClassLog.setFill(Color.GREEN);
            		selectClassLog.setText("    Class Removed   ");
            		selectClassLog.setVisible(true);
            		
            	}
            	
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
		
		Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("Remove Student Class");
        stage.setScene(scene);
        stage.show();
	}
	
	void studentUnitSelection (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < clas.size(); i++) {
	        comboBox.getItems().add(clas.get(i).getClassName());
        }
        grid.add(comboBox, 0, 0);
        
        final Text selectClassLog = new Text("Class Already Taken");
        selectClassLog.setVisible(false);
        grid.add(selectClassLog, 1, 0);
        
        Button selectClassBtn = new Button("Take Class");
        selectClassBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(selectClassBtn, 2, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 3, 0);
        
		selectClassBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	if (comboBox.getValue().equals("Not Selected")) {
            		selectClassLog.setFill(Color.RED);
            		selectClassLog.setText("Please Select Again");
            		selectClassLog.setVisible(true);
            	}
            	else {
            		selectClassLog.setVisible(false);
            		
            		boolean classTaken = false;
            		int studentIndex = -1;
            		for (int i = 0; i < studentUser.size(); i++) {
            			if (Name.equals(studentUser.get(i).getName())) {
            				studentIndex = i;
	            			classTaken = false;
	            			for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {	
		            			if (comboBox.getValue().equals(studentUser.get(i).getIthClassName(j))) {
		            				classTaken = true;
		            			}
	            			}
            			}
            		}
            		
            		if (classTaken == true) {
            			selectClassLog.setFill(Color.RED);
                		selectClassLog.setText("Class Already Taken");
                		selectClassLog.setVisible(true);
            		}
            		else {
            			studentUser.get(studentIndex).addClassGrade(comboBox.getValue(), 0.0);
            			for (int i = 0; i < clas.size(); i++) {
            				if (comboBox.getValue().equals(clas.get(i).getClassName())) {
            					clas.get(i).addStudent(Name);
            				}
            			}
            			
            			comboBox.getSelectionModel().selectFirst();
            			selectClassLog.setFill(Color.GREEN);
                		selectClassLog.setText("    Class Added    ");
                		selectClassLog.setVisible(true);
            		}
            		
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
		
		Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("Unit Selection");
        stage.setScene(scene);
        stage.show();
	}
	
	void seeStudentClass (Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Not Selected");
        comboBox.setMaxWidth(Double.POSITIVE_INFINITY);
        comboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < studentUser.size(); i++) {
        	if (Name.equals(studentUser.get(i).getName())) {
	        	for (int j = 0; j < studentUser.get(i).ClassNumber(); j++) {
        			comboBox.getItems().add(studentUser.get(i).getIthClassName(j));
	        	}
        	}
        }
        grid.add(comboBox, 0, 0);
        
        Button showGrades = new Button("Show Class Info");
        showGrades.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(showGrades, 1, 0);
        
        Button backBtn = new Button("Back");
        grid.add(backBtn, 2, 0);
        
        final Text log = new Text();
        grid.add(log, 0, 1);
        
        Label classInfo = new Label("Teacher's Name:");
		grid.add(classInfo, 0, 2);
		
		classInfo = new Label("Day:");
		grid.add(classInfo, 1, 2);
		
		classInfo = new Label("Hour:");
		grid.add(classInfo, 2, 2);
        
		Label tmp = new Label("tmp");
		tmp.setVisible(false);
		grid.add(tmp, 0, 3);
		tmp = new Label("tmp");
		tmp.setVisible(false);
		grid.add(tmp, 1, 3);
		tmp = new Label("tmp");
		tmp.setVisible(false);
		grid.add(tmp, 2, 3);
        
        showGrades.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	int classNumber = -1;
            	for (int i = 0; i < clas.size(); i++) {
            		if (clas.get(i).getClassName().equals(comboBox.getValue())) {
            			classNumber = i;
            		}
            	}
            	
            	if (classNumber == -1) {
            		for (int i = 0; i < 3; i++) {
            			grid.getChildren().remove(7);
            		}
            		Label tmp = new Label("tmp");
            		tmp.setVisible(false);
            		grid.add(tmp, 0, 3);
            		tmp = new Label("tmp");
            		tmp.setVisible(false);
            		grid.add(tmp, 1, 3);
            		tmp = new Label("tmp");
            		tmp.setVisible(false);
            		grid.add(tmp, 2, 3);
            		
            		log.setFill(Color.RED);
                    log.setText("Please Select Again");
            	}
            	else {
            		log.setText("");
            		
            		for (int i = 0; i < 3; i++) {
            			grid.getChildren().remove(7);
            		}
        			
        			Label classInfo = new Label(clas.get(classNumber).getClassTeacherUsername());
        			grid.add(classInfo, 0, 3);
        			
        			classInfo = new Label(clas.get(classNumber).getClassTimeDay());
        			grid.add(classInfo, 1, 3);
        			
        			classInfo = new Label(Integer.toString(clas.get(classNumber).getClassTimeHour()));
        			grid.add(classInfo, 2, 3);
        			
            	}
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	panel (stage, Name, user);
            }
        });
        
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setTitle("See Student's Class Info");
        stage.setScene(scene);
        stage.show();
	}
	
	void panel(Stage stage, String Name, int user) {
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label usernameLabel = new Label("Name: " + Name + " - " + ((user == 1) ? ("Admin") : ((user == 2) ? ("Teacher") : ("Student"))) );
        grid.add(usernameLabel, 0, 0, 2, 1);
        
        Button loggoutBtn = new Button("Logout");
        loggoutBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        grid.add(loggoutBtn, 2, 0);
        
        
        Button newClassBtn = new Button("Add New Class");
        newClassBtn.setMaxWidth(Double.POSITIVE_INFINITY);
//        if (user == 1) {
//        	newClassBtn.setDisable(! adminUser.addNewClassAccess());
//        }
//        else if (user == 2) {
//        	newClassBtn.setDisable(! teacherUser.addNewClassAccess());
//        }
//        else {
//        	newClassBtn.setDisable(! studentUser.addNewClassAccess());
//        }
        newClassBtn.setDisable(! ((user == 1) ? (adminUser.addNewClassAccess()) : ( (user == 2) ? (teacherUser.get(0).addNewClassAccess()) : (studentUser.get(0).addNewClassAccess()) )) );
        grid.add(newClassBtn, 0, 3);
        
        Button newTeacherBtn = new Button("Add New Teacher");
        newTeacherBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        newTeacherBtn.setDisable(! ((user == 1) ? (adminUser.addNewTeacherAccess()) : ( (user == 2) ? (teacherUser.get(0).addNewTeacherAccess()) : (studentUser.get(0).addNewTeacherAccess()) )) );
        grid.add(newTeacherBtn, 1, 3);
        
        Button newStudentBtn = new Button("Add New Student");
        newStudentBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        newStudentBtn.setDisable(! ((user == 1) ? (adminUser.addNewStudentAccess()) : ( (user == 2) ? (teacherUser.get(0).addNewStudentAccess()) : (studentUser.get(0).addNewStudentAccess()) )) );
        grid.add(newStudentBtn, 2, 3);
        
        
        Button seeAllClassesBtn = new Button("See All Classes");
        seeAllClassesBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        seeAllClassesBtn.setDisable(! ((user == 1) ? (adminUser.seeAllClassesAccess()) : ( (user == 2) ? (teacherUser.get(0).seeAllClassesAccess()) : (studentUser.get(0).seeAllClassesAccess()) )) );
        grid.add(seeAllClassesBtn, 0, 4);
        
        Button seeClassInfoBtn = new Button("See Class Info");
        seeClassInfoBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        seeClassInfoBtn.setDisable(! ((user == 1) ? (adminUser.seeClassInfoAccess()) : ( (user == 2) ? (teacherUser.get(0).aseeClassInfoAccess()) : (studentUser.get(0).aseeClassInfoAccess()) )) );
        grid.add(seeClassInfoBtn, 1, 4);
        
        Button seeTeacherClassInfoBtn = new Button("See Teacher's Class Info");
        seeTeacherClassInfoBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        seeTeacherClassInfoBtn.setDisable(! ((user == 1) ? (adminUser.seeTeacherClassInfoAccess()) : ( (user == 2) ? (teacherUser.get(0).seeTeacherClassInfoAccess()) : (studentUser.get(0).seeTeacherClassInfoAccess()) )) );
        grid.add(seeTeacherClassInfoBtn, 2, 4);
        
        
        Button seeClassStudentsBtn = new Button("See Class Students");
        seeClassStudentsBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        seeClassStudentsBtn.setDisable(! ((user == 1) ? (adminUser.seeClassStudentAccess()) : ( (user == 2) ? (teacherUser.get(0).seeClassStudentAccess()) : (studentUser.get(0).seeClassStudentAccess()) )) );
        grid.add(seeClassStudentsBtn, 0, 5);

        Button removeStudentFromClassBtn = new Button("Remove Student From Class");
        removeStudentFromClassBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        removeStudentFromClassBtn.setDisable(! ((user == 1) ? (adminUser.removeStudentFromClassAccess()) : ( (user == 2) ? (teacherUser.get(0).removeStudentFromClassAccess()) : (studentUser.get(0).removeStudentFromClassAccess()) )) );
        grid.add(removeStudentFromClassBtn, 1, 5);

        Button setStudentGradesBtn = new Button("Set Student Grades");
        setStudentGradesBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        setStudentGradesBtn.setDisable(! ((user == 1) ? (adminUser.setStudentGradesAccess()) : ( (user == 2) ? (teacherUser.get(0).setStudentGradesAccess()) : (studentUser.get(0).setStudentGradesAccess()) )) );
        grid.add(setStudentGradesBtn, 2, 5);


        Button seeAllOfferedClassesBtn = new Button("See All Offered Classes");
        seeAllOfferedClassesBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        seeAllOfferedClassesBtn.setDisable(! ((user == 1) ? (adminUser.seeAllOfferedClassesAccess()) : ( (user == 2) ? (teacherUser.get(0).seeAllOfferedClassesAccess()) : (studentUser.get(0).seeAllOfferedClassesAccess()) )) );
        grid.add(seeAllOfferedClassesBtn, 0, 6);

        Button removeStudentClassBtn = new Button("Remove Student's Class");
        removeStudentClassBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        removeStudentClassBtn.setDisable(! ((user == 1) ? (adminUser.removeStudentClassAccess()) : ( (user == 2) ? (teacherUser.get(0).removeStudentClassAccess()) : (studentUser.get(0).removeStudentClassAccess()) )) );
        grid.add(removeStudentClassBtn, 1, 6);

        Button studentUnitSelectionBtn = new Button("Student Unit Selection");
        studentUnitSelectionBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        studentUnitSelectionBtn.setDisable(! ((user == 1) ? (adminUser.studentUnitSelectionAccess()) : ( (user == 2) ? (teacherUser.get(0).studentUnitSelectionAccess()) : (studentUser.get(0).studentUnitSelectionAccess()) )) );
        grid.add(studentUnitSelectionBtn, 2, 6);
        
        
        Button seeStudentClassInfoBtn = new Button("See Class Info");
        seeStudentClassInfoBtn.setMaxWidth(Double.POSITIVE_INFINITY);
        seeStudentClassInfoBtn.setDisable(! ((user == 1) ? (adminUser.seeStudentClassInfoAccess()) : ( (user == 2) ? (teacherUser.get(0).seeStudentClassInfoAccess()) : (studentUser.get(0).seeStudentClassInfoAccess()) )) );
  		grid.add(seeStudentClassInfoBtn, 0, 7);
        
        
        
        
        
        
        
        
        
        
        newClassBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	addNewClass(stage, Name, user);
            }
        });
        newTeacherBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	addNewTeacher(stage, Name, user);
            }
        });
        newStudentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	addNewStudent(stage, Name, user);
            }
        });
        seeAllClassesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	SeeAllClasses(stage, Name, user);
            }
        });
        seeClassInfoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	seeClassGrades(stage, Name, user);
            }
        });
        seeTeacherClassInfoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	seeTeacherClass(stage, Name, user);
            }
        });
        seeClassStudentsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	seeClassStudents(stage, Name, user);
            }
        });
        removeStudentFromClassBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	removeStudentFromClass(stage, Name, user);
            }
        });
        setStudentGradesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	setStudentGrades(stage, Name, user);
            }
        });
        seeAllOfferedClassesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	seeAllOfferedClasses(stage, Name, user);
            }
        });
        removeStudentClassBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	removeStudentClass(stage, Name, user);
            }
        });
        studentUnitSelectionBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	studentUnitSelection(stage, Name, user);
            }
        });
        seeStudentClassInfoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	seeStudentClass(stage, Name, user);
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        loggoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	StartProgram(stage);
            }
        });
        
        stage.setTitle("User Panel");
        Scene scene = new Scene(grid, panelWidth, panelHeight);
        stage.setScene(scene);
        stage.show();
	}
	
	public void StartProgram(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(50, 25, 25, 25));
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button loginBtn = new Button("Login");
        loginBtn.setDefaultButton(true);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginBtn);
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6, 2, 1);
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	if (userTextField.getText().equals(adminUser.getUsername())) {
            		if (pwBox.getText().equals(adminUser.getPassword())) {
            			panel (primaryStage, "Admin", 1);
            		}
            		else {
    	                actiontarget.setFill(Color.FIREBRICK);
    	                actiontarget.setText("Wrong Username or Password");
                	}
            	}
            	else {
            		boolean wrongUserPass = true;
            		for (int i = 0; i < teacherUser.size(); i++) {
            			if (userTextField.getText().equals(teacherUser.get(i).getUsername())) {
            				if (pwBox.getText().equals(teacherUser.get(i).getPassword())) {
            					panel (primaryStage, teacherUser.get(i).getName(), 2);
            					wrongUserPass = false;
            				}
            				else {
        		                actiontarget.setFill(Color.FIREBRICK);
        		                actiontarget.setText("Wrong Username or Password");
        		                wrongUserPass = true;
        	            	}
            			}
            		}
            		
            		for (int i = 0; i < studentUser.size(); i++) {
            			if (userTextField.getText().equals(studentUser.get(i).getUsername())) {
            				if (pwBox.getText().equals(studentUser.get(i).getPassword())) {
            					panel (primaryStage, studentUser.get(i).getName(), 3);
            					wrongUserPass = false;
            				}
            				else {
        		                actiontarget.setFill(Color.FIREBRICK);
        		                actiontarget.setText("Wrong Username or Password");
        		                wrongUserPass = true;
        	            	}
            			}
            		}
            		
            		if (wrongUserPass == true) {
            			actiontarget.setFill(Color.FIREBRICK);
		                actiontarget.setText("Wrong Username or Password");
            		}
            	}
            }
        });
        
        Scene scene = new Scene(grid, loginWidth, loginHeight);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		addDefaultClasses();
		
		StartProgram(primaryStage);
    }
	
	void addDefaultClasses () {
		
		Clas tempClass1 = new Clas();
		Clas tempClass2 = new Clas();
		Clas tempClass3 = new Clas();
		Clas tempClass4 = new Clas();
		
		Teacher tempTeacher1 = new Teacher();
		Teacher tempTeacher2 = new Teacher();
		
		Student tempStudent1 = new Student();
		Student tempStudent2 = new Student();
		
		tempClass1.addClass("Dini", "783921", "SeShanbe", 14);
		tempClass1.addStudent("Saye maleki");
		tempClass1.addStudent("Reza mohammadi");
		tempClass2.addClass("Varzesh", "783921", "YekShanbe", 16);
		tempClass2.addStudent("Saye maleki");
		tempClass2.addStudent("Reza mohammadi");
		tempClass3.addClass("Riazi 1", "243156", "Shanbe", 8);
		tempClass3.addStudent("Saye maleki");
		tempClass3.addStudent("Reza mohammadi");
		tempClass4.addClass("Moadelat", "243156", "Jome", 10);
		tempClass4.addStudent("Saye maleki");
		tempClass4.addStudent("Reza mohammadi");
		clas.add(tempClass1);
		clas.add(tempClass2);
		clas.add(tempClass3);
		clas.add(tempClass4);
		
		tempTeacher1.addTeacher("Alireza rahmani", "783921", "123", 22);
		tempTeacher1.addClass("Riazi 1", "Shanbe", 8);
		tempTeacher2.addTeacher("Somaye taban", "243156", "456", 22);
		tempTeacher2.addClass("Moadelat", "Jome", 10);
		teacherUser.add(tempTeacher1);
		teacherUser.add(tempTeacher2);
		
		tempStudent1.addStudent("Saye maleki", "96463147", "789", 33);
		tempStudent1.addClassGrade("Dini", 10.0);
		tempStudent1.addClassGrade("Varzesh", 19.25);
		tempStudent1.addClassGrade("Riazi 1", 12.0);
		tempStudent1.addClassGrade("Moadelat", 8.0);
		tempStudent2.addStudent("Reza mohammadi", "96463145", "101", 1);
		tempStudent2.addClassGrade("Dini", 20.0);
		tempStudent2.addClassGrade("Varzesh", 17.0);
		tempStudent2.addClassGrade("Riazi 1", 18.50);
		tempStudent2.addClassGrade("Moadelat", 14.0);
		studentUser.add(tempStudent1);
		studentUser.add(tempStudent2);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
