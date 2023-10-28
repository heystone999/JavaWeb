package com.stone.dao.impl;

import com.stone.dao.EmpDao;
import com.stone.pojo.Emp;
import com.stone.utils.XmlParseUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParseUtils.parse(file, Emp.class);

        return empList;
    }

}
