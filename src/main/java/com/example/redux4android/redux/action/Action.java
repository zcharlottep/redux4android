package com.example.redux4android.redux.action;

/**
 * Created by teresa on 2017/7/3.
 * action 基类
 */
public class Action<T> {

    private final String action;
    private final T t;
    public Action(String action ,T t) {
        this.action =action;
        this.t =t;
    }

    public String getAction() {
        return action;
    }
    public T getParameter(){return t;}

    @Override
    public String toString() {
        return "Action{" +
                "action='" + action + '\'' +
                ", t=" + t +
                '}';
    }
}
