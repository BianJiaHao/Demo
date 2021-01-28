package com.bjh.service;

import com.bjh.pojo.Dept;
import com.bjh.pojo.Emp;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();
    public List<Emp> findEmpByDeptId(Integer did);
}
