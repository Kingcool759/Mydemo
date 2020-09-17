package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.mydemo.R;
import com.permissionx.guolindev.PermissionX;

public class Case29 extends AppCompatActivity {
    private Button btnPermission;
    private Button btnPermissionBetter;
    private Button btnPermissionBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case29);

        initView();
        btnPermission.setOnClickListener((View)->{
            //基本版
            basePermissionX();
        });

        btnPermissionBetter.setOnClickListener((View)->{
            //升级版
            betterPermissionX();
        });

        btnPermissionBest.setOnClickListener((View)->{
            //高级版
            bestPermissionX();
        });

    }

    private void initView(){
        btnPermission = findViewById(R.id.btn_permission);
        btnPermissionBetter = findViewById(R.id.btn_permission_better);
        btnPermissionBest = findViewById(R.id.btn_permission_best);
    }

    /**
     *  基本版
     */
    private void basePermissionX(){
        PermissionX.init(this)
                .permissions(Manifest.permission.READ_CONTACTS, Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE)
                .request((allGranted, grantedList, deniedList) -> {
                    if (allGranted) {
                        Toast.makeText(this, "所有申请的权限都已通过", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "您拒绝了如下权限："+deniedList, Toast.LENGTH_LONG).show();
                    }
                });
    }

    /**
     *  改进版
     */
    private void betterPermissionX() {
        PermissionX.init(this)
                .permissions(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO)
                .onExplainRequestReason((scope, deniedList) -> {
                    String message = "PermissionX需要您同意以下权限才能正常使用";
                    scope.showRequestReasonDialog(deniedList, message, "确定", "取消");
                })
                .request((allGranted, grantedList, deniedList) -> {
                    if (allGranted) {
                        Toast.makeText(this, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "您拒绝了如下权限："+deniedList, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     *  高级版
     */
    private void bestPermissionX(){
        PermissionX.init(this)
                .permissions(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO)
                .setDialogTintColor(Color.parseColor("#008577"), Color.parseColor("#83e8dd"))
                .onExplainRequestReason((scope, deniedList) -> {
                    String message = "PermissionX需要您同意以下权限才能正常使用";
                    scope.showRequestReasonDialog(deniedList, message, "确定", "取消");
                })
                .request((allGranted, grantedList, deniedList) -> {
                    if (allGranted) {
                        Toast.makeText(this, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "您拒绝了如下权限："+deniedList, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}

