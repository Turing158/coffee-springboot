package com.coffee.service;

import com.coffee.dao.GoodsDao;
import com.coffee.dao.OrderDao;
import com.coffee.entity.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    GoodsDao goodsDao;


    public Res findAll(String user){
        List<Order> list = orderDao.findOrderByUser(user);
        Res res = new Res(200,"success",list);
        return res;
    }

    public Res payOrder(Order order) throws JsonProcessingException {
        Res res = new Res(400,"数据添加失败");
        LocalDateTime ldt = LocalDateTime.now();
        String id = "D" + ldt.getYear() + checkNum(ldt.getMonthValue()) + checkNum(ldt.getDayOfMonth()) + checkNum(ldt.getHour()) + checkNum(ldt.getMinute()) + checkNum(ldt.getSecond()) + randomStr(6);
        order.setId(id);
        List<Order> orders = orderDao.findAll();
        Order orderLast = orders.get(orders.size() - 1);
        int number = 100;
        int newNumber = orderLast.getNumber()+1;
        if(newNumber <= 999){
            number = newNumber;
        }
        order.setNumber(number);
        int i = orderDao.addOrder(order);
        if(i == 1){
            res.setStatus(200);
            res.setMsg("数据添加成功");
            List<Goods> goodsList = goodsDao.findAll();
            OrderOutput orderOutput = new OrderOutput();
            orderOutput.setId(order.getId());
            String goodsStr = order.getGoods();
            ObjectMapper mapper = new ObjectMapper();
            Goods[] goods =  mapper.readValue(goodsStr, Goods[].class);
            for (int j = 0; j < goods.length; j++) {
                for (int k = 0; k < goodsList.size(); k++) {
                    if (goods[j].getId() == goodsList.get(k).getId()){
                        goods[j].setImg(goodsList.get(k).getImg());
                        goods[j].setName(goodsList.get(k).getName());
                        goods[j].setPrice(goodsList.get(k).getPrice());
                    }
                }
            }
            orderOutput.setGoods(goods);
            orderOutput.setUser(order.getUser());
            orderOutput.setDate(order.getDate());
            orderOutput.setPrice(order.getPrice());
            orderOutput.setStatus(order.getStatus());
            orderOutput.setNumber(order.getNumber());
            orderOutput.setUseForm(order.getUseForm());
            orderOutput.setReservation(order.getReservation());
            orderOutput.setNote(order.getNote());
            res.setData(orderOutput);
        }
        return res;
    }



    public String randomStr(int length){
        String result = "";
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random(new Date().getTime());
        for (int i = 0; i < length; i++) {
            int rnum = r.nextInt(str.length());
            result += str.charAt(rnum);
        }
        return result;
    }
    public String checkNum(int num){
        if(num < 10){
            return "0" + num;
        }
        return ""+num;
    }
}
