package com.bjh.service.impl;

import com.bjh.dubbo.service.DeptDubboService;
import com.bjh.dubbo.service.EmpDubboService;
import com.bjh.pojo.Dept;
import com.bjh.pojo.Emp;
import com.bjh.service.EmpService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class EmpServiceImpl implements EmpService {

    @Reference
    private DeptDubboService deptDubboService;

    @Reference
    private EmpDubboService empDubboService;

    @Override
    public List<Dept> showAll() {
        return deptDubboService.findAllDept();
    }

    @Override
    public int insert(Emp emp, MultipartFile file) {
       try{
        //通过spring容器并获取HttpServletRequest对象
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        //通过HttpServletRequest对象，获取图片上传的路径
        String path = request.getServletContext().getRealPath("/img");
        System.out.println("path == " + path);
        //为了上传懂啊服务器的图片名称不重复，编写随机数
        long currentTimeMillis = System.currentTimeMillis();
        Random random = new Random();

        String filename = currentTimeMillis + " " + random.nextInt(1000);
        String oldname = file.getOriginalFilename();
        //通过原图片的原名称获取图片的后缀名
        filename += oldname.substring(oldname.lastIndexOf("."));

        File pathFile = new File(path);
        //第一次上传，检查目录是否存在
        if( !pathFile.exists() ){
            pathFile.mkdirs();
        }

        //图片上传

            file.transferTo(new File(path,filename));
            //封装emp对象，把图片路径封装到emp对象中
            emp.setPhoto("http://localhost:8081/img/" + filename);
            return empDubboService.insertEmp(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return 0;
    }
}
