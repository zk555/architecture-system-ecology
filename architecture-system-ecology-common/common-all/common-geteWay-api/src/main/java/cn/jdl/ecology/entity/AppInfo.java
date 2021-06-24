package cn.jdl.ecology.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 应用信息
 * @Author zhaokai108
 * @Date 2021/6/24 17:32
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppInfo {
    /**
     * App id
     */
    private String appId;
    /**
     * API 秘钥
     */
    private String key;
}