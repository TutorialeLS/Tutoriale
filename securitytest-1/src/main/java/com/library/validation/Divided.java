package com.library.validation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.*;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy=NumberDivideValidator.class)
@Target({METHOD, FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)

public @interface Divided {
	String message() default "Number has to be divided by {0}";
	
	int by() default 1;

}
