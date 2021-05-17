package cn.jdl.ecology.api.base.enums;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangyl
 * @Date: 2019-12-2 11:17
 **/

public class MerEnum {

    /**
     * 商户等级 101-A1,102-A2,103-A3,104-A4,105-A5,106-A6,107-A7,108-A8,109-A9,201-B1,202-B2,301-C
     **/
    @AllArgsConstructor
    public enum MerLevel {
        A1("101", "A1"),
        A2("102", "A2"),
        A3("103", "A3"),
        A4("104", "A4"),
        A5("105", "A5"),
        A6("106", "A6"),
        A7("107", "A7"),
        A8("108", "A8"),
        A9("109", "A9"),
        B1("201", "B1"),
        B2("202", "B2"),
        C("301", "C"),
        ;
        public  String code;
        public  String msg;

        /**
         * 系统类型数据集<code,MerLevel>
         */
        private static Map<String, MerLevel> codeMap = new HashMap<>();

        // 执行初始化
        static {
            for(MerLevel tmp: MerLevel.values()){
                codeMap.put(tmp.code, tmp);
            }
        }

        /**
         * 根据CODE获取系统类型枚举
         *
         * @param  code 系统类型编码
         * @return MerLevel
         */
        public static MerLevel getEnumByCode(String code) {
            return codeMap.get(code);
        }
    }
}
