package com.bjh.controller;

import com.bjh.Person;
import com.bjh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/show")
    public List<Person> show(){
        return personService.show();
    }
}
