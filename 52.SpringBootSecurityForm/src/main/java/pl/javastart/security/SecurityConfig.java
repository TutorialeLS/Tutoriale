package pl.javastart.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {       
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/").permitAll()
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/loginform")//adres strony logowania - przy probie logowania
	    //spring przejdzie pod wskazany adres - ADRES OBSLUGIWANY PRZEZ KONTROLLER, KTORY PRZESYLA WATEK
	            //do login_form.html
	            
	            .permitAll() //w przypadku braku tej metody do zalogowania bedzie wymagane zalogowanie 
	    //ktore wymaga zalogowania itd. po jej użyciu, spring zezwala wszystkim na logowanie, nie tylko zalogowanym
	            .loginProcessingUrl("/processlogin")//adres na ktory bedzie przeslany formularz logowania,
	            //FORMULARZ W PLIKU login_form.html
	             .permitAll()
	         .usernameParameter("user")
	         .passwordParameter("pass")
	         .and()
	     .logout()
	         .logoutUrl("/logmeout")
	             .logoutSuccessUrl("/")
	             .permitAll();
         }
    
}