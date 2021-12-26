package cn.studymachine.service.impl;

import cn.studymachine.Example4Application;
import cn.studymachine.entity.Example2ProductEntity;
import cn.studymachine.pojo.Example2ProductBo;
import cn.studymachine.service.Example4UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example4Application.class)
public class Example4UserServiceImplTest{

    @Resource
    private Example4UserService example4UserService;

    private Example2ProductBo bo = new Example2ProductBo().setGoodId(1L);
    @Test
    public void selectFromMaster() {
        List<Example2ProductEntity> entities = example4UserService.selectFromMaster(bo);
        System.out.println("从 master 查询");
        System.out.println("entities = " + entities);
    }

    @Test
    public void selectFromSlave1() {
        List<Example2ProductEntity> entities = example4UserService.selectFromSlave1(bo);
        System.out.println("从 Slave1 查询");
        System.out.println("entities = " + entities);
    }

    @Test
    public void selectFromSlave2() {
        List<Example2ProductEntity> entities = example4UserService.selectFromSlave2(bo);
        System.out.println("从 Slave2 查询");
        System.out.println("entities = " + entities);
    }
}