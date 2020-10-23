package com.example.mydemo.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.main)
public class MainActivity extends AppCompatActivity {
    private String data[] = {
            "1：拨打电话",  //0
            "2：自定义Dialog（退出应用程序）",  //1
            "3：DataBinding+ObservableField使用（数据绑定）", //2
            "4：LiveData使用（字段监听更新UI视图）",  //3
            "5：ListView使用（基础）",  //4
            "6：LifeCycle使用（生命周期）", //5
            "7：RecyclerView使用（横纵分布）",  //6
            "8：ViewPager使用实现轮播图（基础版本-进阶版本-最终版本）",  //case7
            "9：待完成：RxJava使用", //8
            "10：Retrofit使用，Api接口调用实现（调用玩安卓网站api实战）", //case9
            "11：CollapsingToolbarLayout折叠布局",  //10
            "12：WebView使用（手机加载网页）", //11
            "13：DrawerLayout+NavigationView使用（侧边滑出菜单）",  //12
            "14：TabLayout使用（顶部导航栏）",  //13
            "15：自定义FlowLayout实现流式布局(+点击事件)",  //14
            "16：hongyang的TagFlowLayout流式布局使用（+点击事件）",  //15
            "17：ARouter路由跳转（告别Intent跳转）", //16
            "18：DataBinding示例（基本用法）",  //17
            "19：Lambda表达式使用（简化代码量，增强业务逻辑代码可读性）", //18
            "20：RecyclerView使用ItemDecoration实现酷炫的效果（彩色分割线+时间轴）", //19
            "21：PopupWindow使用（弹出框+点击回调事件）",
            "22：调用摄像头拍照示例（动态请求权限+拍照+保存图片）",
            "23：从相册中选择照片示例（动态请求权限+选图+保存图片）",
            "24：java中的时间戳与字符串之间的互相转化",
            "25：RecyclerView隐藏TooBar效果（隐藏标题栏）",
            "26：TitleBar标题栏库使用（github库，多种样式的标题栏实现）",
            "27：CricleImageView圆形图片库使用（github库）",
            "28：Permission X 动态请求应用权限（github库）",
            "29：activity横竖屏切换时生命周期的变化情况探究",
            "30：activity跳转到另一个activity时的生命周期变化情况探究",
            "31：Recycler实现多布局效果（+ImageView）",
            "32：Recycler（两个）实现多布局效果",
            "33：Recycler实现多条目布局（行列）",
            "34：Glide加载图片（解决加载网络http图片的问题）",
            "35：数字滚动控件Ticker",
            "36：Activity中的Fragment从启动到销毁的生命周期变化过程探究",
            "37：JetPack+MVVM模式实现wanAdroid应用app（另附github源码，java语言实现）",
            "38：搜索框（带历史记录）SearchLayout类库使用",
            "39：String，StringBuffer,StringBuilder三者区别（实现字符串倒序）",
            "40：EventBus事件发布-订阅总线探究",
            "41：RxBus，取代了EventBus，是EventBus的进阶版",
            "42：待完成：反射机制探究",
            "43：待完成：动画：MotionLayout的使用",
            "44：算法：求X的平方根",
            "45：待完成：app调起第三方微信登陆",
            "46：待完成：PickerView库使用",
            "47：验证码倒计时功能实现",
            "48：待完成：app调起支付宝",
            "49：滚动控件WheelView库使用",
            "50：CardView-MD使用",
            "46：悬浮按钮+可交互提示（FloatingActionButton+SnakerBar-MD使用）",
            "47：待完成：探究Handler异步消息机制"
    };//假数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);//在视图中找到ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);//新建并配置ArrayAapeter
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        ARouter.getInstance().build(ARouterPath.case1).navigation();
                        break;

                    case 1:
                        ARouter.getInstance().build(ARouterPath.case2).navigation();
                        break;

                    case 2:
                        ARouter.getInstance().build(ARouterPath.case3).navigation();
                        break;

                    case 3:
                        ARouter.getInstance().build(ARouterPath.case4).navigation();
                        break;

                    case 4:
                        ARouter.getInstance().build(ARouterPath.case5).navigation();
                        break;

                    case 5:
                        ARouter.getInstance().build(ARouterPath.case6).navigation();
                        break;

                    case 6:  //recyclerview
                        ARouter.getInstance().build(ARouterPath.case7).navigation();
                        break;

                    case 7:  //ViewPager
                        ARouter.getInstance().build(ARouterPath.case8).navigation();
                        break;

                    case 8:  //RxJava
                        ARouter.getInstance().build(ARouterPath.case9).navigation();
                        break;

                    case 9:  //Retrofit
                        ARouter.getInstance().build(ARouterPath.case10).navigation();
                        break;

                    case 10:  //折叠布局
                        ARouter.getInstance().build(ARouterPath.case11).navigation();
                        break;

                    case 11:  //WebView
                        ARouter.getInstance().build(ARouterPath.case12).navigation();
                        break;

                    case 12:  //滑出菜单
                        ARouter.getInstance().build(ARouterPath.case13).navigation();
                        break;

                    case 13:  //Tablayout
                        ARouter.getInstance().build(ARouterPath.case14).navigation();
                        break;

