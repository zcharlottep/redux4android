package com.example.redux4android.redux.middleware;

import android.support.annotation.NonNull;

import com.example.redux4android.redux.Store;
import com.example.redux4android.redux.action.Action;

/**
 * Created by teresa on 2017/7/3.
 * middleware 中间件（做一些必要的处理，例如用于打印log活着处理异步消息etc）
 */
public interface Middleware<A extends Action> {

    void dispatcher(@NonNull Store store, @NonNull A action, @NonNull Next<A> next);
}
