package cn.studymachine.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.studymachine.pojo.UserDTO;
import cn.studymachine.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wukun
 * @since 2021/12/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO getLoginUser() {
        List<UserDTO> userCache=new ArrayList<>();
        UserDTO userDTO1=new UserDTO();
        userDTO1.setTenantId(6767L);
        userDTO1.setName("租户A");
        userCache.add(userDTO1);

        UserDTO userDTO2=new UserDTO();
        userDTO2.setTenantId(7878L);
        userDTO2.setName("租户B");
        userCache.add(userDTO2);

        UserDTO userDTO3=new UserDTO();
        userDTO2.setTenantId(8989L);
        userDTO2.setName("租户C");
        userCache.add(userDTO3);
        int index= RandomUtil.randomInt(0,2);
        return userCache.get(index);
    }

    /*---------------------------------------------- Fields ~ ----------------------------------------------*/



    /*---------------------------------------------- Methods ~ ----------------------------------------------*/

}
