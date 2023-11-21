package com.stone.service;

import com.stone.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void save(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
