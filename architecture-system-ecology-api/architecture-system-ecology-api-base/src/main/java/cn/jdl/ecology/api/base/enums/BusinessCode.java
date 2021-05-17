package cn.jdl.ecology.api.base.enums;



/**
 * @author Wangjw
 * @Title: BusinessCode
 * @ProjectName api-client-base
 * @Description: 公共业务编码
 * @date 2019-11-07 16:06
 */
public enum BusinessCode {

    /**
     * 产品线
     */
    NET_PAY("NET_PAY", "互支业务线"),
    POS_PAY("POS_PAY", "收单业务线"),
    BILL_PAY("BILL_PAY", "缴费云业务线"),
    BASE("BASE", "基础业务线"),
    XINGKE("XINGKE", "行客业务线"),
    CROSS_PAY("CROSS_PAY", "跨境人民币业务线"),

    /**
     * 产品编码
     */
    WITHDRAW("120", "提现"),
    INNER_PROD("080", "系统内产品"),
    NET_PROD("100", "互支产品"),
    CROSS_PROD("400", "跨境产品"),
    BILL_PROD("460", "缴费产品"),
    BASE_PROD("088", "基本产品"),
    WX_SCAN("108", "微信-商户主扫"),
    WX_SWEPT("176", "微信-商户被扫"),
    WX_APP("110", "微信-APP支付"),
    WX_JSAPI("107", "微信公众号支付"),
    WX_APPLETS("109", "微信小程序支付"),
    UNION_AGGREATION_SCAN("111","银联聚合-主扫"),
    UNION_AGGREATION_SWEPT("112","银联聚合-被扫"),
    UNION_AGGREATION_APP("113","银联聚合-APP支付"),
    UNION_SCAN("114","银联二维码-主扫"),
    UNION_SWEPT("115","银联二维码-被扫"),
    NET_B2C("101","网关B2C支付"),
    NET_B2B("102","网关B2B支付"),
    NET_WAP("103","WAP支付"),
    NET_AGREEMENT("104","快捷协议支付"),
    NET_AUTH("105","快捷认证支付"),
    NET_ENTRUST("106","委托支付"),
    TRANSFER("121","转账"),
    RECHARGE("119","充值"),
    ACCPAY("130", "账户支付"),
    PAYMENT("116","代付"),
    ALIPAY_SCAN("117","支付宝-商户主扫"),
    ALIPAY_SWEPT("118","支付宝-商户被扫"),
    HLHT_SCAN("141","互联互通-商户主扫"),
    HLHT_SWEPT("142","互联互通-商户被扫"),
    JDB_PROD("600","金大宝"),
    JZB_PROD("200","金中宝"),
    JFT_PROD("500","金付通"),
    JKPAY_PROD("300","金控钱包"),
    POS_PROD("800","小金"),
    //永不调价产品
    JXB_PROD("900","小宝POS"),
    JXB_PROD_DQ("700","小宝电签"),
    UNION_NET_GATEWAY("131","银联在线网关支付"),
    //银联无跳转-标准版
    UNION_UNSKIP_NORMAL("132","银联无跳转-标准版"),
    //银联无跳转-token版
    UNION_UNSKIP_TOKEN("133","银联无跳转-token版"),
    //银联wap分期
    UNION_WAP_INSTALLMENT("145","银联wap分期"),

    /**普通、智慧*/
    PREFERENTIAL("T","普通"),
    OPTIMIZATION("Y","智慧"),

    CROSS_AGREEMENT("401","跨境-快捷协议支付"),
    CROSS_WAP("402","跨境-WAP支付"),
    CROSS_ACCPAY("403","跨境-账户支付"),
    ;
    public final String code;
    public final String desc;

    BusinessCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BusinessCode get(String code) {
        BusinessCode[] vs = BusinessCode.values();
        for (BusinessCode apt : vs) {
            if (apt.code.equals(code)) {
                return apt;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "BusinessCode{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
