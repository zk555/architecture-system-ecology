package cn.jdl.ecologyy.pay.service;

import cn.jdl.ecology.api.base.ReqT;
import cn.jdl.ecology.api.base.ResT;

/**
 * 服务执行器
 *
 * @author zhaokai
 */
public interface Service<P, D> {

    /**
     * 业务处理
     *
     * @param request Request
     * @return Response
     */
    ResT<D> service(ReqT<P> request);

}
