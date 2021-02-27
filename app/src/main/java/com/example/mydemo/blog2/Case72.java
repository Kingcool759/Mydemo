package com.example.mydemo.blog2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.OCRResultBean;
import com.example.mydemo.ocr.FileUtil;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.example.mydemo.ocr.RecognizeService;
import com.google.gson.Gson;

import java.util.ArrayList;

@Route(path = ARouterPath.blog72)
public class Case72 extends AppCompatActivity {

    private String apiKey = "wW3adgdDIfMwN8oia31perDR";
    private String secretKey = "GjESpGef8OOjtqUb5Ttok6o9GhgmpNEU";
    private boolean hasGotToken = false;
    private static final int REQUEST_CODE_ACCURATE_BASIC = 107;
    private AlertDialog.Builder alertDialog;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case72);

        //测试是否能成功调用SDK
        initSDKTest();

        mTextView = findViewById(R.id.tvShow);
        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //呼出第三方SDK_Ui模块
                if (!checkTokenStatus()) {
                    return;
                }
                Intent intent = new Intent(Case72.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                        CameraActivity.CONTENT_TYPE_GENERAL);
                startActivityForResult(intent, REQUEST_CODE_ACCURATE_BASIC);
            }
        });

        //选择明秘文方式获取Token
        initAccessTokenWithAkSk();
    }

    /**
     * 用明文ak，sk初始化
     */
    private void initSDKTest() {
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
                Log.d("result-->", "成功！" + token);
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                Log.d("result-->", "失败！" + error.getMessage());

            }
        }, getApplicationContext(), apiKey, secretKey);
    }

    /**
     * 用明文ak，sk初始化
     */
    private void initAccessTokenWithAkSk() {
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                Log.d("打印==: ", error.getMessage());
                alertText("AK，SK方式获取token失败", error.getMessage());
            }
            //}, getApplicationContext(),  "请填入您的AK", "请填入您的SK");
        }, getApplicationContext(), apiKey, secretKey);
    }

    private void alertText(final String title, final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });
    }

    private boolean checkTokenStatus() {
        if (!hasGotToken) {
            Toast.makeText(getApplicationContext(), "token还未成功获取", Toast.LENGTH_LONG).show();
        }
        return hasGotToken;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            initAccessTokenWithAkSk();
        } else {
            Toast.makeText(getApplicationContext(), "需要android.permission.READ_PHONE_STATE", Toast.LENGTH_LONG).show();
        }
    }
//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 识别成功回调，通用文字识别（高精度版）
        if (requestCode == REQUEST_CODE_ACCURATE_BASIC && resultCode == Activity.RESULT_OK) {
            RecognizeService.recAccurateBasic(this, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            OCRResultBean dataBean = new Gson().fromJson(result, OCRResultBean.class);
                            StringBuilder sB = new StringBuilder();
                            for (OCRResultBean.WordsResultBean bean:dataBean.getWords_result()){
                                String str = bean.getWords();
                                Log.d("onResult==: ",str);
                                sB.append(str).append("\n");
                            }
                            mTextView.setText(sB.toString());
//                            Log.d("打印result==: ", sB.toString());
//                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show());
                        }
                    });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 释放内存资源
        OCR.getInstance(this).release();
    }
}