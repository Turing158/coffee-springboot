package com.coffee.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

public class UserDao {
    @Resource
    JdbcTemplate jdbcTemplate;

}
