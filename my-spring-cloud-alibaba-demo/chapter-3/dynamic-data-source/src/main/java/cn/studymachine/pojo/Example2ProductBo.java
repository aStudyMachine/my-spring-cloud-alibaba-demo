package cn.studymachine.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wukun
 * @since 2021/12/23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Example2ProductBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long goodId;
}
