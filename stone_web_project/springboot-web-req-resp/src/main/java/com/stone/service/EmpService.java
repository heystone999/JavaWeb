package com.stone.service;

import com.stone.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmpService {
    public List<Emp> listEmp();
}
