package cn.studymachine.controller;

import cn.studymachine.service.PayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController(value = "/pay")
public class PayController {

    @Resource
    private PayService payService;

    @GetMapping(value = "/toPay")
    public String pay(){
        payService.pay();
        return "success!";
    }
}
