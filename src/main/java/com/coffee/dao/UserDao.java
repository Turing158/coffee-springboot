package com.coffee.dao;

import com.coffee.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository
public class UserDao {
    @Resource
    JdbcTemplate jdbcTemplate;
//    检测用户是否存在
    public boolean checkUser(String user){
        String sql = "select count(*) from user where user = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, user);
        return count == 1;
    }
//    检测手机号是否存在
    public boolean checkPhone(String phone){
        String sql = "select count(*) from user where phone = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, phone);
        return count == 1;
    }
//    根据用户名查询用户
    public User findUserByUser(String user){
        String sql = "select * from user where user = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user);
    }
//    添加用户
    public int addUser(User user) {
        String sql = "insert into user(user,password,name,num,phone) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getUser(), user.getPassword(), user.getName(), user.getNum(), user.getPhone());
    }
//  删除用户
    public int deleteUser(String user){
        String sql = "delete from user where user = ?";
        return jdbcTemplate.update(sql, user);
    }
}
