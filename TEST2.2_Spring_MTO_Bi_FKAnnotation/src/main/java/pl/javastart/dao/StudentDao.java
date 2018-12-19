package pl.javastart.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Student;

@Repository
@Transactional
public class StudentDao {

	private EntityManager entityManager;

	@Autowired
	public StudentDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Student Student) {
		entityManager.persist(Student);
	}

	public Student get(Long id) {
		Student Student = entityManager.find(Student.class, id);
		return Student;
	}

	public void update(Student Student) {
		entityManager.merge(Student);
	}

	public void delete(Student Student) {
		entityManager.remove(Student);
	}

}
