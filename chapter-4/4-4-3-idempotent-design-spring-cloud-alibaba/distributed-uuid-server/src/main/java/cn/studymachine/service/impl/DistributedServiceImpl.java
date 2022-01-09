package cn.studymachine.service.impl;

import cn.studymachine.config.SnowflakeConfig;
import cn.studymachine.config.SnowflakeInfo;
import cn.studymachine.service.DistributedService;
import cn.studymachine.util.NetUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@DubboService(version = "1.0.0",group = "distributed-uuid-server")
public class DistributedServiceImpl implements DistributedService {

    @Resource
    private SnowflakeConfig snowflakeConfig;

   private final Map<String, SnowFlake> snowFlakeHandlerMap = new ConcurrentHashMap<>();

    @Override
    public long nextId(final long datacenterId, final long machineId) {
        final long sdatacenterId = datacenterId;
        final long smachineId = machineId;
        final String handler = sdatacenterId + "_" + smachineId;
        SnowFlake snowFlake;
        if (snowFlakeHandlerMap.containsKey(handler)) {
            snowFlake = snowFlakeHandlerMap.get(handler);
            return snowFlake.nextId();
        } else {
            snowFlake = new SnowFlake(datacenterId, machineId);
            snowFlakeHandlerMap.putIfAbsent(handler, snowFlake);
            snowFlake = snowFlakeHandlerMap.get(handler);
            return snowFlake.nextId();
        }
    }

    @Override
    public long nextId() {
        List<SnowflakeInfo> config = snowflakeConfig.getConfig();
        String localAddress = NetUtils.getLocalAddress();
        SnowflakeInfo snowflakeInfo = config.stream().filter(s -> Objects.equals(s.getIp(), localAddress)).findFirst()
                .orElse(null);
        long dataCenterId = Optional.ofNullable(snowflakeInfo).map(SnowflakeInfo::getDataCenterId).orElse(0L);
        long machineId = Optional.ofNullable(snowflakeInfo).map(SnowflakeInfo::getMachineId).orElse(0L);
        return nextId(dataCenterId, machineId);
    }
}
