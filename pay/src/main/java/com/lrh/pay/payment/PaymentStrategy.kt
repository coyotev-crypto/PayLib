package com.lrh.pay.payment

import android.app.Activity

/**
 * @ProjectName houyuan_yacht_app
 * @Package com.houyuan.yacht.play
 * @Describe 下单统一支付接口 支付结果以EventBus的形式返回
 *           LiveEventConst.ALI_PAY   支付宝支付结果通知
 * @Author wolf king
 * @editor 修改人
 * @CreateDate 2021/8/19
 * @UpdateDate 2021/8/19 更新时间
 */
interface PaymentStrategy {
    /**
     * 支付策略
     * @param data 支付参数
     */
    fun toPlay(activity: Activity, data: Any)
}