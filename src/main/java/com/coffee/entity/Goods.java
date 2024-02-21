package com.coffee.entity;

public class Goods {
    int id;
    String name;
    String introduce;
    double price;
    String classname;
    String temperature;
    String sugar;
    String img;
    int num;



    public Goods() {
    }

    public Goods(int id, String name, String introduce, double price, String classname, String img, String sugar, String temperature) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.price = price;
        this.classname = classname;
        this.img = img;
        this.sugar = sugar;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
