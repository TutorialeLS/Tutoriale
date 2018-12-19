package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//mniej szczegó³owa klasa @Component
public class HomeController {

    @RequestMapping("/")//obsluguje wszystkie zadania przychodzace na strone glowna
    public String home() {
        return "home";//przechodzi do widoku o wskazanej nazwie
        //u¿ycie resolvera pozawala na pominiecie ".jsp"
    }
    
}