package com.stone.comtroller;

import com.stone.pojo.Emp;
import com.stone.pojo.PageBean;
import com.stone.pojo.Result;
import com.stone.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询，参数:{},{}", page, pageSize);
        PageBean pageBean = empService.page(page, pageSize);
        log.info(pageBean.toString());
        return Result.success(pageBean);
    }
}
