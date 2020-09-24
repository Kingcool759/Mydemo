package com.example.mydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.mydemo.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.ArrayList;

/**
 * @data on 2020/9/5 10:41 AM
 * @auther armstrong
 * @describe   tagflowlayout 采自github泓洋大神的 FlowLayout库
 */
public class FlowTagAdapter extends TagAdapter {
    private ArrayList<String> datalist;
    private Context context;

    public FlowTagAdapter(Context mcontext,ArrayList datas) {
        super(datas);
        this.context = mcontext;
        this.datalist = datas;
    }

    @Override
    public View getView(FlowLayout parent, int position, Object o) {
        TextView tv = (TextView) View.inflate(context,R.layout.tagflow_tv_context, null);
        tv.setText(datalist.get(position));
        return tv;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public void onSelected(int position, View view) {
        super.onSelected(position, view);
    }

    @Override
    public void unSelected(int position, View view) {
        super.unSelected(position, view);
    }
}
