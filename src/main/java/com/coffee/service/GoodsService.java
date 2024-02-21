package com.coffee.service;

import com.coffee.dao.GoodsDao;
import com.coffee.entity.Goods;
import com.coffee.entity.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;
//  获取所有商品
    public Res findAll(){
        List<Goods> list = goodsDao.findAll();
        Res res = new Res(200,"success",list);
        return res;
    }
}
