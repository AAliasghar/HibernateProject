package com.simplilearn.learnacademy;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.learneracademy.anno.utill.AHibernateUtill;

class ClassSubjectCleint {

	private static Scanner scanner = new Scanner(System.in);

	public static String student() {
		System.out.println("Please type Student Name: ");
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
		student();
		subject();
		teacher();
		className();
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

			System.out.println(" Save the data Student");
			Subject subject = new Subject(subject());
			session.save(subject);
			// session.save(subject());
			System.out.println(" Save the data subject");
			Teachers teachers = new Teachers(teacher());
			session.save(teachers);
			System.out.println(" Save the data teacher");

			Class className = new Class(className());
			System.out.println(" Save the data class");
			session.save(className);
			Student student = new Student(student());
			session.save(student);
			// All Subject belongs to same Class

			subject.setClasses(className);

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
