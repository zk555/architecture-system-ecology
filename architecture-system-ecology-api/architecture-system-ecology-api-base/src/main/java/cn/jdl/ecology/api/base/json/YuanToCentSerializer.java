package cn.jdl.ecology.api.base.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 元转分序列化，适用于
 *
 * @author DaoDao
 */
public class YuanToCentSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        BigDecimal cent;
        if (null == value) {
            cent = null;
        } else {
            cent = new BigDecimal(String.valueOf(value.multiply(BigDecimal.valueOf(100.00D)).setScale(0, RoundingMode.HALF_UP)));
        }
        gen.writeString(String.valueOf(cent));
    }

}
