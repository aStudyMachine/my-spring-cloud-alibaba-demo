package cn.studymachine.controller;

import cn.studymachine.service.RibbonDiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Autowired
    private RibbonDiscoveryService ribbonDiscoveryService;

    @GetMapping(value = "/getRibbonConfig")
    @ResponseBody
    public String testRestRibbon() {
        return ribbonDiscoveryService.getRibbonConfig();
    }
}
