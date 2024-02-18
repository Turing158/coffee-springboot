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

    public Res findAll(){
        List<Goods> a = goodsDao.findAll();
        System.out.println(a.toString());
        Res res = new Res(200,"success",a);
        return res;
    }
}
