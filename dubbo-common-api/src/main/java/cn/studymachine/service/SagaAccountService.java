package cn.studymachine.service;

public interface SagaAccountService {
    boolean accountDeduction();
    boolean compensateAccountDeduction();
}
