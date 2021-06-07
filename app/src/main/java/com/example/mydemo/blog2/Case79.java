package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.bean.DataBean;
import com.example.mydemo.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Route(path = ARouterPath.blog79)
public class Case79 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case79);

//        //乐于助人
//        DataBean dataBean = new DataBean();
//        AtomicInteger count = new AtomicInteger(0);
//        List<DataBean.RowsBean.ResultBean.FaceListBean> faceList =  dataBean.getRows().getResult().getFace_list();
//        CopyOnWriteArrayList<DataBean.RowsBean.ResultBean.FaceListBean.UserListBean> oldUserList = new CopyOnWriteArrayList<>();
//        CopyOnWriteArrayList<String> idList = new CopyOnWriteArrayList<>();
//        String frontTime = "";
//        for (DataBean.RowsBean.ResultBean.FaceListBean faceBean: faceList){
//            if (count.get() == 0){
//                oldUserList.addAll(faceBean.getUser_list());  //一次网络请求全User数据
//                for (DataBean.RowsBean.ResultBean.FaceListBean.UserListBean userBean: oldUserList){
//                    idList.add(userBean.getUser_id());
//                }
//                count.incrementAndGet();  //count+1，线程安全
//                frontTime = DateUtil.getCurrentDate(); //获取第一次请求成功的此刻时间
//            }else {
//                //第二次网络请求数据
//                for (DataBean.RowsBean.ResultBean.FaceListBean.UserListBean newUserBean: faceBean.getUser_list()){
//                    for (String id : idList){
//                        if (!id.equals(newUserBean.getUser_id())){
//                            idList.add(newUserBean.getUser_id());
//                            oldUserList.add(newUserBean);
//                        }else {
//                            if (!DateUtil.timecompare(frontTime,10)){
//                                idList.add(newUserBean.getUser_id());
//                                oldUserList.add(newUserBean);
//                                frontTime = DateUtil.getCurrentDate();
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}