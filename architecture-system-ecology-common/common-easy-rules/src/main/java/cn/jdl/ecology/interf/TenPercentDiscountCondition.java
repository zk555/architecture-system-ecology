package cn.jdl.ecology.interf;


import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;

public class TenPercentDiscountCondition implements Condition {

    @Override
    public boolean evaluate(Facts facts) {
        return (Integer)facts.get("price") < 200;
    }
}
