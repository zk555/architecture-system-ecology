package cn.jdl.ecology.listener;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;

public class MRuleListener implements RuleListener {

    @Override
    public boolean beforeEvaluate(Rule rule, Facts facts) {
        return RuleListener.super.beforeEvaluate(rule, facts);
    }

    @Override
    public void afterEvaluate(Rule rule, Facts facts, boolean evaluationResult) {
//        RuleListener.super.afterEvaluate(rule, facts, evaluationResult);
        System.out.println("condition评估之后");
    }

    @Override
    public void beforeExecute(Rule rule, Facts facts) {
        System.out.println("action执行之前");
//        RuleListener.super.beforeExecute(rule, facts);
    }

    @Override
    public void onSuccess(Rule rule, Facts facts) {
        System.out.println("action执行成功");
//        RuleListener.super.onSuccess(rule, facts);
    }

    @Override
    public void onFailure(Rule rule, Facts facts, Exception exception) {
        System.out.println("action执行失败");
//        RuleListener.super.onFailure(rule, facts, exception);
    }
}
