package com.bjh.activemq02.controller;

import com.bjh.activemq02.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author Obito
 * @Date 2020/12/20 下午7:24
 */
@RestController
public class MainController {

    @Autowired
    SenderService senderService;

    @RequestMapping("send")
    public String send(){
        senderService.send("user","hi");
        return "OK";
    }
}
