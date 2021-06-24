package cn.jdl.ecology.token;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/24 17:52
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Data
@AllArgsConstructor
public class AccessToken {
    /** token */
    private String token;


    /** 失效时间 */
    private Date expireTime;
}
