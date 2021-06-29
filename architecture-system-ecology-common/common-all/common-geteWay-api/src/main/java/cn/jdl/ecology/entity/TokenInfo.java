package cn.jdl.ecology.entity;

import lombok.Data;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/24 17:48
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Data
public class TokenInfo {
    /**
     * token类型: api:0 、user:1
     */
    private Integer tokenType;


    /**
     * App 信息
     */
    private AppInfo appInfo;


    /**
     * 用户其他数据
     */
    private UserInfo userInfo;
}