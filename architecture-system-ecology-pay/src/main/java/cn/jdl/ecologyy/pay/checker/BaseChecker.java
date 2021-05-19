package cn.jdl.ecologyy.pay.checker;

import cn.jdl.ecology.api.base.ReqT;
import cn.jdl.ecology.api.pay.constant.PayCodeMessage;
import cn.jdl.ecology.api.pay.exception.PayException;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 校验执行器：基础校验执行器
 *
 * @author zhaokai
 */
public abstract class BaseChecker<P> implements Checker<P> {

    /**
     * 此处使用 spring 容器提供的 Validator 组件
     * 不建议使用 Validation.buildDefaultValidatorFactory().getValidator();
     * Validation 在某些环境下，需要调节复杂的 maven 依赖关系和 jar 包版本
     */
    @Resource
    private Validator validator;

    /**
     * 使用 Validator 校验参数
     *
     * @param request ReqT
     * @throws PayException e
     */
    @Override
    public void checker(ReqT<P> request) throws PayException {
        /*
         * 0. 获取 Validator 组件的实例
         * 使用 spring 容器提供的组件替代的 ValidatorFactory 工厂模式生产实例
         */
        /// Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        /*
         * 1. 定义 List<string> 用于收集校验信息
         */
        List<String> messageList = new ArrayList<>();
        /*
         * 2. 校验 Request
         */
        Set<ConstraintViolation<ReqT>> constraintViolationSet = validator.validate(request);
        for (ConstraintViolation constraintViolation : constraintViolationSet) {
            messageList.add("[" + constraintViolation.getPropertyPath()+ "] " + constraintViolation.getMessage());
        }
        /*
         * 3. 校验 param
         */
        P param = request.getParams();
        Set<ConstraintViolation<P>> constraintViolations = validator.validate(param);
        for (ConstraintViolation constraintViolation : constraintViolations) {
            messageList.add("[" + constraintViolation.getPropertyPath()+ "] " + constraintViolation.getMessage());
        }
        /*
         * 4. 如果校验得到了异常信息，抛出异常
         */
        if (messageList.size() > 0) {
            throw new PayException(PayCodeMessage.REQUEST_PARAM_ERROR.code, String.join(";\n", messageList));
        }
        /*
         * 5. 对业务参数进行其他具体校验
         */
        execute(param);
    }

    /**
     * 校验业务参数
     * 子类根据自己的业务需求进行实现
     *
     * @param param P
     * @throws PayException e
     */
    public abstract void execute(P param) throws PayException;

}
