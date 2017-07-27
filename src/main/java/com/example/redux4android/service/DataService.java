package com.example.redux4android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import com.example.redux4android.thread.HandlerThread;


/**
 * Created by teresa on 2017/7/7.
 * 后台服务 用来处理异步数据
 */
public class DataService extends Service implements HandlerThread.OnHandleListener {

    private static final String TAG = DataService.class.getSimpleName();
    // 带thread的handler。
//    private ThreadHandler threadHandler;
    private HandlerThread handlerThread;

    @Override
    public void onCreate() {
        super.onCreate();
//        threadHandler = new ThreadHandler(TAG);
        handlerThread = new HandlerThread(TAG);
        handlerThread.setOnHandleListener(this);
        handlerThread.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent!=null){
            String action = intent.getAction();
            if(action!=null){
                Message message = handlerThread.getThreadHandler().obtainMessage();
                message.obj = intent;
                handlerThread.sendMessage(message);
            }
        }
        return START_STICKY;
    }

    @Override
    public void handleMessage(Message msg) {

    }

}
