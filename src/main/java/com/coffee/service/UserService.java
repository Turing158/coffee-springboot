package com.coffee.service;

import com.coffee.dao.UserDao;
import com.coffee.entity.Res;
import com.coffee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
//  登录
    public Res login(String user,String password){
        Res res = new Res();
//        判断用户是否存在
        boolean checkUser = userDao.checkUser(user);
        if(!checkUser){
            res.setStatus(400);
            res.setMsg("用户不存在");
            return res;
        }else{
            User userObj = userDao.findUserByUser(user);
//            判断密码是否正确
            if(!userObj.getPassword().equals(password)){
                res.setStatus(400);
                res.setMsg("密码错误");
            }else{
                res.setStatus(200);
                res.setMsg("success");
                res.setData(userObj);
            }
            return res;
        }
    }
//  注册
    public Res reg(String user,String password,String phone){
        Res res = new Res();
//        判断用户是否存在
        if(userDao.checkUser(user)){
            res.setStatus(400);
            res.setMsg("用户名已存在");
            return res;
        }
//        判断手机号是否存在
        else if(userDao.checkPhone(phone)){
            res.setStatus(400);
            res.setMsg("手机号已存在");
            return res;
        }
        else{
            User userObj = new User(user,password,"新用户",0,phone);
            int i = userDao.addUser(userObj);
//            判断是否注册成功
            if(i == 1){
                res.setStatus(200);
                res.setMsg("success");
            }else{
                res.setStatus(400);
                res.setMsg("注册失败");
            }
        }
        return res;
    }
}
