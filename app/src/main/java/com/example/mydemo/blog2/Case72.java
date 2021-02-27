package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.ocr.FileUtil;
import com.baidu.ocr.ui.camera.CameraActivity;

@Route(path = ARouterPath.blog72)
public class Case72 extends AppCompatActivity {

    private String apiKey = "wW3adgdDIfMwN8oia31perDR";

    private String secretKey = "GjESpGef8OOjtqUb5Ttok6o9GhgmpNEU";

    private boolean hasGotToken = false;

    private static final int REQUEST_CODE_ACCURATE_BASIC = 107;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case72);

        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //呼出第三方SDK_Ui模块
                initSDKTest();
                //
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

    private boolean checkTokenStatus() {
        if (!hasGotToken) {
            Toast.makeText(getApplicationContext(), "token还未成功获取", Toast.LENGTH_LONG).show();
        }
        return hasGotToken;
    }
}