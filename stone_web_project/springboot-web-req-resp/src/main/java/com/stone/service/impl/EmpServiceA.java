package com.stone.service.impl;

import com.stone.dao.EmpDao;
import com.stone.dao.impl.EmpDaoA;
import com.stone.pojo.Emp;
import com.stone.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
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
        return empList;
    }
}
