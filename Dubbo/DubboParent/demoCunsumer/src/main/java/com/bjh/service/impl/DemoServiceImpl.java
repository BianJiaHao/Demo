package com.bjh.service.impl;

import com.bjh.dubbo.service.DemoDubboService;
import com.bjh.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Reference(loadbalance = "roundrobin")
    private DemoDubboService demoDubboService;

    @Override
    public String demo() {
        return demoDubboService.demo("Obito");
    }
}
