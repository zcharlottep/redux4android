package com.example.redux4android.redux.middleware;

import android.support.annotation.NonNull;

import com.example.redux4android.redux.Store;
import com.example.redux4android.redux.action.Action;

/**
 * Created by teresa on 2017/7/3.
 */
public interface Middleware<A extends Action> {

    void dispatcher(@NonNull Store store, @NonNull A action, @NonNull Next<A> next);
}
