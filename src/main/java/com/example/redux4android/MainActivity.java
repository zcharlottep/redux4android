package com.example.redux4android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.redux4android.redux.App;
import com.example.redux4android.redux.Store;
import com.example.redux4android.redux.action.ActionCreator;
import com.example.redux4android.redux.state.State;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 这是一个基于redux框架的网络请求test
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request = (Button) findViewById(R.id.request);
        request.setOnClickListener(this);
        Log.e(TAG,"store:"+App.store);
        App.store.register(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.request:
                //网络请求
                String uri = "http://www.baidu.com";
                ActionCreator.makeRequestAction(uri);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onStateChanged(State state){
        Log.e(TAG,TAG +"received : onStateChanged");
    }
}
