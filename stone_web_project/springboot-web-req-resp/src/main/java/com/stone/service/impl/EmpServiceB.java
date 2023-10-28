package com.stone.service.impl;

import com.stone.dao.EmpDao;
import com.stone.pojo.Emp;
import com.stone.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class EmpServiceB implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("Female");
            } else if ("2".equals(gender)) {
                emp.setGender("Male");
            }

            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("Lecturer");
            } else if ("2".equals(job)) {
                emp.setJob("Teacher");
            } else if ("3".equals(job)) {
                emp.setJob("Professor");
            }
        });
        return empList;
    }
}
