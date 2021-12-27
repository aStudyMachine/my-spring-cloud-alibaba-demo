package cn.studymachine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wukun
 * @since 2021/12/27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Example5OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String orderName;
    private Long orderId;

}
