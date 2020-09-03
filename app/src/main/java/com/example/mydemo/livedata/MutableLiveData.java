package com.example.mydemo.livedata;

import androidx.lifecycle.LiveData;

/**
 * @data on 2020/8/27 4:25 PM
 * @auther
 * @describe  MutableLiveData使用 +范形
 */
public class MutableLiveData<T> extends LiveData<T> {
    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        super.setValue(value);
    }
}
