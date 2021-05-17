package cn.jdl.ecology.api.base.enums;

/**
 * @author Mr zhangzhw
 * @Title: BaseResCode
 * @ProjectName paas-sample
 * @Description: 错误码
 * @date 2019-04-1616:06
 */
public enum BaseResCode {

    /*系统级成功*/
    _0000("0000", "响应成功"),



    /*业务调用级*/
    _0001("0001", "公共参数错误"),
    _0002("0002", "业务参数错误"),
    _0003("0003", "没有此项服务"),
    _0004("0004", "服务已禁用"),
    _0005("0005", "校验执行器不可用"),
    _0006("0006", "服务执行器不可用"),
    _0007("0007", "请求参数不可为空"),
    _0008("0008", "请求参数格式错误"),


    /*系统失败*/
    _9999("9999", "系统异常"),

    ;
    public final String code;
    public final String desc;

    BaseResCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BaseResCode get(String code) {
        BaseResCode[] vs = BaseResCode.values();
        for (BaseResCode apt : vs) {
            if (apt.code.equals(code)) {
                return apt;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "BaseResCode{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
