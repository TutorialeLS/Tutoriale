package pl.javastart.category;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

	private CategoryService categoryService;
	private Scanner scanner;

	@Autowired
	public CategoryController(CategoryService categoryService, Scanner scanner) {
		this.categoryService = categoryService;
		this.scanner = scanner;
	}


	public void createCategory() {
		Category category = new Category();
		categoryService.create(readCategory(category));
	}

	public void removeCategory() {
		System.out.println("Podaj kategorię do usunięcia: ");
		Long id = scanner.nextLong();
		scanner.nextLine();
		categoryService.remove(id);
	}

	private Category readCategory(Category category) {
		System.out.println("Podaj nazwę kategorii:");
		category.setName(scanner.nextLine());
		System.out.println("Podaj opis kategorii:");
		category.setDescription(scanner.nextLine());
		return category;

	}

}
