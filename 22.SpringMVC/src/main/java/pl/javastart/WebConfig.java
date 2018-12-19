package pl.javastart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    
    @Bean
    public ViewResolver viewResolver() {//klasa pzowalajaca na odnalezienie odpowiedniego widku w Spring MVC
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //podstawowa implementacja interfejsu ViewResolver wynikowa nazwa to polaczenie:
        //prefiksu, nazwy zwrocnej przez metode kontrolera i suffiksu/
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    //metoda ktora sprawia, ze wszystkie pliki statyczne sa podawane u¿ytkownikowi z wykorzystaniem
    //domyslnych mechanizmow serwera - z pominieciem Springa
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}