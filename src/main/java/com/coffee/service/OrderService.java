package com.coffee.service;

import com.coffee.dao.OrderDao;
import com.coffee.entity.Order;
import com.coffee.entity.OrderGoods;
import com.coffee.entity.OrderOutput;
import com.coffee.entity.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;


    public Res findAll(String user){
        List<Order> list = orderDao.findOrderByUser(user);
        Res res = new Res(200,"success",list);
        return res;
    }

    public Res payOrder(Order order){
        Res res = new Res(400,"数据添加失败");
        LocalDateTime ldt = LocalDateTime.now();
        Random r = new Random();
        String id = "" + ldt.getYear() + ldt.getMonthValue() + ldt.getDayOfMonth() + ldt.getHour() + ldt.getMinute() + ldt.getSecond() + "随机数";
        Order orderObj = new Order();
//        int i = orderDao.addOrder(order);
//        if(i == 1){
//            res.setStatus(200);
//            res.setMsg("数据添加成功");
//        }
        return res;
    }
}
