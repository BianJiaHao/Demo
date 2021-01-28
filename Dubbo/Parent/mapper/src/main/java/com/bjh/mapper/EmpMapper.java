package com.bjh.mapper;

import com.bjh.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    public int insertEmp(Emp emp);
    public List<Emp> findEmpByDeptId(Integer did);
}
