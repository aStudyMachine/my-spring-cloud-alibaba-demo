package cn.studymachine.mapper;

import cn.studymachine.entity.Example2ProductEntity;
import cn.studymachine.pojo.Example2ProductBo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wukun
 * @since 2021/12/23
 */
public interface Example2ProductMapper extends BaseMapper<Example2ProductEntity> {

    List<Example2ProductEntity> queryGoodInfoByGoodId(@Param("bo") Example2ProductBo example2ProductBo);
}
