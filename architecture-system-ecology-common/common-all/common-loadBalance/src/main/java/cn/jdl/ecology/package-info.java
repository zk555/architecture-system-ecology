/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/2 9:38
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
package cn.jdl.ecology;

/**
 *功能：
 * `@LoadBalanced` `RestTemplate` 限制
 *
 * * 面向 URL 组件，必须依赖于 主机+端口 + URI
 * * 并非接口编程（Spring Cloud中，需要理解应用名称+ 服务 URI）
 *
 * `RestTemplate` 不依赖于服务接口，仅关注 REST 响应内容
 *
 *
 *  lbRestTemplate.getForObject("http://" + serviceName + "/say?message=" + message, String.class);
 */