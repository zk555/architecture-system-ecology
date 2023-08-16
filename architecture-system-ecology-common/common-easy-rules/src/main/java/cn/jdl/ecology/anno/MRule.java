package cn.jdl.ecology.anno;

import org.jeasy.rules.annotation.*;
import org.jeasy.rules.api.Facts;


@Rule(name = "weather rule", description = "if it rains then take an umbrella")
public class MRule {

    private Integer price;

    // 该注解标记为条件 ，@Fact注解指定参数
    @Condition
    public boolean isLowerThan200(@Fact("price") Integer price) {
        this.price = price;
        return price < 200;
    }

    // 该注解表示条件判断之后的操作
    @Action(order = 1)
    public void then(Facts facts) throws Exception {
        System.out.println("MRule 折扣规则为减10元\n原价为:"+price+"\n折扣后价格的价格为：" + (price > 10 ? price - 10 : price));
    }

    //该注解表示优先级
    @Priority
    public int getPriority() {
        return 0;
    }
}
