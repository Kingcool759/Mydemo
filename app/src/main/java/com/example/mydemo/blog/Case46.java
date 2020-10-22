package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.bean.AreaThreeLinkBean;
import com.example.mydemo.databinding.ActivityCase46Binding;
import com.example.mydemo.viewmodel.Case46viewModel;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//picker-View选择器
//自己封装的api接口还不能用，被github官网给阻止访问了，还在解决中……
@Route(path = ARouterPath.blog46)

public class Case46 extends AppCompatActivity {
    private ActivityCase46Binding binding;
    private Case46viewModel viewModel;
    private Button btnTimePicker;
    private Button btnAreaPicker;
    //
    private List<AreaThreeLinkBean.DataBean> areaProList = new ArrayList<>();
    private List<AreaThreeLinkBean.DataBean.ChildrenBeanX> areaCityList = new ArrayList<>();
    private List<AreaThreeLinkBean.DataBean.ChildrenBeanX.ChildrenBean> areaCoutList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_case46);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case46);
        viewModel = ViewModelProviders.of(this).get(Case46viewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        //初始化
        initView();
        getView1();
        getView2();
    }
    private void initView(){
        btnTimePicker = findViewById(R.id.btnTimePicker);
        btnAreaPicker = findViewById(R.id.btnAreaPicker);
    }
    private void getView1(){
        btnTimePicker.setOnClickListener((View)->{
            timePicker();
        });
    }

    private void getView2(){
        btnAreaPicker.setOnClickListener((View)->{
            viewModel.getAreaDataList(); //调用api接口请求数据
            getCallback();
            try {
                areaPicker();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    //时间选择器
    private void timePicker(){
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    //地区三级联动
    private void areaPicker() throws JSONException {
        //条件选择器
        if (areaProList == null) {
            viewModel.getAreaDataList();
            getCallback();
        }else {
            OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                @Override
                public void onOptionsSelect(int option1, int option2, int option3, View v) {
                    //返回的分别是三个级别的选中位置
                    //确定按钮的点击事件
//                    String tx = areaProList.get(options1).getName()
//                            + areaCityList.get(option2).getName()
//                            + areaCoutList.get(option3).getName();

                    String tx = "啥也没有";
                    ToastUtils.show(tx);
                }
            }).build();
//            pvOptions.setPicker(areaProList, areaCityList, areaCoutList);

            //测试：填充假数据
            List <String> list1  = new ArrayList<>();
            List <List <String>> list2  = new ArrayList<>();
            List <List <List <String>>> list3  = new ArrayList<>();
            //

//            AreaLinkBean areaLinkBean = new Gson().fromJson(str, AreaLinkBean.class);
//            list1.add(areaLinkBean.getName());


//            String s = "areaData";
//            JSONObject jsonObject = new JSONObject(new AssetsUtils().readAssertResource(this,s));
//            try {
//                JSONArray provinceArray = jsonObject.getJSONArray(new AreaThreeLinkBean.DataBean().getName());
//                JSONArray cityArray = jsonObject.getJSONArray(new AreaThreeLinkBean.DataBean().getChildren().get(option1).getName());
//                JSONArray districtArray = jsonObject.getJSONArray(new AreaThreeLinkBean.DataBean().getChildren().get());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }


            list1.add("北京");
            list1.add("上海");
            list1.add("广州");
            list2.add(list1);
            list2.add(list1);
            list2.add(list1);
            list3.add(list2);
            list3.add(list2);
            list3.add(list2);
            pvOptions.setNPicker(list1,list2,list3);

            pvOptions.show();
        }
    }

    //请求接口返回数据
    private void getCallback(){
        viewModel.areaDataList.observe(this,it->{
            areaProList.addAll(it);
        });
    }
}