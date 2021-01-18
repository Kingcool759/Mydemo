package com.example.mydemo.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @data on 2020/8/27 4:10 PM
 * @auther  armstrong
 * @describe   LiveData使用
 */
public class Case4viewModel extends ViewModel {

    //LiveData对象

    public MutableLiveData<String> myLiveDataString = new MutableLiveData<>();

    public void setLiveDataString(String myString) {
        this.myLiveDataString.postValue(myString);
    }

    //Observer对象

    public ObservableField<String> myObserString = new ObservableField<>();

    public void setMyObserString(String myObserString) {
        this.myObserString.set(myObserString);
    }
}
