package com.coffee.dao;


import com.coffee.entity.Goods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class GoodsDao {
    @Resource
    JdbcTemplate jdbcTemplate;
//    查询所有商品
    public List<Goods> findAll() {
        String sql = "select * from goods ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class));
    }
}
