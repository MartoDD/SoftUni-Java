package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationToolImpl implements ValidationTool{

private final Validator validator;

    public ValidationToolImpl() {
        validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
