package com.stone.controller;

import com.stone.pojo.Emp;
import com.stone.pojo.Result;
import com.stone.utils.XmlParseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result list() {
//        加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParseUtils.parse(file, Emp.class);

//        数据转换处理
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("女");
            } else if ("2".equals(gender)) {
                emp.setGender("男");
            }

            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("教授");
            }
        });
        return Result.success(empList);
    }
}
