package com.simplilearn.learnacademy;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Class")
public class Class{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASS_ID")
	private int classId;
	
	 

	@Column(name = "CLASS_NAME")
	private String className;
	

	@OneToMany(mappedBy = "classes")
	Set<Subject> subjects ;
	/*I want to make a relationship from Class to Subject*/
	
	@OneToMany(mappedBy = "classes")
	Set<Student> students ;
	/*I want to make a relationship from Class to Student*/
	
	@OneToMany(mappedBy = "classes")
	Set<Teachers> teachers ;
	
	
	public Class( ) {
		super();
		
		
		
	}
	
	public Class( String className) {
		super();
		this.className = className;
		
		
	}
	
	public Class( String className, Set<Subject> subjects) {
		super();
		this.className = className;
		this.subjects = subjects;
		
		
	}
	
	
	public Class( String className, Set<Subject> subjects, Set<Student> students) {
		super();
		
		this.className = className;
		this.subjects = subjects;
		this.students = students;
		
	}
	
	public Class( String className, Set<Subject> subjects, Set<Student> students, Set<Teachers> teachers) {
		super();
		
		this.className = className;
		this.subjects = subjects;
		this.students = students;
		this.teachers = teachers;
	}
	
	public Class(int classId, String className, Set<Subject> subjects, Set<Student> students, Set<Teachers> teachers) {
		super();
		this.classId = classId;
		this.className = className;
		this.subjects = subjects;
		this.students = students;
		this.teachers = teachers;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teachers> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + ", subjects=" + subjects + ", students="
				+ students + ", teachers=" + teachers + "]";
	}
	
	
	

}
