package cn.jdl.ecology.api.base.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Long 类型字段序列化时转为字符串，避免 js 丢失精度
 *
 * @author DaoDao
 */
public class LongJsonSerializer extends JsonSerializer<Long> {

    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String s = (value == null ? null : String.valueOf(value));
        if (s != null) {
            gen.writeString(s);
        }
    }

}
