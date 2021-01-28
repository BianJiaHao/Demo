package com.bjh.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//@RequestMapping("/User")
public interface UserApi {

    /**
     * 查看
     * @return
     */
    @GetMapping("/User/alive")
    public String alive();

    @GetMapping("/getById")
    public String getById(Integer id);

    @PostMapping("/postPerson")
    public Person postPerson(@RequestBody Person person);
}
