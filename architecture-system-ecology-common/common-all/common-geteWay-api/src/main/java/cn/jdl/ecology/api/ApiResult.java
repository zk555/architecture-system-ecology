package cn.jdl.ecology.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/24 17:55
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {


    /**
     * 代码
     */
    private String code;


    /**
     * 结果
     */
    private String msg;
}