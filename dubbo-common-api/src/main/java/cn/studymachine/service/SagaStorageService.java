package cn.studymachine.service;

public interface SagaStorageService {
    boolean storageDeduction();
    boolean compensateStorageDeduction();
}
