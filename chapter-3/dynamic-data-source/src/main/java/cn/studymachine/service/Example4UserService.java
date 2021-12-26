package cn.studymachine.service;

import cn.studymachine.entity.Example2ProductEntity;
import cn.studymachine.pojo.Example2ProductBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wukun
 * @since 2021/12/23
 */
public interface Example4UserService  extends IService<Example2ProductEntity> {

    /*---------------------------------------------- Fields ~ ----------------------------------------------*/

    List<Example2ProductEntity> selectFromMaster(Example2ProductBo example2ProductBo);

    List<Example2ProductEntity> selectFromSlave1(Example2ProductBo example2ProductBo);

    List<Example2ProductEntity> selectFromSlave2(Example2ProductBo example2ProductBo);

    /*---------------------------------------------- Methods ~ ----------------------------------------------*/

}
