package com.example.redux4android.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by teresa on 2017/7/7.
 * 带handler的thread
 */
public class HandlerThread extends Thread{

    private  String TAG;
    private Semaphore semaphore = new Semaphore(0);
    private ThreadHandler threadHandler;
    Runnable target;
    private final static int Message_Quit = -1;
    private List<OnHandleListener> handleListeners = new ArrayList<>();

    public HandlerThread(){
        super();
    }
    
    public HandlerThread(String tag){
        this.TAG = tag;
    }

    @Override
    public synchronized void start() {
        super.start();
        try {
            acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface OnHandleListener{
        void handleMessage(Message msg);
    }

    public void setOnHandleListener(OnHandleListener listener){
        if(!handleListeners.contains(listener)){
            handleListeners.add(listener);
        }
    }

    public ThreadHandler getThreadHandler(){
        return threadHandler;
    }

    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    @Override
    public void run() {
        Looper.prepare();
        if(threadHandler==null){
            threadHandler = new ThreadHandler();
        }
        if (target != null) {
            target.run();
        }
        Looper.loop();
    }

   class ThreadHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case Message_Quit:
                    break;
                default:
                    for (int i = 0; i < handleListeners.size(); i++) {
                        handleListeners.get(i).handleMessage(msg);
                    }
                    break;
            }
        }
    }
}
