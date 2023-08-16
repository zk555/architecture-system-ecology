package cn.jdl.ecology.domain.types;

import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.types.AccountNumber;
import cn.jdl.ecology.types.Money;
import cn.jdl.ecology.types.UserId;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Date;

/**
 * @author chaoyang
 * @date 2022年08月19日 14:16
 */
@Value
@AllArgsConstructor
public class AuditMessage {
    UserId userId;
    AccountNumber source;
    AccountNumber target;
    Money money;
    Date date;



    public AuditMessage(Account sourceAccount, Account targetAccount, Money targetMoney) {
        this.source = sourceAccount.getAccountNumber();
        this.target = targetAccount.getAccountNumber();
        this.money = targetMoney;
        this.userId = targetAccount.getUserId();
        this.date = new Date();
    }




    public String serialize() {
        return userId + "," + source + "," + target + "," + money + "," + date;
    }

    public static AuditMessage deserialize(String value) {
        // todo
        return null;
    }
}
