package cn.jdl.ecology.interf;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

public class TenPercentDiscountAction implements Action {
    @Override
    public void execute(Facts facts) throws Exception {
        Integer price = facts.get("price");
        System.out.println("Discount  折扣规则为9折\n原价为:"+price+"\n折扣后的价格为：" + (float)(price * 0.9));
    }
}
