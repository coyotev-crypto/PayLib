package com.lrh.pay.payment

import android.app.Activity
import com.lrh.pay.payment.alipay.AlipayStrategy
import com.lrh.pay.payment.wechatpay.WeChatPayStrategy

/**
 * @ProjectName houyuan_yacht_app
 * @Package com.houyuan.yacht.play
 * @Describe 获取具体的支付类型
 * @Author wolf king
 * @editor 修改人
 * @CreateDate 2021/8/19
 * @UpdateDate 2021/8/19 更新时间
 */
class PaymentFactory private constructor() {
    //维护支付
    private val payMap: HashMap<PaymentType, PaymentStrategy> =
        hashMapOf(
            PaymentType.ALIPAY to AlipayStrategy(),
            PaymentType.WECHATPAY to WeChatPayStrategy()
        )

    companion object {
        val instance: PaymentFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            PaymentFactory()
        }
    }

    fun pay(paymentType: PaymentType, activity: Activity, data: Any) {
        payMap[paymentType]?.toPlay(activity, data)
    }
}