package cn.jdl.ecology.api.base.enums;

import lombok.AllArgsConstructor;

/**
 * @author Mr zhangzhw
 * @Title: BaseServiceCode
 * @ProjectName paas-sample
 * @Description: 服务|接口 编码
 * @date 2019-04-1617:30
 */
@AllArgsConstructor
public enum ServiceName {

    /**
     * 服务名
     */
    TRADE_CROSSBORDER_FOREIGNEXCHANGE_SERVICE("trade-crossborder-foreignexchange-service","跨境寻汇服务"),
    BILLPAY_CLEARING_SERVICE("billpay-clearing-service","缴费云清分服务"),
    BILLPAY_SETTLE_JOB_EXECUTOR("billpay_settle_job_executor","缴费云结算服务"),
    ORDER_SERVICE_BILLPAY("order-service-billpay","缴费云订单服务"),
    TRADE_SERVICE_BILLPAY("trade-billpay-recharge-service","缴费云交易服务"),
    CROSSBORDER_OPERATOR_PASS_SERVICE("crossborder-channel-route-service","跨境独立出来的路由通道设置服务"),
    CROSSBORDER_ROUTE_SERVICE("crossborder-webintrade-route-service", "跨境路由服务"),
    CROSSBORDER_CLEARING_SERVICE("crossborder-clearing-service", "跨境清分服务"),
    CROSSBORDER_CLEARING_DEDUCTION_SERVICE("crossborder-clearing-deduction-service", "跨境清分扣费服务"),
    CROSSBORDER_SETTLE_SERVICE("crossborder-settle-service", "跨境结算服务"),
    CROSSBORDER_CHECK_BILL_SERVICE("crossborder-checkbill-service", "跨境对账服务"),
    PROVIDER_DEMO_SERVICE("provider-demo-service", "PROVIDER_DEMO_SERVICE"),
    CONSUMER_DEMO_SERVICE("consumer-demo-service", "CONSUMER_DEMO_SERVICE"),
    PAAS_SERVICE("paas-service", "paas service"),
    GATEWAY("gateway", "网关"),
    ID_GENERATOR("id-generator", "ID服务"),
    FILE_SERVICE("file-service", "文件服务"),
    OAUTH2_SERVICE("oauth2-service", "oauth2服务"),
    USER_SERVICE("user-service", "user服务"),
    AUTHENTICATION_SERVICE("authentication-service", "鉴权服务"),
    AUTHENTICATION_FRONT("authentication-front", "鉴权前置服务"),
    SMS_CHANNEL("sms-channel", "短信渠道服务"),
    INFO_CHANNEL("info-channel", "信息类通道服务"),
    SMS_FRONT("sms-front", "短信前置服务"),
    SMS_SERVICE("sms-service", "短信服务"),
    SECURITY_BASE_SERVICE("security-base-service", "安全基础服务"),
    CROSSBORDER_DICT_SERVICE("crossborder-dict-service", "跨境独立数据字典服务"),
    DICT_SERVICE("dict-service", "数据字典服务"),
    CUSTOMER_SERVICE("customer-service", "客户服务"),
    TERMINAL_SERVICE("terminal-service", "终端服务"),
    PAAS_WEBINTRADE("paas-web-in-trade-route", "互联网入金路由"),
    POSP_GATEWAY_SERVICE("posp-gateway-service", "pos网关服务"),
    RISK_SERVICE("risk-service", "风控服务"),
    INTEGRAL_SERVICE("integral-service", "积分服务"),
    RISK_RE_SERVICE("risk-re-service", "风控规则引擎服务"),
    POS_CUP_Z("cis-channel-unionpay-cupz", "银联通道服务"),
    ORDER_SERVICE_NETPAY("order-service-netpay", "互联网订单中心服务"),
    CLEARING_SERVICE("clearing-service", "清分服务"),
    POS_CLEARING_SERVICE("pos-clearing-service", "收单清分服务"),
    RATE_SERVICE("rate-service", "费率服务"),
    MERCHANT_SERVICE("merchant-service", "商户服务"),
    CERTIFICATE_SERVICE("certificate-service", "证书服务"),
    ACCOUNT_BKP("account-bkp", "账务前置服务"),
    SPLIT_ORDER_SERVICE("split-order-service", "分账订单服务"),
    SPLIT_CLEARING_SERVICE("split-clearing-service", "分账流水服务"),
    ACCOUNT_ACT("account-act", "会计前置服务"),
    //交易中心服务名称
    TRADE_SCANPAY_SERVICE("trade-scanpay-service", "扫码交易"),
    TRADE_NUCC_INTERCONN_SERVICE("trade-nucc-interconn-service", "网联互联互通交易"),
    TRADE_AGENT_SERVICE("trade-agentpay-service", "代付交易"),
    TRADE_ACCOUNTPAY_SERVICE("trade-accountpay-service", "账户支付交易"),
    TRADE_CROSSBORDERPAY_SERVICE("trade-crossborder-service", "跨境支付交易"),
    TRADE_SCANORG_SERVICE("trade-scanorg-service", "互联互通收单侧交易"),
    CROSSBORDER_TRADE_QUICKPAY_SERVICE("crossborder-trade-quickpay-service", "跨境快捷交易服务"),
    TRADE_EPCC_BANK211PAYMNET_2ORG_SERVICE("trade-epcc-bank211payment-2org-service", "网联-银行发起211付款至支付机构交易服务"),


