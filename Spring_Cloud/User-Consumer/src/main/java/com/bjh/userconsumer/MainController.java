package com.bjh.userconsumer;

import com.bjh.userapi.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    ConsumerApi api;

    @GetMapping("/alive")
    public String alive(){
        return api.alive();
    }

    @GetMapping("/map")
    public Map<Integer, String> map(Integer id){
        System.out.println(id);
        return api.getMap(id);
    }

    @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id,String name){
        System.out.println("id=" + id + "name=" + name);
        return api.getMap2(id,name);
    }

    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map){
        System.out.println(map);
        return api.getMap3(map);
    }

    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map){
        System.out.println(map);
        return api.postMap(map);
    }

    @GetMapping("/postPerson")
    public Person postPerson(@RequestParam Map<String, Object> map) {

        System.out.println(map);

        Person person = new Person();
        person.setId(Integer.parseInt(map.get("id").toString()));
        person.setName("xxoo");
        return api.postPerson(person);
    };
}
