/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * www.mfhcd.com
 */

package cn.jdl.ecology.api.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 返回结果对象
 *
 * @author guotl
 * @version V1.0
 * @date 2018/8/15 9:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResT<T> implements Serializable {

    /**
     * 处理结果编码
     */
    private String procCode;
    /**
     * 处理结果描述
     */
    private String procDesc;
    /**
     * 系统跟踪号
     */
    private String sysTraceNo;
    /**
     * 业务处理方的系统编码
     */
    private String sysCode;
    /**
     * 业务响应信息
     */
    private T message;

}
