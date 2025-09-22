package com.lrh.pay.payment.wechatpay

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.lrh.pay.payment.paydata.WechatPayRequest
import com.lrh.payment_module.payment.PaymentStrategy
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

/**
 * @ProjectName houyuan_yacht_app
 * @Package com.houyuan.yacht.play.wecahtpay
 * @Describe 微信支付
 * @Author wolf king
 * @editor 修改人
 * @CreateDate 2021/8/19
 * @UpdateDate 2021/8/19 更新时间
 */
class WeChatPayStrategy : PaymentStrategy {
    private var wxApi: IWXAPI? = null
    private val TAG = "WeChatPayStrategy"

    @SuppressLint("ShowToast")
    override fun toPlay(activity: Activity, data: Any) {
        val wechatPayRequest = data as WechatPayRequest
        Log.d(TAG, "微信支付：${wechatPayRequest}")
        wxApi = WXAPIFactory.createWXAPI(
            activity,
            wechatPayRequest.appId,
            true
        )
        wxApi?.registerApp(wechatPayRequest.appId)
        if (!wxApi?.isWXAppInstalled!!) {
            Toast.makeText(
                activity.applicationContext,
                "请先安装微信",
                Toast.LENGTH_SHORT
            )
            return
        }
        val request = PayReq()
        request.appId = wechatPayRequest.appId
        request.partnerId = wechatPayRequest.partnerId// 微信支付分配的商户号
        request.prepayId = wechatPayRequest.prepayId// 预支付订单号，app服务器调用“统一下单”接口获取
        request.packageValue = "Sign=WXPay"// 固定值Sign=WXPay，可以直接写死，服务器返回的也是这个固定值
        request.nonceStr = wechatPayRequest.nonceStr;// 随机字符串，不长于32位
        request.timeStamp = wechatPayRequest.timeStamp// 时间戳
        request.sign = wechatPayRequest.paySign// 签名，
        request.signType = wechatPayRequest.signType //签名类型
        wxApi?.sendReq(request)
    }
}