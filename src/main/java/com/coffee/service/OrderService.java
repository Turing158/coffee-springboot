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


    public Res findAll(String user) throws JsonProcessingException {
        List<Order> orderList = orderDao.findOrderByUser(user);
        List<OrderOutput> orderOutputs = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            OrderOutput orderOutput = new OrderOutput();
            orderOutput.OrderToOrderOutputExceptGoods(orderList.get(i));
            String goodsStr = orderList.get(i).getGoods();
            ObjectMapper mapper = new ObjectMapper();
            Goods[] goods = mapper.readValue(goodsStr, Goods[].class);
            orderOutput.setGoods(checkGoods(goods));
            orderOutputs.add(orderOutput);
        }
        return new Res(200,"success",orderOutputs);
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
            OrderOutput orderOutput = new OrderOutput();
            orderOutput.OrderToOrderOutputExceptGoods(order);
            String goodsStr = order.getGoods();
            ObjectMapper mapper = new ObjectMapper();
            Goods[] goods =  mapper.readValue(goodsStr, Goods[].class);
            orderOutput.setGoods(checkGoods(goods));
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
    public Goods[] checkGoods(Goods[] goods){
        List<Goods> goodsList = goodsDao.findAll();
        for (int i = 0; i < goods.length; i++) {
            for (int j = 0; j < goodsList.size(); j++) {
                if (goods[i].getId() == goodsList.get(j).getId()){
                    goods[i].setImg(goodsList.get(j).getImg());
                    goods[i].setName(goodsList.get(j).getName());
                    goods[i].setPrice(goodsList.get(j).getPrice());
                }
            }
        }
        return goods;
    }
}
