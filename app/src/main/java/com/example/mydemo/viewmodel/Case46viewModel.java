package com.example.mydemo.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mydemo.apiservice.AppApiService;
import com.example.mydemo.bean.AreaThreeLinkBean;
import com.example.mydemo.response.ApiCallback;
import com.example.mydemo.response.DemoPortal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @data on 2020/10/21 10:02 AM
 * @auther
 * @describe
 */
public class Case46viewModel extends ViewModel {
    public MutableLiveData<List<AreaThreeLinkBean.DataBean>> areaDataList = new MutableLiveData<>();

    public void getAreaDataList(){
//        String baseUrl = "https://github.com/modood/Administrative-divisions-of-China/edit/master/";
        //经过测试github会阻止用户进行访问，还需要进行其他配置，另一种方式为Tomcat自配，还在摸索中。
        DemoPortal.getService(AppApiService.class).getAreaData().enqueue(new ApiCallback<AreaThreeLinkBean>() {
            @Override
            public void onSuccessful(Call<AreaThreeLinkBean> call, Response<AreaThreeLinkBean> response) {
                Log.d("onSuccessful","success");
                if(response == null || response.body() ==null){
                    return;
                }
                areaDataList.setValue(response.body().getData());
            }

            @Override
            public void onFail(String message) {
                Log.d("onFail","----------> ");
            }
        });
    }
}
