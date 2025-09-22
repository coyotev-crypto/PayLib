package com.lrh.pay.payment.paydata

data class AliPayRequest(
    val payInfo: String,
    val mSandbox: Boolean = false
)