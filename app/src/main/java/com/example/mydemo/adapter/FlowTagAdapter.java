package com.example.mydemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.mydemo.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @data on 2020/9/5 10:41 AM
 * @auther
 * @describe
 */
public class FlowTagAdapter extends TagAdapter {
    private List<String> datalist;
    private Context context;

    public FlowTagAdapter(Context mcontext,List datas) {
        super(datas);
        this.datalist = datas;
        this.context = mcontext;
    }

    @Override
    public View getView(FlowLayout parent, int position, Object o) {
        TextView tv = (TextView) View.inflate(context,R.layout.flowlayout_tv_selected, null);
        datalist = new ArrayList();
        tv.setText(datalist.get(position));
        return tv;
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
