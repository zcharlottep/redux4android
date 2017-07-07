package com.example.redux4android.redux.action;

/**
 * Created by teresa on 2017/7/3.
 */
public class NetRequestAction<T> extends AsyncAction<T> {
    public NetRequestAction(String action,T t) {
        super(action,t);
    }
}
