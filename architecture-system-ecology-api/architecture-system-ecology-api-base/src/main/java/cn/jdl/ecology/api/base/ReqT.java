/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * www.mfhcd.com
 */

package cn.jdl.ecology.api.base;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 请求参数对象
 *
 * @author guotl
 * @version V1.0
 * @date 2018/8/15 9:48
 */
@Data
@NoArgsConstructor
public class ReqT<T> implements Serializable {

    /**
     * 请求方的主机名或IP
     */
    @NotNull(message = "hostName 不可为 null")
    @NotEmpty(message = "hostName 不可为 空")
    @NotBlank(message = "hostName 不可为 空")
    @Size(min = 1, max = 64, message = "hostName 长度范围为 {min} ~ {max}")
    private String hostName;

    /**
     * 客户端
     */
    @Size(min = 1, max = 64, message = "client 长度范围为 {min} ~ {max}")
    private String client;

    /**
     * 服务编码
     */
    @NotNull(message = "sysCode 不可为 null")
    @NotEmpty(message = "sysCode 不可为 空")
    @NotBlank(message = "sysCode 不可为 空")
    @Size(min = 1, max = 64, message = "sysCode 长度范围为 {min} ~ {max}")
    private String sysCode;

    /**
     * API 编码
     */
    @NotNull(message = "requestCode 不可为 null")
    @NotEmpty(message = "requestCode 不可为 空")
    @NotBlank(message = "requestCode 不可为 空")
    @Size(min = 1, max = 64, message = "requestCode 长度范围为 {min} ~ {max}")
    private String requestCode;

    /**
     * 系统跟踪号
     */
    @Size(min = 1, max = 64, message = "sysTraceNo 长度范围为 {min} ~ {max}")
    private String sysTraceNo;

    /**
     * 业务参数
     */
    @NotNull(message = "params 业务参数不能为空 null")
    private T params;

    @JsonProperty("oAuth2")
    private OAuth2 oAuth2;

    private User user;

}
