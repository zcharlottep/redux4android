package com.example.redux4android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.concurrent.Semaphore;

/**
 * Created by teresa on 2017/7/7.
 * 后台服务 用来处理异步数据
 */
public class DataService extends Service{

    private static final String TAG = DataService.class.getSimpleName();
    // 带thread的handler。
//    private ThreadHandler threadHandler;

    @Override
    public void onCreate() {
        super.onCreate();
//        threadHandler = new ThreadHandler(TAG);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


//    class ThreadHandler extends Handler{
//
//        private Semaphore semaphore = new Semaphore(0);
//        private Thread thread;
//
//        private String TAG;
//
//        public ThreadHandler(String tag){
//            this.TAG = tag;
//        }
//
//        public void start(){
//            try {
//                semaphore.acquire();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}
