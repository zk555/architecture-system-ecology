package cn.jdl.ecology.api.base.json;

import cn.jdl.ecology.api.base.annotation.Sensitive;
import cn.jdl.ecology.api.base.enums.SensitiveType;
import com.alibaba.fastjson.serializer.ValueFilter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * FastJson 脱敏过滤器
 *
 * @author DaoDao
 */
@Slf4j
public class FastJsonSensitiveFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        if (!(value instanceof String) || ((String) value).length() == 0) {
            return value;
        }
        try {
            Field field = object.getClass().getDeclaredField(name);
            Sensitive sensitive;
            if (String.class != field.getType() || (sensitive = field.getAnnotation(Sensitive.class)) == null) {
                return value;
            }
            SensitiveType type = sensitive.type();
            String regex = sensitive.regex();
            String replace = sensitive.replace();
            if (!SensitiveType.CUSTOM.equals(type)) {
                regex = type.getRegex();
                replace = type.getReplace();
            }
            if (null != regex && replace != null && regex.length() > 0) {
                return ((String) value).replaceAll(regex, replace);
            }
        } catch (Exception e) {
            log.warn("FastJsonSensitiveFilter the class {} has no field {}", object.getClass(), name);
        }
        return value;
    }

}
