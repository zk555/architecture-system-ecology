package cn.jdl.ecology.application.service;


import cn.jdl.ecology.datahelper.vo.Result;

import java.math.BigDecimal;

/**
 * @author chaoyang
 * @date 2022年08月17日 13:42
 */

public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency);
}
