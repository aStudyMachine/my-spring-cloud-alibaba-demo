package cn.studymachine.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WarehouseServiceBo implements Serializable {
    private Long goodId;
    private Long orderId;
    private Integer num;

}
