package cn.jdl.ecology.persistence.mapper;

import cn.jdl.ecology.persistence.po.AccountPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author chaoyang
 * @date 2022年08月17日 14:40
 */

@Mapper
public interface AccountMapper extends BaseMapper<AccountPO> {

    @Select("select * from account where account_number = #{value}")
    AccountPO selectByAccountNumber(String value);

    @Select("select * from account where user_id = #{id}")
    AccountPO selectByUserId(long id);
}
