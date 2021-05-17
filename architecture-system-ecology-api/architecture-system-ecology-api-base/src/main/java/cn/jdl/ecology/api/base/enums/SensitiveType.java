package cn.jdl.ecology.api.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 敏感类型枚举
 *
 * @author DaoDao
 */
@Getter
@AllArgsConstructor
public enum SensitiveType {

    /**
     * 姓名
     */
    NAME("([\u4E00-\u9FA5]{1})([\u4E00-\u9FA5]{1})([\u4E00-\u9FA5]{0,})", "*$2$3"),

    /**
     * 手机
     */
    PHONE("(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])(\\d{4})(\\d{4})", "$1****$3"),

    /**
     * 邮箱
     */
    EMAIL("([a-zA-Z0-9_-]{2})([a-zA-Z0-9_-]+)(@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)", "$1****$3"),

    /**
     * 身份证
     */
    ID_CARD("(\\d{4})(\\d{7,10})(\\d{4}|\\d{3}[Xx]{1})", "$1****$3"),

    /**
     * 银行卡
     */
    BANK_CARD("(\\d{4})(\\d{2,22})(\\d{4})", "$1****$3"),

    /**
     * 自定义
     */
    CUSTOM("", ""),
    ;

    /**
     * 正则
     */
    String regex;

    /**
     * 替换
     */
    String replace;

}
