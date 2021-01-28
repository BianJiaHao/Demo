package com.bjh.dubbo.service;

import com.bjh.pojo.Emp;

import java.util.List;

public interface EmpDubboService {
    public int insertEmp(Emp emp);
    public List<Emp> findEmpByDeptId(Integer did);
}