                    case 14:  //自定义View实现流式布局
                        ARouter.getInstance().build(ARouterPath.case15).navigation();
                        break;

                    case 15:  //流式布局(hongyang)
                        ARouter.getInstance().build(ARouterPath.case16).navigation();
                        break;

                    case 16:  //ARouter路由跳转
                        ARouter.getInstance().build(ARouterPath.case17).navigation();
                        break;

                    case 17:  //DataBinding示例
                        ARouter.getInstance().build(ARouterPath.case18).navigation();
                        break;

                    case 18:  //lambda
                        ARouter.getInstance().build(ARouterPath.case20).navigation();
                        break;

                    case 19:  //recyclerview
                        ARouter.getInstance().build(ARouterPath.case21).navigation();
                        break;

                    case 20:  //popupwindow
                        ARouter.getInstance().build(ARouterPath.case22).navigation();
                        break;

                    case 21:  //调用摄像头拍照
                        ARouter.getInstance().build(ARouterPath.case23).navigation();
                        break;

                    case 22:  //
                        ARouter.getInstance().build(ARouterPath.case24).navigation();
                        break;

                    case 23:  //
                        ARouter.getInstance().build(ARouterPath.case25).navigation();
                        break;

                    case 24:  //RecyclerView隐藏TooBar效果
                        ARouter.getInstance().build(ARouterPath.case26).navigation();
                        break;

                    case 25:  //TitleBar标题栏
                        ARouter.getInstance().build(ARouterPath.case27).navigation();
                        break;

                    case 26:  //图片圆形处理
                        ARouter.getInstance().build(ARouterPath.case28).navigation();
                        break;

                    case 27:  //permission X
                        ARouter.getInstance().build(ARouterPath.case29).navigation();
                        break;

                    case 28:  //activity切换横竖屏时候的生命周期变化
                        ARouter.getInstance().build(ARouterPath.case30).navigation();
                        break;

                    case 29:  //activity跳转到另一个activity的时候生命周期变化
                        ARouter.getInstance().build(ARouterPath.blog31).navigation();
                        break;

                    case 30:  //Recycler（ImageView）实现多布局
                        ARouter.getInstance().build(ARouterPath.blog33).navigation();
                        break;

                    case 31:  //Recycler（两个）实现多布局
                        ARouter.getInstance().build(ARouterPath.blog34).navigation();
                        break;

                    case 32:  //Recycler（两个）实现多布局
                        ARouter.getInstance().build(ARouterPath.blog35).navigation();
                        break;

                    case 33:  //glide加载图片
                        ARouter.getInstance().build(ARouterPath.blog36).navigation();
                        break;

                    case 34:  //数字滚动控件
                        ARouter.getInstance().build(ARouterPath.blog37).navigation();
                        break;

                    case 35:  //fragment的生命周期探究
                        ARouter.getInstance().build(ARouterPath.blog38).navigation();
                        break;

                    case 36:  //JetPack+MVVM模式实现wanAdroid应用app（另附github源码，java语言实现）
                        ARouter.getInstance().build(ARouterPath.blog39).navigation();
                        break;

                    case 37:  //搜索框（带历史记录）github库使用
                        ARouter.getInstance().build(ARouterPath.blog40).navigation();
                        break;

                    case 38:  //String,StringBuffer
                        ARouter.getInstance().build(ARouterPath.blog41).navigation();
                        break;

                    case 39:  //EventBus事件发布-订阅总线探究
                        ARouter.getInstance().build(ARouterPath.blog42).navigation();
                        break;

                    case 40:  //RxBus，取代了EventBus，是EventBus的进阶版
                        ARouter.getInstance().build(ARouterPath.blog43).navigation();
                        break;

                    case 41:  //反射机制探究
                        ARouter.getInstance().build(ARouterPath.blog44).navigation();
                        break;

                    case 42:  //MotionLayout的使用
                        ARouter.getInstance().build(ARouterPath.blog45).navigation();
                        break;

                    case 43:  //算法求X的平方根
                        ARouter.getInstance().build(ARouterPath.algorithm1).navigation();
                        break;

                    case 44:  //调起第三方微信登陆
                        ARouter.getInstance().build(ARouterPath.weChat1).navigation();
                        break;

                    case 45:  //PickerView使用
                        ARouter.getInstance().build(ARouterPath.blog46).navigation();
                        break;

                    case 46:  //验证码倒计时功能实现
                        ARouter.getInstance().build(ARouterPath.blog47).navigation();
                        break;

                    case 47:  //app调起支付宝
                        ARouter.getInstance().build(ARouterPath.blog48).navigation();
                        break;

                    case 48:  //wheelView
                        ARouter.getInstance().build(ARouterPath.blog49).navigation();
                        break;

                    case 49:  //CardView
                        ARouter.getInstance().build(ARouterPath.blog50).navigation();
                        break;

                    case 50:  //FloatingActionBtn+可交互提示
                        ARouter.getInstance().build(ARouterPath.blog51).navigation();
                        break;

                    case 51:  //FloatingActionBtn+可交互提示
                        ARouter.getInstance().build(ARouterPath.blog52).navigation();
                        break;

                    default:
                }
            }
        });
    }
}