package com.spring.jdbc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;
import com.spring.jdbc.noxml.JdbcConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Jdbc Program Started");
		// spring jdbc => jdbctemplate
		// If want to use config.xml for bean defination and dependency injection (IOC
		// container) use context else use context2 if want no-xml
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/springjdbc/config.xml");
		ApplicationContext context2 = new AnnotationConfigApplicationContext(JdbcConfig.class);

		/*
		 * This way of inserting data is not recommended JdbcTemplate template =
		 * context.getBean("jdbcTemp", JdbcTemplate.class);
		 * 
		 * // Insert Query String query =
		 * "insert into student(id,name,city) values(?, ? , ?)";
		 * 
		 * // fire query int result = template.update(query, 223, "Gagan Shishdia",
		 * "Dadri"); System.out.println("number of records inserted " + result);
		 */
		StudentDao studentDao = context2.getBean("studentDao", StudentDao.class);

		// INSERT
		/*
		 * Student student = new Student(); student.setId(123);
		 * student.setName("Akshita"); student.setCity("Kushawali");
		 * 
		 * int result = studentDao.insert(student); System.out.println("Students added "
		 * + result);
		 */

		// UPDATE
		/*
		 * Student student = new Student(); student.setId(222);
		 * student.setName("Aadvik Thakur"); student.setCity("Delhi");
		 * 
		 * int result = studentDao.change(student);
		 * System.out.println("Students data changed " + result);
		 */

		// DELETE
		/*
		 * Student student = new Student();
		 * 
		 * int result = studentDao.delete(223); System.out.println("Row Deleted " +
		 * result);
		 */

		Student student = studentDao.getStudent(123);
		System.out.println(student);

		List<Student> students = studentDao.getAllStudents();
		System.out.println(students);
		// OR
		System.out.println(
				"___________________________________________________________________________________________________________________________________________");
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
