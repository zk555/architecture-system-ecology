package cn.jdl.ecology.repository;


import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.types.AccountId;
import cn.jdl.ecology.types.AccountNumber;
import cn.jdl.ecology.types.UserId;

/**
 * @author chaoyang
 * @date 2022年08月17日 14:34
 */

public interface AccountRepository {

    Account find(AccountId id);
    Account find(AccountNumber accountNumber);
    Account find(UserId userId);
    Account save(Account account);

}
