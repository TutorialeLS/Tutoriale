package pl.javastart.constraint;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

import pl.javastart.common.Lang;
import pl.javastart.validator.BadWordValidator;

@Documented
@Constraint(validatedBy = { BadWordValidator.class })
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface NotBadWord {
	//definiuje wiadomosc przy zlamaniu ograniczenia
    String message() default "You cannot use bad words in your messages";
    //okresla grupy (mozliwosc wlaczenia pewnych ograniczen w konkretnych etapach walidacji)
    Class<?>[] groups() default {};
    //pozwala przekazac dodatkowe wartosci w ograniczeniu
    Class<? extends Payload>[] payload() default {};

    Lang[] lang() default Lang.PL;
}