package cn.studymachine.service.seventeen;

import cn.studymachine.bo.ProductInfoBo;
import cn.studymachine.dto.ProductInfoDTO;
import java.util.List;

public interface ProductInfoService {
    Integer insert(ProductInfoDTO productInfoDTO);
    List<ProductInfoDTO> select(ProductInfoBo productInfoBo);
    Integer selectTotalNum(ProductInfoBo productInfoBo);
}