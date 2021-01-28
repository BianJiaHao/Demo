package com.bjh.eurekaconsumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    DiscoveryClient client;


    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient client2;

    @Autowired
    LoadBalancerClient lb;

    @GetMapping("/getHi")
    public String getHi(){
        return "Hi";
    }

    @GetMapping("/client")
    public String client(){
        List<String> services = client.getServices();
        for(String str : services){
            System.out.println(str);
        }
        return "Hi";
    }

    @GetMapping("/client2")
    public Object client2(){
        return client.getInstances("provider");
    }

    @GetMapping("/client3")
    public Object client3(){
        List<InstanceInfo> instances = client2.getInstancesByVipAddress("provider", false);
        for(InstanceInfo ins : instances){
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }
        if(instances.size() > 0){
            InstanceInfo instanceInfo = instances.get(0);
            if(instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP){
                String url = "http://" + instanceInfo.getHostName() + ":" +instanceInfo.getPort() + "/getHi";
                System.out.println(url);

                RestTemplate restTemplate = new RestTemplate();
                String object = restTemplate.getForObject(url, String.class);
                System.out.println(object);
            }
        }
        return "ok";
    }


    @GetMapping("/client4")
    public String client4(){
        //ribbon 完成客户端的负载均衡
        ServiceInstance instance = lb.choose("provider");
        String url = "http://" + instance.getHost() + ":" +instance.getPort() + "/getHi";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject(url, String.class);
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        //System.out.println("Object:" + object);
        //System.out.println("Entity:" + entity);
        return "xxoo";
    }

    @GetMapping("/client5")
    public Object client5(){
        String url = "http://192.168.16.101:80/getHi";
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject(url, String.class);
        System.out.println("Object:" + object);
        return object;
    }


}
