package com.coffee.dao;

import com.coffee.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class OrderDao {
    @Resource
    JdbcTemplate jdbcTemplate;

//    查询该用户所有订单
    public List<Order> findOrderByUser(String user){
        String sql = "select * from orders where user = ? order by date desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Order.class), user);
    }
//    查询所有订单
    public List<Order> findAll(){
        String sql = "select * from orders";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Order.class));
    }
//    添加订单
    public int addOrder(Order order){
        String sql = "insert into orders values(?,?,?,?,?,?,?,?,?,?)";
        Object[] args = {order.getId(), order.getGoods(), order.getUser(), order.getDate(), order.getPrice(), order.getStatus(), order.getNumber(), order.getUseForm(), order.getReservation(), order.getNote()};
        return jdbcTemplate.update(sql, args);
    }

}
