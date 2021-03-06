package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.utils.DateUtil;
@Route(path = ARouterPath.case25)

public class Case25 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case25);

        Button getTimeChuo = findViewById(R.id.btn_show_time_chuo);
        Button getTime = findViewById(R.id.btn_show_time);
        Button changeToTime = findViewById(R.id.btn_change);
        Button changeToChuo = findViewById(R.id.btn_change2);

        TextView tvShow = findViewById(R.id.tv_show);
        getTimeChuo.setOnClickListener((View)->{
            tvShow.setText(DateUtil.getTimeStamp());
        });
        getTime.setOnClickListener((View)->{
            tvShow.setText(DateUtil.getCurrentDate());
        });
        changeToTime.setOnClickListener((View)->{
            tvShow.setText(DateUtil.getDateToString(1600074914));
        });
        changeToChuo.setOnClickListener((View)->{
            //String.valueof(Long):long转成String类型
            tvShow.setText(String.valueOf(DateUtil.getStringToDate("2020-09-18 18:00:00")));
        });
    }
}