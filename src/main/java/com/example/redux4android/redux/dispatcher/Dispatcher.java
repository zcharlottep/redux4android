package com.example.redux4android.redux.dispatcher;

/**
 * Created by teresa on 2017/7/3.
 * Dispatcher 基类
 */
public abstract class Dispatcher {

    private static Dispatcher dispatcher;

    public Dispatcher(){}

    public static Dispatcher getInstance(){
        synchronized (Dispatcher.class){
            if(dispatcher==null){
                synchronized (Dispatcher.class){
                    if(dispatcher==null){
                        dispatcher = new EventBusDispatcher();
                    }
                    return dispatcher;
                }
            }
            return dispatcher;
        }
    }

    /**
     * 注册订阅者
     */
    abstract public void register(Object subscribe);

    /**
     * 反注册订阅者
     */
    abstract public void unregister(Object subscribe);

    /**
     * 发送消息
     */
    abstract public void post(Object event);
}
