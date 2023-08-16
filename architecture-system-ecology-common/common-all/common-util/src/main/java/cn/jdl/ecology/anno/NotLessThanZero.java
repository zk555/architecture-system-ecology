package cn.jdl.ecology.anno;


import cn.jdl.ecology.validator.NotLessThanZeroValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {NotLessThanZeroValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotLessThanZero {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
