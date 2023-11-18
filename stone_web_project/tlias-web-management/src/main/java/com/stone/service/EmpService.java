package com.stone.service;

import com.stone.pojo.Emp;
import com.stone.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize);
}
