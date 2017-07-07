package com.example.redux4android.redux;

import android.app.Application;
import android.util.Log;

import com.example.redux4android.redux.middleware.LogMiddleware;
import com.example.redux4android.redux.state.StateTree;

/**
 * Created by teresa on 2017/7/3.
 */
public class App extends Application{

    private static final String TAG = App.class.getSimpleName();
    public static Store store;

    @Override
    public void onCreate() {
        super.onCreate();
        if(store==null){
            Log.e(TAG,"store create");
            store = new Store(new StateTree.Builder<>().add(null).build(),
                    new LogMiddleware());
        }
    }
}
