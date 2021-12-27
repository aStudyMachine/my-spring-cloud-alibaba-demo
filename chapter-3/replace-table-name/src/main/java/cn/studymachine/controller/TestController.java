package cn.studymachine.controller;

import cn.studymachine.entity.Example5OrderEntity;
import cn.studymachine.mapper.Example5OrderMapper;
import cn.studymachine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wukun
 * @since 2021/12/26
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    /*---------------------------------------------- Fields ~ ----------------------------------------------*/

    private final Example5OrderMapper example5OrderMapper;

    private final UserService userService;

    /*---------------------------------------------- Methods ~ ----------------------------------------------*/

    @GetMapping("test")
    public void test() {
        Example5OrderEntity example5OrderEntity = example5OrderMapper.selectOrder();
        System.out.println("example5OrderEntity = " + example5OrderEntity);
    }
}
