package com.lrh.pay.payment.paydata

data class WechatPayRequest(
    val timeStamp: String,
    val paySign: String,
    val appId: String,
    val signType: String,
    val prepayId: String,
    val nonceStr: String,
    val partnerId: String
)