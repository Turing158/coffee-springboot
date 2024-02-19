package com.coffee.dao;

import com.coffee.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

public class UserDao {
    @Resource
    JdbcTemplate jdbcTemplate;

    public boolean checkUser(String user){
        String sql = "select count(*) from user where user = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, user);
        return count == 1;
    }
    public User findUserByPassword(String user){
        String sql = "select * from user where user = ?";
        return jdbcTemplate.queryForObject(sql, User.class, user);
    }

    public int addUser(User user){
        String sql = "insert into user(user,password,name,num) values(?,?,?,?)";
        return jdbcTemplate.update(sql, user.getUser(), user.getPassword(), user.getName(), user.getNum());
    }

    public int updateUser(User user){
        String sql = "update user set password = ?, name = ?, num = ? where user = ?";
        return jdbcTemplate.update(sql, user.getPassword(), user.getName(), user.getNum(), user.getUser());
    }

    public int deleteUser(String user){
        String sql = "delete from user where user = ?";
        return jdbcTemplate.update(sql, user);
    }
}
