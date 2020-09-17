package com.example.mydemo.show;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mydemo.R;
import com.permissionx.guolindev.PermissionX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Case23 extends AppCompatActivity {
    public static final int TAKE_PHOTO = 1;//声明一个请求码，用于识别返回的结果
    private ImageView picture;
    private Uri imageUri;
    private final String filePath = Environment.getExternalStorageDirectory() + File.separator + "output_image.jpg";
    private File outputImage = new File(filePath);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case23);

        initView();
    }

    private void initView(){
        //点击事件进行拍照
        Button takephoto = findViewById(R.id.take_photo);
        picture = findViewById(R.id.picture);
        takephoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //动态请求相机权限
                requestPermission();  //在其中若用户给予权限则请求相机拍照
            }
        });
        //设置图片保存下次展示
        setKeepImage();
    }

    //动态请求权限
    private void requestPermission() {
        //使用了郭霖大神的Permission库实现
        PermissionX.init(this)
                .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA,Manifest.permission.ACCESS_NETWORK_STATE)
                .onExplainRequestReason((scope, deniedList) -> {
                    String message = "需要您同意以下权限才能正常使用";
                    scope.showRequestReasonDialog(deniedList, message, "确定", "取消");
                })
                .request((allGranted, grantedList, deniedList) -> {
                    if (allGranted) {
//                        Toast.makeText(this, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show();
                        requestCamera();
                    } else {
                        Toast.makeText(this, "您拒绝了如下权限："+deniedList, Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults != null && grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                case 1: {
                    requestCamera();
                }
                break;
            }
        }
    }

    private void requestCamera() {

        //使用隐示的Intent，系统会找到与它对应的活动，即调用摄像头，并把它存储
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, TAKE_PHOTO);
        //调用会返回结果的开启方式，返回成功的话，则把它显示出来
//        displayImage(filePath);
    }

    //处理返回结果的函数，下面是隐示Intent的返回结果的处理方式，具体见以前我所发的intent讲解
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        if (!outputImage.getParentFile().exists()) {
                            outputImage.getParentFile().mkdirs();
                        }

                        outputImage.createNewFile();

                        if (Build.VERSION.SDK_INT >= 24) {
                            imageUri = FileProvider.getUriForFile(this,
                                    "com.example.mydemo.fileprovider", outputImage);
                        }

                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                        //存储上次选择的图片路径，用以再次打开app设置图片
                        SharedPreferences sp = getSharedPreferences("sp_img",MODE_PRIVATE);  //创建xml文件存储数据，name:创建的xml文件名
                        SharedPreferences.Editor editor = sp.edit(); //获取edit()
                        editor.putString("imgPath",filePath);
                        editor.apply();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     *  展示图片
     * @param imagePath
     */
    private void displayImage(String imagePath){
        if(imagePath!=null && !imagePath.equals("")){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            picture.setImageBitmap(bitmap);
            //存储上次选择的图片路径，用以再次打开app设置图片
            SharedPreferences sp = getSharedPreferences("sp_img",MODE_PRIVATE);  //创建xml文件存储数据，name:创建的xml文件名
            SharedPreferences.Editor editor = sp.edit(); //获取edit()
            editor.putString("imgPath",imagePath);
            editor.apply();
        }else {
            Toast.makeText(this,"获取图片失败",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  用户头像更新保存
     */

    private void setKeepImage(){
        //设置再次app时显示的图片
        SharedPreferences sp = getSharedPreferences("sp_img", MODE_PRIVATE);
        //取出上次存储的图片路径设置此次的图片展示
        String beforeImagePath = sp.getString("imgPath", null);
        if(beforeImagePath == null){
            picture.setImageResource(R.drawable.default_img);
        }else {
            displayImage(beforeImagePath);
        }
    }
}