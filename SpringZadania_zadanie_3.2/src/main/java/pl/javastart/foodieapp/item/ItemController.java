package pl.javastart.foodieapp.item;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {

	private ItemRepository itemRepository;

	@Autowired
	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@GetMapping("/danie/{name}")
	public String getItem(@PathVariable String name, Model model) {
		Optional<Item> item = itemRepository.findByNameIgnoreCase(name.replaceAll("-", " "));// pobiera item z db
		item.ifPresent(it -> model.addAttribute("item", it));// sprawdza czy istnieje item
		// jesli tak - dla tego obiektu dodaje atrybut it o nazwie "item"
		return item.map(it -> "item").orElse("redirect:/");
		// jesli item istnieje - zwraca "item"
		// jesli nie - zwraca "redirect:/"
	}
}
