package com.example.redux4android.redux.middleware;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.redux4android.redux.Store;
import com.example.redux4android.redux.action.Action;

/**
 * Created by teresa on 2017/7/3.
 */
public class LogMiddleware<A extends Action> implements Middleware<A> {
    private static final String TAG = LogMiddleware.class.getSimpleName();

    @Override
    public void dispatcher(@NonNull Store store, @NonNull A action, @NonNull Next<A> next) {
        Log.e(TAG,"action:"+action.getAction().toString());
        next.dispatcher(action);
    }
}
