package com.example.mydemo.show;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.permissionx.guolindev.PermissionX;
@Route(path = ARouterPath.case24)

public class Case24 extends AppCompatActivity {
    public static final int CHOOSE_PHOTO = 2;
    ImageView picture;
    String imagePath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case24);

        ininView();

    }
    private void ininView(){
        Button btnChoosePhoto = (Button) findViewById(R.id.choose_photo);
        picture = (ImageView) findViewById(R.id.picture);
        btnChoosePhoto.setOnClickListener((View)->{
            requestPermission();
        });
        picture.setOnClickListener((View)->{
            requestPermission();
        });
        //设置图片
        setKeepImage();
    }

    private void requestPermission() {
        //使用了郭霖大神的PermissionX库实现
        PermissionX.init(this)
                .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onExplainRequestReason((scope, deniedList) -> {
                    String message = "需要您同意以下权限才能正常使用";
                    scope.showRequestReasonDialog(deniedList, message, "确定", "取消");
                })
                .request((allGranted, grantedList, deniedList) -> {
                    if (allGranted) {
//                        Toast.makeText(this, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show();
                        openAlbum();
                    } else {
                        Toast.makeText(this, "您拒绝了如下权限："+deniedList, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openAlbum(){
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO); //打开相册
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CHOOSE_PHOTO:
                if(resultCode == RESULT_OK){
                    //判断手机系统版本号
                    if(Build.VERSION.SDK_INT>=19){
                        //4.4及以上系统使用这个方法处理图片
                        handleImageOnKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void handleImageOnKitKat(Intent data){
        Uri uri = data.getData();
        if(DocumentsContract.isDocumentUri(this,uri)){
            //如果是document类型的Uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docId.split(":")[1];  //解析出数字格式的id
                String selection = MediaStore.Images.Media._ID+"="+id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public downloads"),Long.valueOf(docId));
                imagePath = getImagePath(contentUri,null);
            }
        }else if("content".equalsIgnoreCase(uri.getScheme())){
            //如果是file类型的Uri，直接获取图片路径即可
            imagePath = getImagePath(uri,null);
        }else if("file".equalsIgnoreCase(uri.getScheme())){
            //如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath); //根据图片路径显示图片
    }

    //将选择的图片Uri转换为路径
    private String getImagePath(Uri uri,String selection){
        String path = null;
        //通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if(cursor!= null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
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
            editor.putString("imgPath2",imagePath);
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
        String beforeImagePath = sp.getString("imgPath2", null);
        if(beforeImagePath == null){
            picture.setImageResource(R.drawable.default_img);
        }else {
            displayImage(beforeImagePath);
        }
    }
}