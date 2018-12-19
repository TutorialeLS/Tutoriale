package pl.javastart.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.University;
@Repository
@Transactional
public class UniversityDao {
	private EntityManager entityManager;

	@Autowired
	public UniversityDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(University University) {
		entityManager.persist(University);
	}

	public University get(Long id) {
		University University = entityManager.find(University.class, id);
		return University;
	}

	public void update(University University) {
		entityManager.merge(University);
	}

	public void delete(University University) {
		entityManager.remove(University);
	}
}
