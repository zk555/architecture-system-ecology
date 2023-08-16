package cn.jdl.ecology.persistence.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chaoyang
 * @date 2022年09月03日 20:19
 */
@Data
@TableName("line_item")
public class LineItemPO {

    private Long id;

    private Long orderId;

    private Long itemId;

    private int quantity;

    private BigDecimal price;

}
