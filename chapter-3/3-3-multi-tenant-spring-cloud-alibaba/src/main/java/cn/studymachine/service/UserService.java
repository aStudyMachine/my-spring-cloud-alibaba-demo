package cn.studymachine.service;

import cn.studymachine.entity.UserEntity;
import cn.studymachine.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper,UserEntity> {

    @Resource
    private UserMapper userMapper;

    public List<UserEntity>  getUserAndAddr(String userName){
        return userMapper.getUserAndAddr(userName);
    }
}
