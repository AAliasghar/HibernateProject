package com.simplilearn.learnacademy;

import javax.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBJECT_ID")
	private int subjectId;

	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@ManyToOne
	@JoinColumn(name = "classId", referencedColumnName = "CLASS_ID")
	Class classes; /* BI Directional */
	
	@ManyToOne
	@JoinColumn(name = "teacherId", referencedColumnName = "TEACHER_ID")
	Teachers teachers;
	
	
	
	public Subject( ) {
		super();
	
	
	
	}
	public Subject( String subjectName ) {
		super();
		this.subjectName = subjectName;
	
	
	}
	
	public Subject( String subjectName, Class classes) {
		super();
		this.subjectName = subjectName;
		this.classes = classes;
	
	}
	public Subject(int subjectId, String subjectName, Class classes) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.classes = classes;
	
	}


	public Subject(int subjectId, String subjectName, Class classes, Teachers teachers) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.classes = classes;
		this.teachers = teachers;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Class getClasses() {
		return classes;
	}
	public void setClasses(Class classes) {
		this.classes = classes;
	}
	public Teachers getTeachers() {
		return teachers;
	}
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", classes=" + classes
				+ ", teachers=" + teachers + "]";
	}

	
	
	

}
