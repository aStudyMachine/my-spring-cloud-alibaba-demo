package cn.studymachine.service;


import cn.studymachine.dto.UserDTO;
import cn.studymachine.request.UserServiceRequest;
import cn.studymachine.response.DefaultResult;

import java.util.List;

public interface UserService {
    DefaultResult<List<UserDTO>> getUserInfo(UserServiceRequest userServiceRequest);
}
