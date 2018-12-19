package pl.javastart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.javastart.model.Person;

@Component
public class PersonValidator implements Validator {
    
    private static final int MIN_AGE = 1;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        checkEmail(person, errors);
        checkLastName(person,errors);
        checkAge(person, errors);
    }
    
    private void checkEmail(Person person, Errors errors) {
        if(person.getEmail() == null)
            errors.rejectValue("email", "required.email");
        else if(!person.getEmail().contains("@"))
            errors.rejectValue("email", "invalid.email");
    }
    private void checkLastName(Person person, Errors errors) {
    	if(person.getLastName()==null)
    		errors.rejectValue("lastName", "required.lastName");
    }

    private void checkAge(Person person, Errors errors) {
        if(person.getAge() < PersonValidator.MIN_AGE) {
            errors.rejectValue("age", "invalid.age");
        }
    }
}