package com.example.redux4android.redux.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by teresa on 2017/7/3.
 * 用于保存多个state 状态
 */
public class StateTree<S extends State> {

    private final Map<String,State> stateMap = new ConcurrentHashMap<>();

    public void updateState(State newState) {
        stateMap.put(newState.getClass().getSimpleName(),newState);
    }

    public static class Builder<S extends State>{
        private StateTree<S> stateTree;
        public Builder(){
            stateTree = new StateTree<>();
        }
        public Builder add(S value){
            if(value==null){
                return this;
            }
            stateTree.updateState(value);
            return this;
        }

        public StateTree build(){return stateTree;}
    }
}
