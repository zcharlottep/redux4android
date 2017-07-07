package com.example.redux4android.redux.action;



import com.example.redux4android.redux.App;

/**
 * Created by teresa on 2017/7/3.
 * action创建者，创建不同类型的action
 */
public class ActionCreator {

    public static void makeRequestAction(String action, Object... params) {
        Action _action  = new NetRequestAction(action,params);
        App.store.dispatch(_action);
    }
}
