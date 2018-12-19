package pl.javastart.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.javastart.model.Person;
import pl.javastart.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository repository;
    
    @Autowired
    public PersonService(PersonRepository personRepository) {
        repository = personRepository;
    }
    //walidacja danych powinna odbywac sie na poziomie serwisu
    //w przypadku walidacji w klasie repozytorium zostanie rzucony
    //wyjatek javax.persistence.RollbackException
    //spowodowany rzuceniem wyjatku ConstraintViolationException
    //ktory oznaczy transakcje jako "rollback" (do odrzucenia)
    //w trakcie jej trwania, nastepnie Hibernate sprobuje dokonac commitu
    //nieprawidlowej transakcji
    
    //przy sprawdzeniu ConstraintViolationException w klasie serwisu,
    //zostanie on rzucony PRZED wykonaniem transakcji
    public void add(Person person) {
        try {
            repository.add(person);
        } catch(ConstraintViolationException e) {
            Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
            errors.forEach(err -> System.err.println(
                    err.getPropertyPath() + " " +
                    err.getInvalidValue() + " " + 
                    err.getMessage()));
        }
    }
}