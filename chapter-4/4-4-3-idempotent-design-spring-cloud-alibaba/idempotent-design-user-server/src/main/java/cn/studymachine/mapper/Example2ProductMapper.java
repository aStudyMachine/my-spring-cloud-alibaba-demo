package cn.studymachine.mapper;

import cn.studymachine.bo.Example2ProductBo;
import cn.studymachine.entity.Example2ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface Example2ProductMapper extends BaseMapper<Example2ProductEntity> {
    Integer updateGoodNum(Example2ProductBo example2ProductBo);
    List<Example2ProductEntity> queryGoodInfoByGoodId(Example2ProductBo example2ProductBo);
}
