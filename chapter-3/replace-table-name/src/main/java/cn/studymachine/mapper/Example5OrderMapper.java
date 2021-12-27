package cn.studymachine.mapper;

import cn.studymachine.entity.Example5OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author wukun
 * @since 2021/12/27
 */
public interface Example5OrderMapper extends BaseMapper<Example5OrderEntity> {

    Example5OrderEntity selectOrder();

}

