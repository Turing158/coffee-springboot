package com.coffee.service;

import com.coffee.dao.OrderDao;
import com.coffee.entity.Order;
import com.coffee.entity.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;


    public Res findAll(String user){
        List<Order> list = orderDao.findOrderByUser(user);
        Res res = new Res(200,"success",list);
        return res;
    }
}
