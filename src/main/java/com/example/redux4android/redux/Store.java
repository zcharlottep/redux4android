package com.example.redux4android.redux;


import com.example.redux4android.redux.action.Action;
import com.example.redux4android.redux.action.SyncAction;
import com.example.redux4android.redux.middleware.Next;
import com.example.redux4android.redux.dispatcher.Dispatcher;
import com.example.redux4android.redux.middleware.Middleware;
import com.example.redux4android.redux.reducer.Reducer;
import com.example.redux4android.redux.state.State;
import com.example.redux4android.redux.state.StateTree;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by teresa on 2017/7/3.
 */
public class Store {

    private static final String TAG = Store.class.getSimpleName();
    private List<Next<Action>> nextList;
    private StateTree currentState;

    public Store(StateTree initState , Middleware... middleWares){
        Dispatcher.getInstance().register(this);

        nextList = new ArrayList<>();
        // 添加action，处理同步消息
        nextList.add(0, new Next<Action>() {
            @Override
            public void dispatcher(Action action) {
                _dispatcher(action);
            }
        });
        //逆向添加middleware到链表
        for (int i = middleWares.length-1; i >=0 ; i--) {
            final Middleware proxy =  middleWares[i];
            final Next<Action> next = nextList.get(0);
            nextList.add(0, new Next<Action>() {
                @Override
                public void dispatcher(Action action) {
                    proxy.dispatcher(Store.this,action,next);
                }
            });
        }

        this.currentState = initState;
    }

    /**
     * Reducer处理同步消息
     * @param action
     */
    private void _dispatcher(Action action) {
        if(action instanceof SyncAction){
            Reducer reducer = _getReducer(action);
            if(reducer!=null){
                // reducer 更新state ，只有reducer才能更新state。
                State newState = reducer.call(action,currentState);
                if(newState!=null){
                    currentState.updateState(newState);
                    //通知模块state更新
                    _notifyStateChanged(newState.clone().attachAction(action));
                }
            }
        }
    }

    private void _notifyStateChanged(State state) {
        Dispatcher.getInstance().post(state);
    }

    private Reducer _getReducer(Action action) {
        return null;
    }

    public void dispatch(Action action) {
        Dispatcher.getInstance().post(action);
    }

    public void register(Object subscribe){
        Dispatcher.getInstance().register(subscribe);
    }

    public void unregister(Object subscribe){
        Dispatcher.getInstance().unregister(subscribe);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onDispatcher(Action action){
        nextList.get(0).dispatcher(action);
    }

}
