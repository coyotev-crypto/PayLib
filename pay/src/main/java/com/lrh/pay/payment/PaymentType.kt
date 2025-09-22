package com.lrh.pay.payment

/**
 * @ProjectName houyuan_yacht_app
 * @Package com.houyuan.yacht.play
 * @Describe 支付类型
 * @Author wolf king
 * @editor 修改人
 * @CreateDate 2021/8/19
 * @UpdateDate 2021/8/19 更新时间
 */
enum class PaymentType(val values:Int) {
    ALIPAY(1), //支付宝支付
    WECHATPAY(2) //微信支付
}