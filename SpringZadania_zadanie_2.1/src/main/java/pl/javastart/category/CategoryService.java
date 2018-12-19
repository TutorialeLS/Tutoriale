package pl.javastart.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public void create(Category category) {
		try {
			categoryRepository.save(category);
		} catch (DataIntegrityViolationException e) {
			System.err.println("Nie dodano kategorii, możliwe, że nazwa jest duplikatem.");
		}
	}

	public void remove(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		category.ifPresent(categoryRepository::delete);
	}

	public Optional<Category> findById(long categoryId) {
		return categoryRepository.findById(categoryId);
	}

	public Optional<Category> readByName(String categoryName) {
		return categoryRepository.findByName(categoryName);
	}

}
