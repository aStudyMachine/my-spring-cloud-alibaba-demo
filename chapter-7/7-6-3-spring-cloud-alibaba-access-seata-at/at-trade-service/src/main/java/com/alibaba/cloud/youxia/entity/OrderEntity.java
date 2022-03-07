package com.alibaba.cloud.youxia.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderEntity implements Serializable {
    private Long id;
    private String orderName;
    private Long orderId;
    private BigDecimal orderAmount;
    private Long userId;
    private Long goodId;
    private int isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
    private int orderStatus;

}
