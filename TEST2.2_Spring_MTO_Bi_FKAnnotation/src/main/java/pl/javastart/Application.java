package pl.javastart;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.StudentDao;
import pl.javastart.dao.UniversityDao;
import pl.javastart.model.Student;
import pl.javastart.model.University;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		Student student1 = new Student("Sam", "Disilva", "Maths");
		Student student2 = new Student("Joshua", "Brill", "Science");
		Student student3 = new Student("Peter", "Pan", "Physics");

		University university = new University("CAMBRIDGE", "ENGLAND");

		StudentDao clientDao = ctx.getBean(StudentDao.class);
		UniversityDao orderDao = ctx.getBean(UniversityDao.class);

		student1.setUniversity(university);
		student2.setUniversity(university);
		student3.setUniversity(university);
		university.setStudents(Arrays.asList(student1,student2,student3));
		clientDao.save(student1);
		//orderDao.save(university);

		System.out.println(clientDao.get(2L));
		
		ctx.close();
	}
}
