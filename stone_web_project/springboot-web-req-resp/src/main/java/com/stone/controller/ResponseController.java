package com.stone.controller;

import com.stone.pojo.Address;
import com.stone.pojo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
    /*@RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World ~");
        return "Hello World ~";
    }

    @RequestMapping("/getAddr")
    public Address getAddr() {
        Address addr = new Address();
        addr.setProvince("Guangdong");
        addr.setCity("Shenzhen");
        return addr;
    }

    @RequestMapping("/listAddr")
    public List<Address> listAddr() {
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("Sichuan");
        addr.setCity("Chengdu");

        Address addr2 = new Address();
        addr2.setProvince("Guangdong");
        addr2.setCity("Shenzhen");

        list.add(addr);
        list.add(addr2);

        return list;
    }*/
    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("Hello World ~");
        return Result.success("Hello World ~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setProvince("Guangdong");
        addr.setCity("Shenzhen");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("Sichuan");
        addr.setCity("Chengdu");

        Address addr2 = new Address();
        addr2.setProvince("Guangdong");
        addr2.setCity("Shenzhen");

        list.add(addr);
        list.add(addr2);

        return Result.success(list);
    }

}
