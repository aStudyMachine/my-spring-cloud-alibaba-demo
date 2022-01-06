package cn.studymachine.service;

import cn.studymachine.dto.GoodDTO;
import cn.studymachine.request.GoodServiceRequest;
import cn.studymachine.response.DefaultResult;

public interface GoodService {
    DefaultResult<GoodDTO> updateGoodNum(GoodServiceRequest goodServiceRequest);
}
