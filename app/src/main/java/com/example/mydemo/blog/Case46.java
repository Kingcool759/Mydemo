package com.example.mydemo.blog;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.bean.ProviceBean;
import com.example.mydemo.utils.GetJsonDataUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//picker-View选择器
//自己封装的api接口还不能用，被github官网给阻止访问了，还在解决中……
@Route(path = ARouterPath.blog46)

public class Case46 extends AppCompatActivity {
    private Button btnTimePicker;
    private Button btnAreaPicker;
    //省、市、区-列表
    private List<ProviceBean> options1Items = new ArrayList<>();
    private List<List<ProviceBean.CityBean>> options2Items = new ArrayList<>();
    private List<List<List<String>>> options3Items = new ArrayList<>();

    private List<String> options4Items = new ArrayList<>();
    private List<List<String>> options5Items = new ArrayList<>();
    private List<List<List<String>>> options6Items = new ArrayList<>();
    //模拟数据
//    private ArrayList<String> options1Items = new ArrayList<>();// 省集合
//    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();// 市集合
//    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();// 区集合


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case46);
        //初始化
        initView();
        //弹出选择器
        getView1();
        getView2();
        //填充数据
        initJsonData();
    }

    private void initView() {
        btnTimePicker = findViewById(R.id.btnTimePicker);
        btnAreaPicker = findViewById(R.id.btnAreaPicker);
    }

    private void getView1() {
        btnTimePicker.setOnClickListener((View) -> {
            timePicker();
        });
    }

    private void getView2() {
        btnAreaPicker.setOnClickListener((View) -> {
            areaPicker();
        });
    }

    //时间选择器
    private void timePicker() {
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                ToastUtils.show(getTime(date));
            }
        }).build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    //根据需要自行截取数据显示
    private String getTime(Date date) {//可根据需要自行截取数据显示
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    //地区三级联动
    private void areaPicker() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
//                String str = options1Items.get(options1) +
//                        options2Items.get(options1).get(options2) +
//                        options3Items.get(options1).get(options2).get(options3);
//                ToastUtils.show(str);
            }
        })
                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK)
                .setContentTextSize(20)
                .setOutSideCancelable(false)
                .build();
        pvOptions.setPicker(options4Items, options2Items, options3Items);
        pvOptions.show();
    }

    private void initJsonData() {
        String str = new GetJsonDataUtil().getJson(this, "province.json");
        List<ProviceBean> list = new Gson().fromJson(str, new TypeToken<List<ProviceBean>>() {
        }.getType());
        options1Items.addAll(list);
//        Logger.d(options1Items);
        Logger.d(options1Items);
        for (ProviceBean bean : options1Items) {
            List<ProviceBean.CityBean> cityList = new ArrayList<>();
            cityList.addAll(bean.getCity());
            options4Items.add(bean.getName());
            options2Items.add(cityList);
        }
        for (int i=0;i<options2Items.size();i++) {
//            List<String> data3 = new ArrayList<>();
//            data3.add(options2Items.get(i).get(i).getName());
//            Log.d("initJsonData: ",""+data3);
//            options5Items.add(data3);
            List<List<String>> list2 = new ArrayList<>();
            for (ProviceBean.CityBean data : options2Items.get(i)) {
                List<String> list1 = new ArrayList();
                list1.addAll(data.getArea());
                list2.add(list1);
            }
            options3Items.add(list2);
        }
    }
}