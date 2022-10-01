package com.simplilearn.learnacademy;

import javax.persistence.*;


@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	
	
	@ManyToOne
	@JoinColumn(name = "classId", referencedColumnName = "CLASS_ID")
	Class classes;


	
	
	public Student( ) {
		super();
	

	}
	
	
	
	public Student( String studentName) {
		super();
		this.studentName = studentName;

	}
	
	
	public Student( String studentName, Class classes) {
		super();
		this.studentName = studentName;
		this.classes = classes;
	}
	
	

	public Student(int studentId, String studentName, Class classes) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.classes = classes;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public Class getClasses() {
		return classes;
	}



	public void setClasses(Class classes) {
		this.classes = classes;
	}



	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", classes=" + classes + "]";
	}
	
	
	
	

}
