package cn.jdl.ecology.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月01日 10:47
 */
@Data
@TableName("order")
public class OrderPO {
    @TableId
    private Long id;

    private Long parentId;

    private String itemId;

    private String addressDetail;

}
