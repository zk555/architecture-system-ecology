package cn.jdl.ecology.domain.entity;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @author chaoyang
 * @date 2022年09月13日 16:17
 */

public class AccountEasy {

    private String accountNumber;
    private Long amount;

    public AccountEasy(String accountNumber, Long amount) {
        assert StringUtils.isNotBlank(accountNumber);
        assert amount >= 0;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

}
