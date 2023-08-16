package cn.jdl.ecology.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chaoyang
 * @date 2022年08月22日 16:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DailyLimitExceededException extends RuntimeException {

    public DailyLimitExceededException() {
        super("每日极限超越异常");
    }
}
