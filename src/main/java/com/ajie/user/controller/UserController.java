package com.ajie.user.controller;

import com.ajie.chilli.server.Server;
import com.ajie.chilli.utils.common.StringUtils;
import com.ajie.user.dao.po.UserPO;
import com.ajie.user.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {

    @Resource
    TestService testService;

    @Resource
    Server server;

    public UserController(){
        System.out.println("userController");
    }

    @RequestMapping("/test")
    String test(HttpServletRequest request, HttpServletResponse response){
      //  String name = request.getParameter("name");
        String name = testService.getName();
        if(StringUtils.isEmpty(name)){
            name = "world";
        }
        return "hello "+ name+"!";
    }

    @RequestMapping("/list_user")
    public List<UserPO> listUser(){
        List<UserPO>  list =  testService.listUser();
        System.out.println(list.size());
        return list;
    }
    @RequestMapping("/add_user")
    public UserPO add(HttpServletRequest request,HttpServletResponse response){
        UserPO user = new UserPO();
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        int iId = 0;
        try {
            iId = Integer.valueOf(id);
        }catch (Exception e){

        }
        user.setId(iId);
        user.setName(name);
        user =  testService.addUser(user);
        return user;
    }

    @RequestMapping("/update")
    public UserPO update(HttpServletRequest request,HttpServletResponse response){
        UserPO user = new UserPO();
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        user.setId(Integer.valueOf(id));
        user.setName(name);
        return testService.updateUser(user);
    }




    @RequestMapping("get_server")
    public Server getServer(){
        return server;
    }
}
