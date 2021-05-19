package cn.jdl.ecologyy.pay.checker;

import cn.jdl.ecology.api.base.ReqT;
import cn.jdl.ecology.api.pay.exception.PayException;

/**
 * 校验执行器
 * 使用 hibernate-validator 组件来校验 Request 的各项参数
 * 参考 JSR-303/JSR-349
 *
 * @author zhaokai
 */
public interface Checker<P> {

    /**
     * 校验公共参数与业务参数
     *
     * @param request ReqT
     * @throws PayException e
     */
    void checker(ReqT<P> request) throws PayException;

}
