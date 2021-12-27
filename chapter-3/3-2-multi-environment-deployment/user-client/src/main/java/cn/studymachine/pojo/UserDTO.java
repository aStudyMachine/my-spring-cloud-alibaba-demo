package cn.studymachine.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * The type User dto.
 *
 * @author wukun
 * @since 2021 /12/27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 租户名
     */
    private String name;
}
