package cn.studymachine.controller;

import cn.studymachine.service.Example4UserService;
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

    private final Example4UserService example4UserService;

    /*---------------------------------------------- Methods ~ ----------------------------------------------*/

    @GetMapping("test")
    public void test() {

    }
}
