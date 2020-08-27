package com.ajie.user.service;

import com.ajie.user.dao.UserDao;
import com.ajie.user.dao.po.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private UserDao userDao;
    public TestService(){
        System.out.println("service");
    }

    public String getName(){
        return "心有林夕";
    }

    public List<UserPO> listUser(){
        return userDao.listUser();
    }

    public UserPO addUser(UserPO user){
       int id =  userDao.insert(user);
        user.setId(id);
        return user;
    }

    public UserPO updateUser(UserPO user){
        user =  userDao.update(user);
        return user;
    }
}
