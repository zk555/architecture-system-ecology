package cn.jdl.ecologyy.pay.controller;

import cn.jdl.ecology.api.base.ReqT;
import cn.jdl.ecology.api.base.ResT;
import cn.jdl.ecology.api.pay.constant.PayCodeMessage;
import cn.jdl.ecology.api.pay.enums.PayApiCode;
import cn.jdl.ecology.api.pay.exception.PayException;
import cn.jdl.ecologyy.pay.checker.Checker;
import cn.jdl.ecologyy.pay.component.Actuator;
import cn.jdl.ecologyy.pay.config.AppConfig;
import cn.jdl.ecologyy.pay.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 基础控制器
 * @create 2021-05-19 11:59
 **/
@Slf4j
public class BaseController<P,D> {

    /**
     * ObjectMapper
     */
    @Resource
    private ObjectMapper objectMapper;

    /**
     * AppConfig
     */
    @Resource
    private AppConfig appConfig;

    /**
     * 业务执行器
     *
     * @param apiCode HelloWorldApiCode
     * @param request Request
     * @return Mono
     */
    @SuppressWarnings("unchecked")
    public Mono<ResT<D>> actuator(PayApiCode apiCode, ReqT<P> request) {
        /*
         * 0. 定义响应
         */
        String system = appConfig.getSystem();
        ResT<D> response = new ResT<>();
        try {
            /*
             * 1. 判断是否存在此项服务
             */
            if (null == apiCode) {
                throw new PayException(PayCodeMessage.NO_SUCH_SERVICE);
            }
            String checkerCode = apiCode.code;
            String serviceCode = apiCode.code;
            /*
             * 2. 判断当前服务是否已经被禁用
             * 可以利用配置中心的参数配置的动态刷新机制，动态关闭某些 API 接口
             */
            String[] serviceDisabled = appConfig.getApiDisabled();
            if (Arrays.asList(serviceDisabled).contains(serviceCode)) {
                throw new PayException(PayCodeMessage.SERVICE_DISABLED);
            }
            /*
             * 3. 判断当前服务的校验执行器是否可用
             */
            Checker checker = Actuator.getChecker(checkerCode);
            if (null == checker) {
                throw new PayException(PayCodeMessage.CHECKER_UNAVAILABLE);
            }
            /*
             * 4. 判断当前服务的业务执行器是否可用
             */
            Service service = Actuator.getService(serviceCode);
            if (null == service) {
                throw new PayException(PayCodeMessage.SERVICE_UNAVAILABLE);
            }
            /*
             * 6. 请求参数为空则抛出异常
             */
            if (null == request) {
                throw new PayException(PayCodeMessage.REQUEST_PARAM_NOT_NULL);
            }
            /*
             * 7. 日志记录请求数据
             */
            /*
             * 8. 链路追踪 ID
             */
            response.setSysTraceNo(TraceContext.traceId());
            /*
             * 9. 获取校验执行器，并校验请求参数
             */
            checker.checker(request);
            /*
             * 10. 获取服务执行器，并执行服务
             */
            response = service.service(request);
            /*
             * 11. 捕获异常，返回错误响应，并记录日志
             */
        } catch (Exception e) {
            if (e instanceof PayException) {
                log.error("业务异常：", e);
                PayException exception = (PayException) e;
                response.setProcCode(exception.getCode());
                response.setProcDesc(exception.getMessage());
            } else {
                log.error("系统异常：", e);
                response.setProcCode(PayCodeMessage.ERROR.code);
                response.setProcDesc(PayCodeMessage.ERROR.message);
            }
        }
        /*
         * 12. 设置 sysCode
         */
        response.setSysCode(system);
        return Mono.just(response);
    }
}
