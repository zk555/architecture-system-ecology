package cn.jdl.ecology.api.base.json;

import cn.jdl.ecology.api.base.annotation.Sensitive;
import cn.jdl.ecology.api.base.enums.SensitiveType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Jackson 脱敏序列化工厂
 * @author DaoDao
 */
@Slf4j
public class JacksonSensitiveSerializerFactory extends BeanSerializerFactory {

    public JacksonSensitiveSerializerFactory() {
        this(null);
    }

    public JacksonSensitiveSerializerFactory(SerializerFactoryConfig config) {
        super(config);
    }

    @Override
    protected void processViews(SerializationConfig config, BeanSerializerBuilder builder) {
        super.processViews(config, builder);
        List<BeanPropertyWriter> originalWriters = builder.getProperties();
        List<BeanPropertyWriter> writers = new ArrayList<>();
        for (BeanPropertyWriter writer : originalWriters) {
            Sensitive sensitive = writer.getAnnotation(Sensitive.class);
            if (null != sensitive) {
                SensitiveType type = sensitive.type();
                final String[] regexArray = {sensitive.regex()};
                final String[] replaceArray = {sensitive.replace()};
                writer.assignSerializer(new JsonSerializer<Object>() {
                    @Override
                    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
                        try {
                            String regex;
                            String replace;
                            if (SensitiveType.CUSTOM.equals(type)) {
                                regex = regexArray[0];
                                replace = replaceArray[0];
                            } else {
                                regex = type.getRegex();
                                replace = type.getReplace();
                            }
                            if (null != regex && replace != null && regex.length() > 0 && value instanceof String) {
                                String v = (String) value;
                                jsonGenerator.writeString(v.replaceAll(regex, replace));
                            }
                        } catch (Exception e) {
                            log.warn("JacksonSensitiveSerializer has no field {}", value);
                        }
                    }
                });
            }
            writers.add(writer);
        }
        builder.setProperties(writers);
    }

}
