package cn.studymachine.service;

public interface SagaOrderService {
    boolean createOrder();
    boolean compensateCreateOrder();
}
