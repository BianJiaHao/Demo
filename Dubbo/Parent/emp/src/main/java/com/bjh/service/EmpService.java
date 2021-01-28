package com.bjh.service;

import com.bjh.pojo.Dept;
import com.bjh.pojo.Emp;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmpService {
    public List<Dept> showAll();

    public int insert(Emp emp, MultipartFile file);
}
