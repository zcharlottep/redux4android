package com.example.redux4android.redux.action;

/**
 * Created by teresa on 2017/7/3.
 * 同步消息
 */
public class AsyncAction<T> extends Action<T>{

    public AsyncAction(String action,T t) {
        super(action,t);
    }
}
