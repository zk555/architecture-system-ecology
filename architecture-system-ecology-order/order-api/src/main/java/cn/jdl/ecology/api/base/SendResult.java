package cn.jdl.ecology.api.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendResult {


    private boolean ok;

    public static SendResult success() {
        return new SendResult(true);
    }
}
