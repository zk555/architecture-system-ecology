package cn.jdl.ecology.api.base.json;

import cn.jdl.ecology.api.base.annotation.Sensitive;
import cn.jdl.ecology.api.base.enums.SensitiveType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Jackson 脱敏序列化
 *
 * @author DaoDao
 */
@Slf4j
public class JacksonSensitiveSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private SensitiveType type;
    private String regex;
    private String replace;

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (type != null) {
            try {
                if (!SensitiveType.CUSTOM.equals(type)) {
                    regex = type.getRegex();
                    replace = type.getReplace();
                }
                if (null != regex && replace != null && regex.length() > 0) {
                    jsonGenerator.writeString(value.replaceAll(regex, replace));
                }
            } catch (Exception e) {
                log.warn("JacksonSensitiveSerializer has no field {}", value);
            }
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        Sensitive sensitive = beanProperty.getAnnotation(Sensitive.class);
        type = sensitive.type();
        regex = sensitive.regex();
        replace = sensitive.replace();
        return this;
    }

}
