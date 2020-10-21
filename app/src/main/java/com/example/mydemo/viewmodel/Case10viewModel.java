package com.example.mydemo.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mydemo.apiservice.AppApiService;
import com.example.mydemo.bean.HomePageResBean;
import com.example.mydemo.response.ApiCallback;
import com.example.mydemo.response.DemoPortal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @data on 2020/8/31 5:11 PM
 * @auther armStrong
 * @describe 接口请求
 */
public class Case10viewModel extends ViewModel {

    public MutableLiveData<List<HomePageResBean.DataBean>> mOfficialAccountsList = new MutableLiveData<>();

    //获取wanandroid中的首页公众号列表信息
    public void getPublicList() {
//        String BaseUrl = "https://www.wanandroid.com/";
        DemoPortal.getService(AppApiService.class).getOfficialAccounts().enqueue(new ApiCallback<HomePageResBean>() {
            @Override
            public void onSuccessful(Call<HomePageResBean> call, Response<HomePageResBean> response) {
                Log.d("onSuccessful","success");
                if(response == null || response.body() ==null){
                    return;
                }
                mOfficialAccountsList.setValue(response.body().getData());
            }

            @Override
            public void onFail(String message) {
                Log.d("onFail","----------> ");
            }
        });
    }
}
