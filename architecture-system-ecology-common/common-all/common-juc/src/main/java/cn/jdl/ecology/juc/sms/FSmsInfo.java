package cn.jdl.ecology.juc.sms;

/**
 * @Description: 不可变类
 * @Author zhaokai108
 * @Date 2021/6/5 13:25
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public final class FSmsInfo {

    private final Long id;

    // 短信服务商的请求URL
    private final String url;

    // 短信内容最多多少字节
    private final Long maxSizeInBytes;

    public FSmsInfo(Long id, String url, Long maxSizeInBytes) {
        this.id = id;
        this.url = url;
        this.maxSizeInBytes = maxSizeInBytes;
    }

    public FSmsInfo(FSmsInfo fSmsInfo) {
        this.id = fSmsInfo.id;
        this.url =fSmsInfo. url;
        this.maxSizeInBytes = fSmsInfo.maxSizeInBytes;
    }

    public String getUrl() {
        return url;
    }

    public Long getMaxSizeInBytes() {
        return maxSizeInBytes;
    }

}
