package com.example.redux4android.redux.state;

import com.example.redux4android.redux.action.Action;

/**
 * Created by teresa on 2017/7/3.
 */
public class State<A extends Action> implements Cloneable{

    private A action;

    @Override
    public State<A> clone(){
        try {
            return (State<A>) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

   public State<A> attachAction(A action){
       this.action = action;
       return this;
   }

    public A getAction(){
        return action;
    }

}
