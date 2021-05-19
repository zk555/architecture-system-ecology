package cn.jdl.ecologyy.pay.service;

import cn.jdl.ecology.api.base.ReqT;
import cn.jdl.ecology.api.base.ResT;
import cn.jdl.ecology.api.pay.constant.PayCodeMessage;
import cn.jdl.ecology.api.pay.exception.PayException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-19 16:36
 **/
@Slf4j
public abstract class BaseService<P, D> implements Service<P, D> {

    /**
     * 执行服务
     *
     * @param request request
     * @return Response
     */
    @Override
    public ResT<D> service(ReqT<P> request) {
        /*
         * 0. 初始化响应
         */
        String code;
        String message;
        String trace = request.getSysTraceNo();
        D data;
        ResT<D> response = new ResT<>();
        response.setSysTraceNo(trace);
        try {
            /*
             * 1. 执行业务处理
             */
            data = execute(request);
            /*
             * 2. 设置响应参数
             */
            code = PayCodeMessage.SUCCESS.code;
            message = PayCodeMessage.SUCCESS.message;
            /*
             * 3. 捕获异常
             */
        } catch (Exception e) {
            data = exception(request, e);
            if (e instanceof PayException) {
                PayException exception = (PayException) e;
                code = exception.getCode();
                message = exception.getMessage();
            } else {
                code = PayCodeMessage.ERROR.code;
                message = e.getMessage();
            }
        }
        /*
         * 5. 响应
         */
        response.setProcCode(code);
        response.setProcDesc(message);
        response.setMessage(data);
        return response;
    }

    /**
     * 执行业务处理
     * 注意事务
     *
     * @param request Request
     * @return D
     * @throws PayException e
     */
    public abstract D execute(ReqT<P> request) throws PayException;

    /**
     * 业务处理发生异常时的处理
     * 按需重写
     *
     * @param request Request
     * @param e       Exception
     * @return D
     */
    public D exception(ReqT<P> request, Exception e) {
        if (e instanceof PayException) {
            log.error(((PayException) e).getCode(), e);
        } else {
            log.error(PayCodeMessage.ERROR.code, e);
        }
        return null;
    }

}