package com.bjh.dubbo.service.impl;

import com.bjh.dubbo.service.DeptDubboService;
import com.bjh.mapper.DeptMapper;
import com.bjh.pojo.Dept;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class DeptDubboServiceImpl implements DeptDubboService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAll();
    }
}
