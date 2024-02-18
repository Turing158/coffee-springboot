package com.coffee.controller;

import com.coffee.entity.Res;
import com.coffee.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;


    @GetMapping("/goods/findAll")
    public Res findAll(){
        return goodsService.findAll();
    }

}
