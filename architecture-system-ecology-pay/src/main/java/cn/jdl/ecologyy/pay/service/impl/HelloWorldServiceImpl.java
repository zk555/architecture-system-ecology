package cn.jdl.ecologyy.pay.service.impl;

import cn.jdl.ecology.api.base.ReqT;
import cn.jdl.ecology.api.pay.enums.PayApiCode;
import cn.jdl.ecology.api.pay.exception.PayException;
import cn.jdl.ecology.api.pay.request.HelloWorldParam;
import cn.jdl.ecology.api.pay.response.HelloWorldMessage;
import cn.jdl.ecologyy.pay.annotation.ServiceCode;
import cn.jdl.ecologyy.pay.constant.PayConstant;
import cn.jdl.ecologyy.pay.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-19 17:05
 **/
@Slf4j
@Service
@ServiceCode(PayApiCode._ORDER_000001)
public class HelloWorldServiceImpl extends BaseService<HelloWorldParam, HelloWorldMessage> {
    @Override
    public HelloWorldMessage execute(ReqT<HelloWorldParam> request) throws PayException {
        HelloWorldParam param = request.getParams();
        Integer id = param.getId();
        HelloWorldMessage data = new HelloWorldMessage();
        data.setHelloWorld(PayConstant.HELLO_WORLD + " " + id);
        return data;
    }
}
