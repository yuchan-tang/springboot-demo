package com.example.springboot_demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.springboot_demo.entity.ReleaseServiceEntity;
import com.example.springboot_demo.entity.School;
import com.example.springboot_demo.entity.User;
import com.example.springboot_demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(path = "/user/{page}/{size}", method = RequestMethod.GET)
    public String getUser(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        page = (page - 1) * size;
        List<School> schools = userMapper.getSchool(2, page, size);
        log.error("{}", JSON.toJSONString(schools));
        return JSON.toJSONString(schools);
    }

//    @RequestMapping(path = "/users",method = RequestMethod.GET)
//    public String getUsers(){
//        List<User> users = userMapper.getUsers();
//        log.error("users {}",users);
//        return users.toString();
//    }
//
//    @RequestMapping(path = "/release",method = RequestMethod.GET)
//    public String getPlan(){
//        ReleaseServiceEntity releaseServiceById = userMapper.findReleaseServiceById("12321");
//        List<ReleaseServiceEntity> releaseService = userMapper.findReleaseService("12321");
//        log.error("releaseServiceById {}",releaseServiceById.toString());
//        log.error("releaseService {}",releaseService.toString());
//        return "1";
//    }
//
//    @RequestMapping(path = "/new",method = RequestMethod.GET)
//    public String getUserNew(){
//        List<User> user = userMapper.findUser(1);
//        log.error("user {}",user);
//        return user.toString();
//    }
}
