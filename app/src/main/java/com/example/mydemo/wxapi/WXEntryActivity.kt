package com.example.mydemo.wxapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.mydemo.entity.Event
import com.hjq.toast.ToastUtils
import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import com.youth.banner.util.LogUtils
import org.greenrobot.eventbus.EventBus

/**
 * @data on 2020/10/16 2:51 PM
 * @auther
 * @describe
 */
class WXEntryActivity : Activity(), IWXAPIEventHandler {
    private var mWeixinAPI: IWXAPI? = null
    private val RETURN_MSG_TYPE_LOGIN = 1
    private val RETURN_MSG_TYPE_SHARE = 2

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mWeixinAPI = WXAPIFactory.createWXAPI(this, WEIXIN_APP_ID, true)
        mWeixinAPI!!.handleIntent(this.intent, this)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        mWeixinAPI!!.handleIntent(intent, this)//必须调用此句话
    }

    //微信发送的请求将回调到onReq方法
    override fun onReq(req: BaseReq) { LogUtils.d("onReq")
    }

    //发送到微信请求的响应结果
    override fun onResp(resp: BaseResp) {
        LogUtils.d("onResp")
        when (resp.errCode) {
            BaseResp.ErrCode.ERR_OK -> {
                LogUtils.d("微信登成功")
                //发送成功
                val sendResp = resp as SendAuth.Resp
                val code = sendResp.code
                EventBus.getDefault().post(Event(code,"wxCode"))
                finish()
            }
            BaseResp.ErrCode.ERR_USER_CANCEL -> {
                if (resp.type == RETURN_MSG_TYPE_SHARE){
                    ToastUtils.show("分享失败")
                }else{
                    ToastUtils.show("登陆失败")
                }
                LogUtils.e("ERR_USER_CANCEL")
            }
            BaseResp.ErrCode.ERR_AUTH_DENIED -> LogUtils.e("ERR_AUTH_DENIED")
            else -> {
                ToastUtils.show("微信登陆错误")
                LogUtils.d("微信登陆错误"+" "+resp.errCode+resp.errStr)
                finish()
            }
        }//发送取消
        //发送被拒绝
        //发送返回

    }
    companion object {
        private val APP_SECRET = "305c1e604e79f7e9b4c9a617c67c345c"
        val WEIXIN_APP_ID = "wxecb9abc374b780c2"
        private val uuid: String? = null
    }
}
