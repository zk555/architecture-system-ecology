package cn.jdl.ecology.repository.impl;

import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.persistence.mapper.AccountMapper;
import cn.jdl.ecology.persistence.po.AccountPO;
import cn.jdl.ecology.repository.AccountRepository;
import cn.jdl.ecology.repository.assemble.AccountBuilder;
import cn.jdl.ecology.types.AccountId;
import cn.jdl.ecology.types.AccountNumber;
import cn.jdl.ecology.types.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author chaoyang
 * @date 2022年08月17日 14:36
 */
@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {


    private final AccountMapper accountDAO;


    private final AccountBuilder accountBuilder;

    @Override
    public Account find(AccountId id) {
        AccountPO accountPO = accountDAO.selectById(id.getValue());
        return accountBuilder.toAccount(accountPO);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountPO accountPO = accountDAO.selectByAccountNumber(accountNumber.getValue());
        return accountBuilder.toAccount(accountPO);
    }

    @Override
    public Account find(UserId userId) {
        AccountPO accountPO = accountDAO.selectByUserId(userId.getId());
        return accountBuilder.toAccount(accountPO);
    }

    @Override
    public Account save(Account account) {
        AccountPO accountPO = accountBuilder.fromAccount(account);
        if (accountPO.getId() == null) {
            accountDAO.insert(accountPO);
        } else {
            accountDAO.updateById(accountPO);
        }
        return accountBuilder.toAccount(accountPO);
    }

}
