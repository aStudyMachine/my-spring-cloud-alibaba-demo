package cn.studymachine.service;

public interface DistributedService {
    long nextId(final long datacenterId, final long machineId);
    long nextId();
}
