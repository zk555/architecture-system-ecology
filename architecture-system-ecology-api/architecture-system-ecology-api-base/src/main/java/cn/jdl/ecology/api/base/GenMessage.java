/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * www.mfhcd.com
 */

package cn.jdl.ecology.api.base;

import lombok.Data;
import lombok.ToString;

/**
 * com.mfhcd.bpcs.dto.response
 *
 * @author weiyajun
 * @date 20180814
 */
@Data
@ToString
public class GenMessage {

    /**
     * 业务返回码
     */
    private String resultCode = "";

    /**
     * 业务返回码描述
     */
    private String resultDesc = "";

    /**
     * 通知的一些业务返回
     */
    private String resultData = "";

    /**
     * 通知的一些错误详细信息
     */
    private String exceptionDetails = "";

}
