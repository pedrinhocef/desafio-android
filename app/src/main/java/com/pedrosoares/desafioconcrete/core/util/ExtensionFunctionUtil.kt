package com.pedrosoares.desafioconcrete.core.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.dateFormat(date: String): String{
    val format = SimpleDateFormat(date, Locale.US)
    val data = format.parse(this)
    format.applyPattern("dd/MM/yyyy")
    return format.format(data)
}

fun Int.decimalFormat(): String {
    return DecimalFormat("#,###").format(this)
}