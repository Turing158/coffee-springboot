package com.coffee.entity;

public class OrderGoods {
    int id;
    String name;
    int num;
    String temperature;
    String sugar;

    public OrderGoods() {
    }

    public OrderGoods(int id, int num, String temperature, String sugar) {
        this.id = id;
        this.num = num;
        this.temperature = temperature;
        this.sugar = sugar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", num=" + num +
                ", temperature='" + temperature + '\'' +
                ", sugar='" + sugar + '\'' +
                '}';
    }
}
