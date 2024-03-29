package com.coffee.entity;

public class User {
    String user;
    String password;
    String name;
    int num;
    String phone;

    public User() {

    }

    public User(String user, String password, String name, int num, String phone) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.num = num;
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
