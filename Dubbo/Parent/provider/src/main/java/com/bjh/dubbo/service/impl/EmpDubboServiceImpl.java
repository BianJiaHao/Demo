package com.bjh.dubbo.service.impl;

import com.bjh.dubbo.service.EmpDubboService;
import com.bjh.mapper.EmpMapper;
import com.bjh.pojo.Emp;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class EmpDubboServiceImpl implements EmpDubboService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int insertEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public List<Emp> findEmpByDeptId(Integer did) {
        return empMapper.findEmpByDeptId(did);
    }
}
