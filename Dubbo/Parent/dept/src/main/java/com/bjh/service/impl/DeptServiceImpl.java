package com.bjh.service.impl;

import com.bjh.dubbo.service.DeptDubboService;
import com.bjh.dubbo.service.EmpDubboService;
import com.bjh.pojo.Dept;
import com.bjh.pojo.Emp;
import com.bjh.service.DeptService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {

    @Reference
    private DeptDubboService deptDubboService;

    @Reference
    private EmpDubboService empDubboService;

    @Override
    public List<Dept> findAll() {
        return deptDubboService.findAllDept();
    }

    @Override
    public List<Emp> findEmpByDeptId(Integer did) {
        return empDubboService.findEmpByDeptId(did);
    }
}
