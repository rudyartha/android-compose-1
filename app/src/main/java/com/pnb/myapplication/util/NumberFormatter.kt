package com.pnb.myapplication.util

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

class NumberFormatter @Inject constructor() {
    private val formatter = DecimalFormat("#,###.##")

    fun formatNumber(number: BigDecimal): String {
        formatter.roundingMode = RoundingMode.CEILING
        return formatter.format(number)
    }
}