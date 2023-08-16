package cn.jdl.ecology.validator;


import cn.jdl.ecology.anno.NotLessThanZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotLessThanZeroValidator implements ConstraintValidator<NotLessThanZero, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        if (value instanceof Number) {
            if (((Number) value).intValue() > 0) {
                return true;
            }
        }
        return false;
    }
}
