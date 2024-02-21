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

//    获取当前用户所有订单
    public Res findAll(String user) throws JsonProcessingException {
//        获取当前用户所有订单[当前的商品信息为字符串]
        List<Order> orderList = orderDao.findOrderByUser(user);
        List<OrderOutput> orderOutputs = new ArrayList<>();
//        遍历订单列表
        for (int i = 0; i < orderList.size(); i++) {
            OrderOutput orderOutput = new OrderOutput();
//            将旧订单信息转换为新订单信息
            orderOutput.OrderToOrderOutputExceptGoods(orderList.get(i));
//            获取当前订单的商品信息[字符串]
            String goodsStr = orderList.get(i).getGoods();
            ObjectMapper mapper = new ObjectMapper();
//            将商品信息字符串转换为商品数组
            Goods[] goods = mapper.readValue(goodsStr, Goods[].class);
//            将商品数组转换为新商品数组[通过checkGoods方法转换]
            orderOutput.setGoods(checkGoods(goods));
            orderOutputs.add(orderOutput);
        }
        return new Res(200,"success",orderOutputs);
    }
//    支付订单
    public Res payOrder(Order order) throws JsonProcessingException {
        Res res = new Res(400,"数据添加失败");
        LocalDateTime ldt = LocalDateTime.now();
//        生成订单id                       checkNum方法为了补0                                                                                                                     randomStr方法为了生成随机字符串，保证唯一性
        String id = "D" + ldt.getYear() + checkNum(ldt.getMonthValue()) + checkNum(ldt.getDayOfMonth()) + checkNum(ldt.getHour()) + checkNum(ldt.getMinute()) + checkNum(ldt.getSecond()) + randomStr(6);
        order.setId(id);
        List<Order> orders = orderDao.findAll();
        Order orderLast = orders.get(orders.size() - 1);
//        生成订单编号
        int number = 100;
        int newNumber = orderLast.getNumber()+1;
        if(newNumber <= 999){
            number = newNumber;
        }
        order.setNumber(number);
//        数据库操作
        int i = orderDao.addOrder(order);
        if(i == 1){
            res.setStatus(200);
            res.setMsg("数据添加成功");
//            转换订单信息[为了转换商品信息，同上一个方法一样原理]
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


//  生成随机字符串
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
//  补0
    public String checkNum(int num){
        if(num < 10){
            return "0" + num;
        }
        return ""+num;
    }
//  检查商品信息，并转化
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
