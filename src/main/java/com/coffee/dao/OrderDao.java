package com.coffee.dao;

import com.coffee.entity.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class OrderDao {
    @Resource
    JdbcTemplate jdbcTemplate;


    public List<Order> findOrderByUser(String user){
        String sql = "select * from orders where user = ? order by date desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Order.class), user);
    }

    public int addOrder(Order order){
        String sql = "insert into orders(id,goods,user,date,price,status) values(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, order.getId(), order.getGoods(), order.getUser(), order.getDate(), order.getPrice(), order.getStatus());
    }
}
