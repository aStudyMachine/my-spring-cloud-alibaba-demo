package cn.studymachine.service;

import cn.studymachine.pojo.UserDTO;

/**
 * @author wukun
 * @since 2021/12/27
 */
public interface UserService {

    /**
     * 每次调用随机返回一个租户
     *
     * @return the login user
     */
    UserDTO getLoginUser();
}
