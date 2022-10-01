package com.simplilearn.learnacademy;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Teachers")
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEACHER_ID")
	private int teacherId;

	@Column(name = "TEACHER_NAME")
	private String teacherName;

	@OneToMany(mappedBy = "teachers")
	Set<Subject> subjects;

	@ManyToOne
	@JoinColumn(name = "classId", referencedColumnName = "CLASS_ID")
	Class classes;

	public Teachers() {
		super();

	}

	public Teachers(String teacherName) {
		super();

		this.teacherName = teacherName;

	}

	public Teachers(String teacherName, Set<Subject> subjects) {
		super();

		this.teacherName = teacherName;
		this.subjects = subjects;

	}

	public Teachers(String teacherName, Set<Subject> subjects, Class classes) {
		super();

		this.teacherName = teacherName;
		this.subjects = subjects;
		this.classes = classes;
	}

	public Teachers(int teacherId, String teacherName, Set<Subject> subjects, Class classes) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.subjects = subjects;
		this.classes = classes;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Teachers [teacherId=" + teacherId + ", teacherName=" + teacherName + ", subjects=" + subjects
				+ ", classes=" + classes + "]";
	}

	
	
	
}
