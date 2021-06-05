package cn.jdl.ecology.juc.sms;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/5 13:25
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class SmsInfo {

    // 短信服务商的请求URL
    private String url;

    // 短信内容最多多少字节
    private  Long maxSizeInBytes;

    public SmsInfo(String url, Long maxSizeInBytes) {
        this.url = url;
        this.maxSizeInBytes = maxSizeInBytes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getMaxSizeInBytes() {
        return maxSizeInBytes;
    }

    public void setMaxSizeInBytes(Long maxSizeInBytes) {
        this.maxSizeInBytes = maxSizeInBytes;
    }
}
