package com.example.redux4android.redux.reducer;

import android.support.annotation.NonNull;

import com.example.redux4android.redux.action.Action;
import com.example.redux4android.redux.state.State;
import com.example.redux4android.redux.state.StateTree;

/**
 * Created by teresa on 2017/7/3.
 */
public interface Reducer<A extends Action , S extends State> {
    S call(@NonNull A action, @NonNull StateTree currentState);
}
