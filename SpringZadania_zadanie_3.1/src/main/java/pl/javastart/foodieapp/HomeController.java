package pl.javastart.foodieapp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.foodieapp.item.Item;
import pl.javastart.foodieapp.item.ItemRepository;

@Controller
public class HomeController {

    private ItemRepository itemRepository;

    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = (List<Item>) itemRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }

}