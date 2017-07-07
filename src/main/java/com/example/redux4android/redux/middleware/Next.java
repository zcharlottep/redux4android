package com.example.redux4android.redux.middleware;

import android.support.annotation.NonNull;

import com.example.redux4android.redux.action.Action;

/**
 * Created by teresa on 2017/7/5.
 */
public interface Next<A extends Action> {

    void dispatcher(@NonNull A action);
}
