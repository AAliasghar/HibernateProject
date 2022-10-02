package com.simplilearn.learnacademy;



import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.learneracademy.anno.utill.AHibernateUtill;

class ClassSubjectCleint {

	private static Scanner scanner = new Scanner(System.in);

	public static String student() {
		System.out.println("Please type Number of Student Names: ");
		String studentName = scanner.next();
		return studentName;
	}

	public static String teacher() {
		System.out.println("Please type Teacher Name: ");
		String teacherName = scanner.next();
		return teacherName;
	}

	public static String subject() {
		System.out.println("Please type Subject Name: ");
		String subjectrName = scanner.next();

		return subjectrName;
	}

	public static String className() {
		System.out.println("Please type Class Name: ");
		String className = scanner.next();
		return className;
	} // This the assessment Screenshot
		// Aliasghar Asgharinia

	public static void main(String[] args) {
		
		Transaction tx = null;
		try {

			// 4. With the factory object open the session
			SessionFactory sf = AHibernateUtill.getSessionFactory();
			Session session = sf.openSession();
			System.out.println("4. With the factory object open the session");

			// 5. With the help of Session need to begin the transaction
			tx = session.beginTransaction();
			System.out.println("5. With the help of Session need to begin the transaction");

			// 6. Business Object

			
			Student student1 = new Student(student());
			Student student2 =new Student("StudentB");
			Student student3 =new Student("StudentC");
			Set<Student> students = new HashSet<Student>();
			students.add(student1);
			students.add(student2);
			students.add(student3);
			session.save(student1);
			session.save(student2);
			session.save(student3);			
			System.out.println(" Save the data Student");
			Subject subject1 = new Subject(subject());
			Set<Subject> subject = new HashSet<Subject>();
			subject.add(subject1);
			session.save(subject1);
			// session.save(subject());
			System.out.println(" Save the data subject");
			Teachers teacher1 = new Teachers(teacher());
			Set<Teachers> teachers = new HashSet<Teachers>();
			session.save(teacher1);
			System.out.println(" Save the data teacher");

			Class className = new Class(className());
			System.out.println(" Save the data class");
			session.save(className);
			
			// All Subject belongs to same Class
			className.setStudents(students);
			className.setSubjects(subject);
			className.setTeachers(teachers);
			student1.setClasses(className);
			subject1.setClasses(className);
			teacher1.setClasses(className);
			subject1.setTeachers(teacher1);

			tx.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}

}
