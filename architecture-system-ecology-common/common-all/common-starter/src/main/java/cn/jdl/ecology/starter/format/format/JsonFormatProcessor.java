package cn.jdl.ecology.starter.format.format;

import com.alibaba.fastjson.JSON;

public class JsonFormatProcessor implements FormatProcessor {
    @Override
    public <T> String format(T obj) {
        return JSON.toJSONString(obj);
    }
}
