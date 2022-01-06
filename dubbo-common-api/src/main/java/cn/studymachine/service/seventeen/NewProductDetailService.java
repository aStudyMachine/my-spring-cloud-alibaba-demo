package cn.studymachine.service.seventeen;

import cn.studymachine.bo.NewProductDetailBo;
import cn.studymachine.dto.NewProductDetailDTO;

import java.util.List;

public interface NewProductDetailService {
    Integer insert(NewProductDetailDTO newProductDetailDTO);
    List<NewProductDetailDTO> select(NewProductDetailBo newProductDetailBo);
    Integer selectTotalNum(NewProductDetailBo newProductDetailBo);

}
