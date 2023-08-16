package cn.jdl.ecology.b;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "weather rule", description = "if it rains then take an umbrella")
public class WeatherRule {

    @Condition
    public boolean c1(@Fact("rain") boolean rain) {
        return rain;
    }

    @Action
    public void e1() {
        System.out.println("It rains, take an umbrella!");
    }
}