package cn.jdl.ecology.client.balance;

import java.util.List;

public interface LoadBalanceStrategy {

    String selectHost(List<String> repos);

}
