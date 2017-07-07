package com.example.redux4android.redux.action;

/**
 * Created by teresa on 2017/7/3.
 */
public class SyncAction<T> extends Action<T>{

    public SyncAction(String action,T t) {
        super(action,t);
    }
}
