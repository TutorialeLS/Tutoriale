package pl.javastart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/secured")
	public String secured() {
		return "secured page";
	}
}
