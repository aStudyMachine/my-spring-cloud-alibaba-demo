package cn.studymachine.config;

import lombok.Data;
import lombok.ToString;

/**
 * @author wukun
 * @since 2021/12/27
 */
@Data
@ToString
public class SnowflakeInfo {
    /**
     * ip
     */
    private String ip;
    /**
     * 数据中心id
     */
    private Long dataCenterId;
    /**
     * 机器id
     */
    private Long machineId;
}
