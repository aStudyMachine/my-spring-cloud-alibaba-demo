package cn.studymachine.controller;

import cn.studymachine.entity.Example2ProductEntity;
import cn.studymachine.pojo.Example2ProductBo;
import cn.studymachine.service.Example4UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        Example2ProductBo bo = new Example2ProductBo().setGoodId(1L);
        List<Example2ProductEntity> master = example4UserService.selectFromMaster(bo);
        System.out.println("master = " + master);

        List<Example2ProductEntity> slave1 = example4UserService.selectFromSlave1(bo);
        System.out.println("slave1 = " + slave1);

        List<Example2ProductEntity> slave2 = example4UserService.selectFromSlave2(bo);
        System.out.println("slave2 = " + slave2);
    }
}
