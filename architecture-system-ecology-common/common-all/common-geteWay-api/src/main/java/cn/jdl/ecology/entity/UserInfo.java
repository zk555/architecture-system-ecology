package cn.jdl.ecology.entity;

import cn.jdl.ecology.token.AccessToken;
import lombok.Data;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/24 17:42
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Data
public class UserInfo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;


    private AccessToken accessToken;


    public UserInfo(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
}
