package pl.javastart.constraint;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.javastart.validator.LongEnoughValidator;


@Documented
@Constraint(validatedBy = LongEnoughValidator.class)
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface LongEnough {
    String message() default "{pl.javastart.constraint.LongEnough.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int length() default 1;
}