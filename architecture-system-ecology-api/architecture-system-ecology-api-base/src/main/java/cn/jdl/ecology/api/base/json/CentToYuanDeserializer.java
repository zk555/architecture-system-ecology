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
public class CentToYuanDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        BigDecimal yuan;
        BigDecimal cent;
        String text = p.getText();
        if (null == text || text.isEmpty()) {
            cent = null;
        } else {
            cent = new BigDecimal(text);
        }
        if (null == cent) {
            yuan = null;
        } else {
            if (cent.equals(BigDecimal.ZERO)) {
                yuan = BigDecimal.ZERO;
            } else {
                yuan = cent.divide(BigDecimal.valueOf(100.00D), 2, BigDecimal.ROUND_HALF_UP);
            }
            yuan = new BigDecimal(String.valueOf(yuan.setScale(2, RoundingMode.HALF_UP)));
        }
        return yuan;
    }

}
