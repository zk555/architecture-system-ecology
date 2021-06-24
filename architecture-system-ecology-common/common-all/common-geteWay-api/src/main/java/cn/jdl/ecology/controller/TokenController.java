package cn.jdl.ecology.controller;

import cn.jdl.ecology.api.ApiResponse;
import cn.jdl.ecology.entity.AppInfo;
import cn.jdl.ecology.entity.TokenInfo;
import cn.jdl.ecology.entity.UserInfo;
import cn.jdl.ecology.token.AccessToken;
import cn.jdl.ecology.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * 1.接口调用方(客户端)向接口提供方(服务器)申请接口调用账号，申请成功后，接口提供方会给接口调用方一个appId和一个key参数
 *
 * 2.客户端携带参数appId、timestamp、sign去调用服务器端的API token，其中sign=加密(appId + timestamp + key)
 *
 * 3.客户端拿着api_token 去访问不需要登录就能访问的接口
 *
 * 4.当访问用户需要登录的接口时，客户端跳转到登录页面，通过用户名和密码调用登录接口，登录接口会返回一个usertoken, 客户端拿着usertoken 去访问需要登录才能访问的接口
 *
 * 5.sign的作用是防止参数被篡改，客户端调用服务端时需要传递sign参数，服务器响应客户端时也可以返回一个sign用于客户度校验返回的值是否被非法篡改了。客户端传的sign和服务器端响应的sign算法可能会不同
 * @Author zhaokai108
 * @Date 2021/6/24 17:27
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Slf4j
@RestController
@RequestMapping("/api/token")
public class TokenController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 功能：
     *
     * @param appId     系统申请得APPID
     * @param timestamp 时间戳，是客户端调用接口时对应的当前时间戳，时间戳用于防止DoS攻击
     * @param sign      随机值，是客户端随机生成的值，作为参数传递过来，随机值的目的是增加sign签名的多变性
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/24 18:26
     */
    public ApiResponse<AccessToken> apiToken(String appId, @RequestHeader("timestamp") String timestamp, @RequestHeader("sign") String sign) {
        // 入参不能为空
        Assert.isTrue(!StringUtils.isEmpty(appId) && !StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(sign), "参数错误");

        //记录请求时间
        long requestInterval = System.currentTimeMillis() - Long.valueOf(timestamp);

        //判断是否请求过期
        Assert.isTrue(requestInterval < 5 * 60 * 1000, "请求过期，请重新请求");

        //根据appId查询数据库获取appSecret
        AppInfo appInfo = new AppInfo("1", "123456789");

        //校验签名
        String signString = timestamp + appId + appInfo.getKey();
        String signature = MD5Util.encode(signString);
        log.info(signature);
        Assert.isTrue(signature.equals(sign), "签名错误");

        //如果正确生成一个token保存到redis中，如果错误返回错误信息

        AccessToken accessToken = this.saveToken(0, appInfo, null);

        return ApiResponse.success(accessToken);

    }

    /**
     * 功能：申请token接口
     *
     * @param username 1
     * @param password 2
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/24 18:42
     */
    public ApiResponse<AccessToken> userToken(String username, String password) {
        // 根据用户名查询密码, 并比较密码(密码可以RSA加密一下)
        UserInfo userInfo = new UserInfo(username, "81255cb0dca1a5f304328a70ac85dcbd", "111111");
        String pwd = password + userInfo.getSalt();
        String passwordMD5 = MD5Util.encode(pwd);
        Assert.isTrue(passwordMD5.equals(userInfo.getPassword()), "密码错误");

        //保存token
        AppInfo appInfo = new AppInfo("1", "123456789");
        AccessToken accessToken = this.saveToken(1, appInfo, userInfo);
        userInfo.setAccessToken(accessToken);
        return ApiResponse.success(userInfo);

    }

    /**
     * 功能：保存token
     *
     * @param tokenType 1
     * @param appInfo   2
     * @param userInfo  3
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/24 18:46
     */
    private AccessToken saveToken(int tokenType, AppInfo appInfo, UserInfo userInfo) {
        String token = UUID.randomUUID().toString();

        // token有效期为2小时
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, 7200);
        Date expireTime = calendar.getTime();

        // 4. 保存token
        ValueOperations<String, TokenInfo> operations = redisTemplate.opsForValue();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setTokenType(tokenType);
        tokenInfo.setAppInfo(appInfo);

        if (tokenType == 1) {
            tokenInfo.setUserInfo(userInfo);
        }

        operations.set(token, tokenInfo, 7200, TimeUnit.SECONDS);
        AccessToken accessToken = new AccessToken(token, expireTime);

        return accessToken;
    }

    public static void main(String[] args) {
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        String signString = timestamp + "1" + "12345678954556";
        String sign = MD5Util.encode(signString);
        System.out.println(sign);


        System.out.println("-------------------");
        signString = "password=123456&username=1&12345678954556" + "ff03e64b-427b-45a7-b78b-47d9e8597d3b1529815393153sdfsdfsfs" + timestamp + "A1scr6";
        sign = MD5Util.encode(signString);
        System.out.println(sign);
    }
}
