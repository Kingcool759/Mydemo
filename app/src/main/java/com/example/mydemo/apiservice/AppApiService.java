package com.example.mydemo.apiservice;

import com.example.mydemo.api.AppApi;
import com.example.mydemo.bean.AreaThreeLinkBean;
import com.example.mydemo.bean.HomeDateBean;
import com.example.mydemo.bean.HomePageResBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @data on 2020/8/31 3:50 PM
 * @auther
 * @describe
 */
public interface AppApiService {
    /**
     * 获取wanandroid首页公众号列表
     */
    @GET(AppApi.OFFITIAL_ACCOUNTS)
    Call<HomePageResBean> getOfficialAccounts();

    /**
     * 获取地区三级联动数据
     */
    @GET(AppApi.AREA_LINK_DATA)
    Call<AreaThreeLinkBean> getAreaData();

    /**
     *  测试Http数据
     */
    @GET(AppApi.home_faxian_List)
    Call<HomeDateBean> getHomeDate();
}
