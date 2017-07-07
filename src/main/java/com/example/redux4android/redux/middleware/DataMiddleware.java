package com.example.redux4android.redux.middleware;

import android.support.annotation.NonNull;

import com.example.redux4android.redux.Store;
import com.example.redux4android.redux.action.Action;
import com.example.redux4android.redux.action.AsyncAction;

/**
 * Created by teresa on 2017/7/7.
 */
public class DataMiddleware<A extends Action> implements Middleware<A> {
    @Override
    public void dispatcher(@NonNull Store store, @NonNull A action, @NonNull Next<A> next) {
        if(action instanceof AsyncAction){
                //将消息发到service中进行处理
        }
        next.dispatcher(action);
    }
}
