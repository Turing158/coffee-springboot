package com.coffee.entity;

public class Res {
    int status;
    String msg;
    Object data;

    public Res(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Res(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
