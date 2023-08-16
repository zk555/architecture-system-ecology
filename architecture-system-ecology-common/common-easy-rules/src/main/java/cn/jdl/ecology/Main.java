package cn.jdl.ecology;

import cn.jdl.ecology.anno.MRule;
import cn.jdl.ecology.b.Item;
import cn.jdl.ecology.b.WeatherRule;
import cn.jdl.ecology.interf.TenPercentDiscountAction;
import cn.jdl.ecology.interf.TenPercentDiscountCondition;
import cn.jdl.ecology.listener.MRuleListener;
import org.jeasy.rules.api.*;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.spel.SpELRule;
import org.jeasy.rules.support.composite.UnitRuleGroup;

//public class Main {
//    public static void main(String[] args) {
//        // define facts
//        Facts facts = new Facts();
//        facts.put("rain", true);
//
//        // define rules
//        Rules rules = new Rules();
//        rules.register(new WeatherRule());
//
//        // fire rules on known facts
//        RulesEngine rulesEngine = new DefaultRulesEngine();
//        rulesEngine.fire(rules, facts);
//    }
//}

/**
 *
 * skipOnFirstAppliedRule：当一个规则成功应用时，跳过余下的规则。
 * skipOnFirstFailedRule：当一个规则失败时，跳过余下的规则。
 * skipOnFirstNonTriggeredRule：当一个规则未触发时，跳过余下的规则。
 * rulePriorityThreshold：当优先级超过指定的阈值时，跳过余下的规则。
 */
public class Main {
    public static void main(String[] args) {
        // 创建执行器参数
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        // 创建执行期引擎
        DefaultRulesEngine discountEngine = new DefaultRulesEngine(parameters);
        // 链式规则完成接口规则的定义
        Rule tenPercentRule = new RuleBuilder().name("200~400的折扣")
                .description("200~400的折扣")
                .when(new TenPercentDiscountCondition())
                .then(new TenPercentDiscountAction())
                .build();
        // 注解实现方式
        MRule cutTenRule = new MRule();
        // 添加规则
        Rules rules = new Rules();
//        rules.register(tenPercentRule);
//        rules.register(cutTenRule);


        // 定义事实
        Facts facts = new Facts();
        for (int i = 0; i < 400; i += 100) {
            // 添加事实
//            facts.put("price", i);
            // 触发引擎
//            discountEngine.registerRuleListener(new MRuleListener());
//            discountEngine.fire(rules, facts);
        }

        System.out.println("--------------");

        SpELRule spelRule = new SpELRule().name("1")
                .description("1")
                .priority(1)
                .when("#{ ['item'].price >= 400 }")
                .then("#{ ['item'].setExpression('折扣规则为8折\n原价为:' + ['item'].price " +
                        "+ '\n折扣后的价格为：'" +
                        " + T(java.lang.Float).parseFloat(['item'].price * 0.8+'') )  }");
        rules.register(spelRule);
        // 添加事实
        Item item = new Item(500);
        facts.put("item", item);
        // 触发引擎
        discountEngine.fire(rules, facts);
        System.out.println(item.getExpression());
    }
}
