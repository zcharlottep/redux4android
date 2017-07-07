package com.example.redux4android.redux.dispatcher;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by teresa on 2017/7/3.
 */
public class EventBusDispatcher extends Dispatcher {

    @Override
    public void register(Object subscribe) {
        EventBus.getDefault().register(subscribe);
    }

    @Override
    public void unregister(Object subscribe) {
        EventBus.getDefault().unregister(subscribe);
    }

    @Override
    public void post(Object event) {
        EventBus.getDefault().post(event);
    }
}
