package com.coffee.entity;

import java.util.ArrayList;

public class OrderOutput {
    String id;
    ArrayList<OrderGoods> goods;
    String user;
    String date;
    double price;
    int status;
    int num;

    public OrderOutput() {
    }

    public OrderOutput(String id, ArrayList<OrderGoods> goods, String user, String date, double price, int status, int num) {
        this.id = id;
        this.goods = goods;
        this.user = user;
        this.date = date;
        this.price = price;
        this.status = status;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<OrderGoods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<OrderGoods> goods) {
        this.goods = goods;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OrderOutput{" +
                "id='" + id + '\'' +
                ", goods=" + goods +
                ", user='" + user + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", num=" + num +
                '}';
    }
}
