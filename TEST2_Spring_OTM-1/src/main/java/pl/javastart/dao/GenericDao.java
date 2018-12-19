package pl.javastart.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDao<T, K> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> type;

	@SuppressWarnings("unchecked")
	GenericDao() {
		type = (Class<T>) ((ParameterizedType) this.getClass()// okreslenie typu encji
				.getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println(type);

	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T get(K key) {
		T find = entityManager.find(type, key);
		return find;
	}

	public void saveList(List<T> entity) {
		for (T t : entity) {
			entityManager.persist(t);
		}

	}
}