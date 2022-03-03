package com.alibaba.cloud.youxia.manager;

import com.alibaba.cloud.youxia.entity.OrderEntity;
import com.alibaba.cloud.youxia.mapper.OrderMapper;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderManager {

    @Data
    static class Result {
        private Long id;
        private boolean result;
    }

    @Resource
    private OrderMapper orderMapper;

    // @DubboReference(version = "1.0.0", group = "SEATA_GROUP")
    // private XaWarehouseService xaWarehouseService;
    //
    // @DubboReference(version = "1.0.0", group = "SEATA_GROUP")
    // private XaLogisticsService xaLogisticsService;

    public Result createOrder(Long userId, BigDecimal amount, Long goodId) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(RandomUtils.nextLong());
        orderEntity.setId(RandomUtils.nextLong());
        orderEntity.setOrderAmount(amount);
        orderEntity.setOrderName("测试订单" + RandomUtils.nextInt());
        orderEntity.setGoodId(goodId);
        orderEntity.setUserId(userId);
        orderEntity.setIsDeleted(0);
        orderEntity.setGmtCreate(new Date());
        orderEntity.setGmtModified(new Date());
        Long result = orderMapper.createNewOrder(orderEntity);
        Result createResult = new Result();
        createResult.setResult(result > 0);
        createResult.setId(orderEntity.getId());
        return createResult;
    }

    public boolean updataOrderStatus(Long id, Integer orderStatus) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(id);
        orderEntity.setOrderStatus(orderStatus);
        Integer result = orderMapper.updataOrderStatus(orderEntity);
        return result > 0;
    }

    // // 通过注解@GlobalTransactional开启分布式事务，并设置事务回滚的异常类型为Exception,超时之后的事务重试周期为5s，超时重试次数为5次，事务执行的超时时间为30s
    // // 全局事务隔离级别为Propagation.REQUIRES_NEW（针对每一个新的连接都开启一个新的事务）
    // @GlobalTransactional(name = "spring-boot-access-pay-order",
    //         rollbackFor = Exception.class, lockRetryInternal = 5000,
    //         lockRetryTimes = 5, timeoutMills = 30000, propagation = Propagation.REQUIRES_NEW)
    // public boolean placeOrder(Long userId, Long goodId, Long accountId, Integer num) {
    //     Result orderResult = createOrder(userId, new BigDecimal(100), goodId);
    //     WarehouseServiceBo warehouseServiceBo = new WarehouseServiceBo();
    //     warehouseServiceBo.setOrderId(orderResult.getId());
    //     warehouseServiceBo.setGoodId(goodId);
    //     warehouseServiceBo.setNum(num);
    //     WarehouseServiceDTO warehouseServiceDTO = xaWarehouseService.notifyWarehouse(warehouseServiceBo);
    //     LogisticsServiceBo logisticsServiceBo = new LogisticsServiceBo();
    //     logisticsServiceBo.setOrderId(orderResult.getId());
    //     LogisticsServiceDTO logisticsServiceDTO = xaLogisticsService.notifyLogistics(logisticsServiceBo);
    //     if (orderResult.isResult() && warehouseServiceDTO.getStatus() == 200 && logisticsServiceDTO.getStatus() == 200) {
    //         return updataOrderStatus(orderResult.getId(), 1);
    //     }
    //     return true;
    // }
}
