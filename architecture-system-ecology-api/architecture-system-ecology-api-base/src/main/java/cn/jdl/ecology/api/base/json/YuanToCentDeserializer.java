package cn.jdl.ecology.api.base.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author DaoDao
 */
public class YuanToCentDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        BigDecimal yuan;
        BigDecimal cent;
        String text = p.getText();
        if (null == text || text.isEmpty()) {
            yuan = null;
        } else {
            yuan = new BigDecimal(text);
        }
        if (null == yuan) {
            cent = null;
        } else {
            cent = new BigDecimal(String.valueOf(yuan.multiply(BigDecimal.valueOf(100.00D)).setScale(0, RoundingMode.HALF_UP)));
        }
        return cent;
    }

}
