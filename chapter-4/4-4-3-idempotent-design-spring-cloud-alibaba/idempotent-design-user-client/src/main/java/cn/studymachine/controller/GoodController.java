package cn.studymachine.controller;

import cn.studymachine.bo.Example2ProductBo;
import cn.studymachine.config.NacosConfig;
import cn.studymachine.dto.GoodDTO;
import cn.studymachine.request.GoodServiceRequest;
import cn.studymachine.response.DefaultResult;
import cn.studymachine.service.DistributedService;
import cn.studymachine.service.GoodService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/good")
public class GoodController {
    @DubboReference(version = "1.0.0", group = "idempotent-design-user-server", retries = 4,timeout = 1)
    private GoodService goodService;

    @DubboReference(version = "1.0.0", group = "distributed-uuid-server")
    private DistributedService distributedService;

    @Autowired
    private NacosConfig nacosConfig;

    @PostMapping(value = "/updataGoodNum")
    @ResponseBody
    public DefaultResult<GoodDTO> updateGoodNum(@RequestParam String goodId) {
        long uuid = distributedService.nextId(7, 8);
        GoodServiceRequest<Example2ProductBo> request = new GoodServiceRequest<Example2ProductBo>();
        Example2ProductBo example2ProductBo = new Example2ProductBo();
        example2ProductBo.setGoodId(Long.valueOf(goodId));
        request.setRequestData(example2ProductBo);
        if (nacosConfig.isMideng()) {
            request.setUuid(uuid + "");
        }
        return goodService.updateGoodNum(request);
    }
}
