package com.example.mydemo.response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @data on 2020/8/31 4:17 PM
 * @auther
 * @describe
 */
public abstract class ApiCallback<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        int statusCode = response.code();
        onSuccessful(call, response);
        if (statusCode >= 100 && statusCode <= 101) {
            onFail("出错了，请重试!!!");
        } else if (statusCode >= 300 && statusCode <= 307) {
            onFail("出错了，请重试!!");
        } else if (statusCode >= 400 && statusCode <= 417) {
            onFail("出错了，请重试!");
        } else if (statusCode >= 500 && statusCode <= 505) {
            if (statusCode == 504) {
                onFail("请求超时，请重试");
            } else {
                onFail("出错了，请重试");
            }
        } else {
            onSuccessful(call, response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        t.printStackTrace();
        onFail(t.getMessage());

    }

    public abstract void onSuccessful(Call<T> call, Response<T> response);

    public abstract void onFail(String message);
}
