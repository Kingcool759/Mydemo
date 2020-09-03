package com.example.mydemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @data on 2020/8/27 4:10 PM
 * @auther
 * @describe   LiveData使用
 */
public class Case4viewModel extends ViewModel {
    public MutableLiveData<String> myString = new MutableLiveData<>();

    public MutableLiveData<String> getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString.postValue(myString);
    }
}
