package com.stone.service.impl;

import com.stone.mapper.EmpMapper;
import com.stone.pojo.Emp;
import com.stone.pojo.PageBean;
import com.stone.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        Long count = empMapper.count();


        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);


        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }
}
