package cn.studymachine.service.seventeen;

import cn.studymachine.bo.NewBaseProductInfoBo;
import cn.studymachine.dto.NewBaseProductInfoDTO;

import java.util.List;

public interface NewBaseProductInfoService {
    Integer insert(NewBaseProductInfoDTO newBaseProductInfoDTO);
    List<NewBaseProductInfoDTO> select(NewBaseProductInfoBo newBaseProductInfoBo);
    Integer selectTotalNum(NewBaseProductInfoBo newBaseProductInfoBo);
}
