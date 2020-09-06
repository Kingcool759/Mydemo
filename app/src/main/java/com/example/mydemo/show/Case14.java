package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemo.R;
import com.example.mydemo.adapter.FlowTagAdapter;
import com.example.mydemo.databinding.ActivityCase14Binding;
import com.hjq.toast.ToastUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.zip.Inflater;

/**
 * 流式布局
 */
public class Case14 extends AppCompatActivity {
    private ActivityCase14Binding binding;
    private FlowTagAdapter tagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case14);
        binding.setLifecycleOwner(this);

        List<String> mVals = new ArrayList<String>();
        mVals.add("sfsfdsfd");
        mVals.add("sfsfdsddfsdffd");
        mVals.add("sdsfd");
        mVals.add("sfsfdsfd");


        tagAdapter = new FlowTagAdapter(getApplicationContext(),mVals);
        //设置预先选中
        binding.flowlayout.setSelected(false);
        binding.flowlayout.setAdapter(tagAdapter);

        binding.flowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                ToastUtils.show(mVals.get(position));
                return true;
            }
        });
        //点击标签时的回调
        binding.flowlayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                
            }
        });
    }
}

