package pl.javastart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.javastart.constraint.Divided;
import pl.javastart.constraint.LongEnough;

public class LongEnoughValidator implements ConstraintValidator<LongEnough, String> {

	private int lth;

	@Override
	public void initialize(LongEnough annotation) {
		lth = annotation.length();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (value.length() >= lth);
	}

}
