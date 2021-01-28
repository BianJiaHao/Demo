package com.bjh.dubbo.service.impl;

import com.bjh.dubbo.service.DemoDubboService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 注解为apach的@Service
 * 区分项目是Provider还是Consumer最重要的依据
 */
@Service
public class DemoDubboServiceImpl implements DemoDubboService {

    @Override
    public String demo(String param) {
        System.out.println("执行了demo方法");
        return param + "ok";
    }
}