    POS_TRADE_SERVICE("pos-trade-service", "POS交易服务"),
    GATEWAY_TRADE_SERVICE("gateway-trade-service", "网关交易服务"),
    quickpay_trade_service("quickpay-trade-service", "快捷交易服务"),
    AGENCY_SERVICE("agency-service", "服务商服务"),
    AGENCY_DATA_SERVICE("agency-data-service", "服务商跑数服务"),
    POS_ORDER_SERVICE("pos-order-service", "POS订单交易服务"),
    POS_ORDER_BUSINESS_SERVICE("pos-order-business-service", "POS订单业务服务"),
    POS_ORDER_DATA_SERVICE("pos-order-data-service", "POS订单数据统计服务"),
    TERMINAL_DATA_SERVICE("terminal-data-service", "终端数据统计服务"),
    SETTLE_SERVICE("settle-service", "结算服务"),
    CAPITAL_ADMIN_SERVICE("capital-service", "资金服务"),
    CAPITAL_PERIODIZATION_SERVICE("capital-periodization", "资金分期"),
    KMS1312_FRONT("kms-sjj1312", "收单加密机前置服务"),
    KMS1545_FRONT("kms-sjj1545", "互支加密机前置服务"),
    POS_PAYMENT("pos-payment", "付款服务"),
    POS_SETTLE_SERVICE("pos-settle-service", "pos结算服务"),
    SSOIN_SERVICE("paas-ssoin-service", "单点登录服务"),
    MESSAGE_SERVICE("message-service", "消息服务"),
    AGGRETATION_QUERY_SERVICE("aggregation-queryservice", "聚合数据查询服务"),
    POS_REBATE("pos-rebate-job-executor", "返利服务"),
    UNIONUNSKIP_TRADE_SERVICE("unionunskip-trade-service", "银联无跳转交易系统"),
    UNION_GATEWAY_TRADE_SERVICE("trade-gateway-union-service", "银联网关交易支付"),

    /**
     * CIS-CHANNEl-******服务模块为CIS内部服务，其他系统不允许直接调用
     * 如果需要对接CIS系统（渠道网关），请对接CIS-API，CIS-API为渠道网关统一入口
     */
    CIS_API("cis-api", "CIS渠道网关服务"),
    CIS_ORDER_API("cis-order-api", "CIS流水服务"),
    CIS_ORDER_CHECK("cis-order-check", "CIS服务"),
    CIS_ENTRY("cis-entry", "CIS回调入口"),
    CIS_CHANNEL_NUCCSCAN_WECHAT("cis-channel-nuccscan-wechat", "网联微信服务"),
    CIS_CHANNEL_NUCCSCAN_ALIPAY("cis-channel-nuccscan-alipay", "网联支付宝服务"),
    CIS_CHANNEL_NUCCBASE_QUICKSIGN("cis-channel-nuccbase-quicksign", "网联身份认证及签约服务"),
    CIS_CHANNEL_NUCCBASE_QUICKRELEASE("cis-channel-nuccbase-quickrelease", "网联解约服务"),
    CIS_CHANNEL_NUCCBASE_PROTOCOLPAY("cis-channel-nuccbase-protocolpay", "网联协议支付服务"),
    CIS_CHANNEL_NUCCBASE_GATEWAY("cis-channel-nuccbase-gateway", "网联网关支付服务"),
    CIS_CHANNEL_NUCCBASE_AUTHPAY("cis-channel-nuccbase-authpay", "网联认证支付服务"),
    CIS_CHANNEL_NUCCBASE_PAID("cis-channel-nuccbase-paid", "网联代付服务"),
    CIS_CHANNEL_NUCCBASE_QUERY("cis-channel-nuccbase-query", "网联查询服务"),
    CIS_CHANNEL_NUCCBASE_REFUND("cis-channel-nuccbase-refund", "网联退款服务"),
    CIS_CHANNEL_UNIONPAY_WECHAT("cis-channel-unionpay-wechat", "银联微信服务"),
    CIS_CHANNEL_UNIONPAY_ALIPAY("cis-channel-unionpay-alipay", "银联支付宝服务"),
    CIS_CHANNEL_UNIONPAY_GATEWAY("cis-channel-unionpay-gateway", "银联网关支付服务"),
    CIS_CHANNEL_UNIONPAY_TJ("cis-channel-unionpay-tj", "天津银联代付服务"),
    CIS_CHANNEL_UNIONPAY_FSAS("cis-channel-unionpay-fsas", "银联资金结算服务"),
    CIS_CHANNEL_UNIONPAY_DEVICEPAY("cis-channel-unionpay-devicepay", "银联云闪付服务"),
    CIS_CHANNEL_UNIONPAY_UNIONSCAN("cis-channel-unionpay-unionscan", "银联二维码支付服务"),
    CIS_CHANNEL_UNIONPAY_AGGREGATE("cis-channel-unionpay-aggregate", "银联聚合支付服务"),
    CIS_CHANNEL_UNIONPAY_JS("cis-channel-unionpay-js", "银联JS服务"),
    CIS_CHANNEL_NUCCINTERCONN_ZH("cis-channel-nuccinterconn-zh", "网联互联互通账户侧服务"),
    CIS_CHANNEL_NUCCINTERCONN_SD("cis-channel-nuccinterconn-sd", "网联互联互通收单侧服务"),
    CIS_CHANNEL_NUCCMERADMIN_SD("cis-channel-nuccmeradmin-sd", "网联商户管理系统"),
    CIS_CHANNEL_UNIONPAY_UNSKIP("cis-channel-unionpay-unskip", "银联无跳转系统"),
    CIS_CHANNEL_UNIONPAY_CARDFREE_GATEWAY("cis-channel-unionpay-cardfree-gateway", "银联网银渠道系统"),
    CIS_CHANNEL_CZBANK_CROSSBORDER("cis-channel-czbank-crossborder", "浙商跨境服务"),
    CIS_CHANNEL_ALIPAY_RISK("cis-channel-alipay-risk", "支付宝风控系统"),
    CIS_CHANNEL_CROSSBORDER_CUSTOMS_CDXT("cis-channel-crossborder-customs-cdxt", "跨境海关-成都信通"),
    CIS_CHANNEL_FOREIGNEXCHANGE_SUNRATE("cis-channel-foreignexchange-sunrate", "外汇通道-寻汇"),
    CIS_CHANNEL_BILLPAY_RECHARGE("cis-channel-billpay-recharge", "网联缴费云通道"),
    CIS_CHANNEL_NUCCBOPS_SD("cis-channel-nuccbops-sd", "网联缴费云通道"),


