package com.alibaba.cloud.youxia.manager;

import cn.studymachine.service.AtAccountService;
import cn.studymachine.service.AtStorageService;
import com.alibaba.cloud.youxia.entity.OrderEntity;
import com.alibaba.cloud.youxia.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderManager {
    @Resource
    private OrderMapper orderMapper;

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
        Long result = orderMapper.createOrder(orderEntity);
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

    @DubboReference(version = "1.0.0", group = "SEATA_GROUP")
    private AtAccountService atAccountService;

    @DubboReference(version = "1.0.0", group = "SEATA_GROUP")
    private AtStorageService atStorageService;

    @GlobalTransactional(name = "buy-good", rollbackFor = Exception.class)
    public boolean buy(Long userId, Long goodId, Long accountId, Integer num) {
        //购买商品的主流程
        //第一步是创建订单
        Result orderResult = createOrder(userId, new BigDecimal(100), goodId);
        //第二步调用账户服务扣减金额
        boolean accountResult = atAccountService.deductAccountBalance(userId, new BigDecimal(100), accountId);
        //第三步调用库存服务扣减对应商品库存
        boolean storageResult = atStorageService.deductInventory(goodId, num);
        if (orderResult.isResult() && accountResult && storageResult) {
            //第四步更新订单状态
            return updataOrderStatus(orderResult.getId(), 1);
        }
        return false;
    }

    @Data
    static class Result {

        private Long id;

        private boolean result;
    }
}
