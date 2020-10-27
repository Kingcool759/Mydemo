package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.utils.DateUtil2;

import static com.example.mydemo.utils.DateUtil2.getTimeFormatText;

/**
 * @data on 2020/10/26 5:07 PM
 * @auther armStrong
 * @describe 时间按规则转换：一分钟内显示刚刚；一小时内显示x分钟前；一天内显示x小时前；5天内显示x天前;超过5天，显示年月日时分秒日期。如果是当年，就不显示年份。
 */
@Route(path = ARouterPath.blog55)
public class Case55 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case55);
        ininView();
    }

    private void ininView() {
        TextView tvShow = findViewById(R.id.dataShow);
        getShow(tvShow);
    }
    private void getShow(TextView tv){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTimeFormatText(System.currentTimeMillis()) + "\n")
                .append(getTimeFormatText(1603704981*1000L) + "\n")
                .append(getTimeFormatText(1603683969*1000L) + "\n")
                .append(getTimeFormatText(1603273569*1000L) + "\n")
                .append(getTimeFormatText(1600012951*1000L) + "\n")
                .append(getTimeFormatText(1533278437*1000L));
        tv.setText(stringBuilder.toString());
    }
}