    PAAS_SSOIN_SERVICE("paas-ssoin-service", "登录服务"),
    POS_IN_ROUTE("pos-in-route", "收单路由服务"),
    OUT_CHANNEL_ROUTE("out-trade-route", "出金通道路由"),
    //聚合码
    AGGREGATION_SERVICE("aggregation-service", "聚合码管理服务"),
    PAYMENT_SERVICE("payment-service", "付款服务(代付)"),

    /**
     * 营销系统
     */
    MARKETING_SERVICE("marketing-service", "营销系统"),
    /**
     * 营销数据服务
     */
    MARKETING_DATA_SERVICE("marketing-data-service", "营销数据服务"),

    /**
     * 收单入金路由
     */
    POSP_ROUTE_IN("posRoute", "收单路由系统"),

    /**
     * 组织机构管理服务
     */
    SYS_ORG_SERVICE("sysorg-service", "组织机构管理服务"),

    /**
     * POS分润服务
     */
    PROFIT_POS_ADMIN("profit-pos-admin", "POS分润服务"),
    /**
     * 分润服务
     */
    PROFIT_SERVICE("profit-service", "分润服务"),
    /**
     * 库存服务 -- 分布式事务测试
     */
    SEATA_ORDER_SERVICE("seata-order-service", "库存服务"),
    /**
     * 报表PAAS 服务
     */
    BUSINESS_REPORT_QUERY("business-report-query", "报表pass数据查询服务"),

    /**
     * 中能源活动账户服务
     */
    ACCOUNT_ACTIVITY("account-activity", "中能源活动账户服务"),
    /**
     * 中能源订单服务
     */
    CHINAIE_ORDER_SERVICE("china-ie-order-service", "中能源订单服务"),

    /**
     * 跨境订单中心
     */
    ORDER_SERVICE_CROSS_BORDER("order-service-crossborder", "跨境订单服务"),
    TRADE_CROSSBORDER_ACCOUNTPAY_SERVICE("trade-crossborder-accountpay-service", "跨境账户支付"),
    TRADE_CROSSBORDER_AGENTPAY_SERVICE("trade-crossborder-agentpay-service", "跨境代付支付"),
    CROSSBORDER_MERCHANT_SERVICE("crossborder-merchant-service", "跨境商户服务"),
    CROSSBORDER_GATEWAY_TRADE_SERVICE("crossborder-gateway-trade-service", "跨境网关交易服务"),
    CROSS_BORDER_DECLARE_SERVICE("crossborder-declare-service", "跨境申报服务"),
	MERCHANT_DATA_SERVICE("merchant-data-service", "商户数据服务"), PROFIT_DATA_SERVICE("profit-data-service", "经营分析分润服务"),

    GROUP_DATA_SERVICE("group-data-service", "团上团数据服务"),
    CHECKBILL_MERCHANT_SERVICE("checkbill-merchant-service","商户对账服务"),
    CHECKBILL_HANDLE_SERVICE("checkbill-handle-service","对账服务"),
    ;

    /**
     * 服务编码
     */
    public final String code;

    /**
     * 服务名称
     */
    public final String name;

    /**
     * get
     *
     * @param code String
     * @return ServiceName
     */
    public static ServiceName get(String code) {
        for (ServiceName serviceName : ServiceName.values()) {
            if (code.equals(serviceName.code)) {
                return serviceName;
            }
        }
        return null;
    }

}
