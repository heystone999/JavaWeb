package com.stone.mapper;

import com.stone.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into dept_log (create_time,description) values (#{createTime},#{description})")
    void insert(DeptLog log);
}
