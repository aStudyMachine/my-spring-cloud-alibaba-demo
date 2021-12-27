package cn.studymachine.controller;

import cn.studymachine.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/good")
public class GoodController {

//    @DubboReference(group = "example11",version = "1.0.0")
//    private GoodService goodService;

    @Autowired
    private GoodService goodService;

    @GetMapping(value = "getGoodName")
    public String getGoodName(){
        return goodService.getGoodName();
    }

}
