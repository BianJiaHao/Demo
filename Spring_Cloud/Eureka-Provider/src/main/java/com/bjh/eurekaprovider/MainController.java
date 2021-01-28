package com.bjh.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired(required = false)
    private HealthStatusService healthStatusService;

    @GetMapping("getHi")
    public String getHi(){
        return "Hi";
    }

    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status){
        healthStatusService.setStatus(status);
        return healthStatusService.getStatus();
    }
}
