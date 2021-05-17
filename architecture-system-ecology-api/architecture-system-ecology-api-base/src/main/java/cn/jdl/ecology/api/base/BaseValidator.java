package cn.jdl.ecology.api.base;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Mr zhangzhw
 * @Title: BaseValidator
 * @ProjectName paas
 * @Description: 校验工具类
 * @date 2019-04-22 14:44
 */
public class BaseValidator {

    private BaseValidator(){}

    /**
     * java bean 数据校验
     * 参数符合要求,返回 null,否则返回错误原因(不包含参数名)
     *
     * @param target 目标 bean
     * @param <T>
     * @return
     */
    public static <T> String validate(T target){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(target);
        Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
        String resMsg=null;
        while (iterator.hasNext()) {
            ConstraintViolation<T> error = iterator.next();
            resMsg=error.getMessage();
        }
        return  resMsg;
    }

    /**
     * java bean 数据校验
     * 参数符合要求,返回 null,否则返回错误原因(包含参数名)
     *
     * @param target 目标 bean
     * @param <T>
     * @return
     */
    public static <T> String validateWithParameter(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(target);
        Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
        String resMsg=null;
        while (iterator.hasNext()) {
            ConstraintViolation<T> error = iterator.next();
            StringBuilder buffer = new StringBuilder().append("[")
                    .append(error.getPropertyPath().toString()).append("]")
                    .append(error.getMessage());
            resMsg = buffer.toString();
        }
        return resMsg;
    }
}
