package cn.jdl.ecologyy.pay.controller;

import cn.jdl.ecology.api.base.ReqT;
import cn.jdl.ecology.api.base.ResT;
import cn.jdl.ecology.api.pay.constant.PayServiceCodeConstant;
import cn.jdl.ecology.api.pay.enums.PayApiCode;
import cn.jdl.ecology.api.pay.request.HelloWorldParam;
import cn.jdl.ecology.api.pay.response.HelloWorldMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 继承 BaseController，调用执行器
 * @create 2021-05-19 11:58
 **/
@Slf4j
@RestController
@RequestMapping(path = "/api")
@SuppressWarnings("unchecked")
public class ApiController extends BaseController{

    /**
     * @param request Request
     * @return Mono
     */
    @RequestMapping(value = PayServiceCodeConstant._0000001, method = RequestMethod.POST)
    public Mono<ResT<HelloWorldMessage>> helloWorld( @RequestBody ReqT<HelloWorldParam> request) {
        return actuator(PayApiCode.get(PayServiceCodeConstant._0000001), request);
    }

//    @RequestMapping("/gateData")
//    @ResponseBody
//    public String  getData(){
//
//        return "String";
//    }
}
