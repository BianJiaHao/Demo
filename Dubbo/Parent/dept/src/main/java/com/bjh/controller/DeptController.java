package com.bjh.controller;

import com.bjh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept")
    public String showDept(Model model){
        model.addAttribute("list",deptService.findAll());
        return "dept";
    }

    @GetMapping("/showEmp")
    public String showEmp(Integer did,Model model){
        model.addAttribute("list",deptService.findEmpByDeptId(did));
        return "showEmp";
    }
}
