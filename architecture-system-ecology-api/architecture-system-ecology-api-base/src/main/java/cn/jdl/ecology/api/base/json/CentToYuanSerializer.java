package cn.jdl.ecology.api.base.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author DaoDao
 */
public class CentToYuanSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        BigDecimal yuan;
        if (null == value) {
            yuan = null;
        } else {
            if (value.equals(BigDecimal.ZERO)) {
                yuan = BigDecimal.ZERO;
            } else {
                yuan = value.divide(BigDecimal.valueOf(100.00D), 2, BigDecimal.ROUND_HALF_UP);
            }
            yuan = new BigDecimal(String.valueOf(yuan.setScale(2, RoundingMode.HALF_UP)));
        }
        gen.writeString(String.valueOf(yuan));
    }

}
