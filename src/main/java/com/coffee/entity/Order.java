package com.coffee.entity;

public class Order {
    String id;
    String goods;
    String user;
    String date;
    double price;
    int status;
    int number;
    String useForm;
    String reservation;
    String note;


    public Order() {
    }

    public Order(String id, String goods, String user, String date, double price, int status, int number, String useForm, String reservation, String note) {
        this.id = id;
        this.goods = goods;
        this.user = user;
        this.date = date;
        this.price = price;
        this.status = status;
        this.number = number;
        this.useForm = useForm;
        this.reservation = reservation;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUseForm() {
        return useForm;
    }

    public void setUseForm(String useForm) {
        this.useForm = useForm;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", goods='" + goods + '\'' +
                ", user='" + user + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", number=" + number +
                ", useForm='" + useForm + '\'' +
                ", reservation='" + reservation + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
