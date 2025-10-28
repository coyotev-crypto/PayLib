package com.lrh.pay.payment.alipay

import android.app.Activity
import android.util.Log
import com.alipay.sdk.app.EnvUtils
import com.alipay.sdk.app.PayTask
import com.lrh.pay.payment.PaymentStrategy
import com.lrh.pay.payment.paydata.AliPayRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * @ProjectName houyuan_yacht_app
 * @Package com.houyuan.yacht.play.alipay
 * @Describe 支付宝支付具体策略 支付宝沙箱测试  hgntvj8795@sandbox.com 密码及支付密码都是111111
 * @Author wolf king
 * @editor 修改人
 * @CreateDate 2021/8/19
 * @UpdateDate 2021/8/19 更新时间
 */
class AlipayStrategy : PaymentStrategy {

    private val mBackgroundScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var mJob : Job? = null
    override fun toPlay(activity: Activity,data: Any) {
        val aliPayRequest = data as AliPayRequest
        if (aliPayRequest.mSandbox){
            EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX)
        }
        mJob?.cancel()
        mJob = mBackgroundScope.launch {
            val alipay = PayTask(activity)
            //支付结果已服务端为准，此处不做处理
            val result = alipay.payV2(data.payInfo, true)
            Log.d("AlipayStrategy", "result: $result")
        }
    }
}