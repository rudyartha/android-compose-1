package com.pnb.myapplication.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.pnb.myapplication.R
import com.pnb.myapplication.data.product.Product
import java.math.BigDecimal

data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
    val index: Int
)

val alignYourBodyData = listOf(
    DrawableStringPair(R.drawable.ab1_inversions, R.string.ab1_inversions, 0),
    DrawableStringPair(R.drawable.ab2_quick_yoga, R.string.ab2_quick_yoga, 1),
    DrawableStringPair(R.drawable.ab3_stretching, R.string.ab3_stretching, 2),
    DrawableStringPair(R.drawable.ab4_tabata, R.string.ab4_tabata, 3),
    DrawableStringPair(R.drawable.ab5_hiit, R.string.ab5_hiit, 4),
    DrawableStringPair(R.drawable.ab6_pre_natal_yoga, R.string.ab6_pre_natal_yoga, 5)
)

val favoriteCollectionsData = listOf(
    DrawableStringPair(R.drawable.fc1_short_mantras, R.string.fc1_short_mantras, 0),
    DrawableStringPair(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations, 1),
    DrawableStringPair(R.drawable.fc3_stress_and_anxiety, R.string.fc3_stress_and_anxiety, 2),
    DrawableStringPair(R.drawable.fc4_self_massage, R.string.fc4_self_massage, 3),
    DrawableStringPair(R.drawable.fc5_overwhelmed, R.string.fc5_overwhelmed, 4),
    DrawableStringPair(R.drawable.fc6_nightly_wind_down, R.string.fc6_nightly_wind_down, 5)
)

val products = listOf(
    Product(1, "Yoga Mat", BigDecimal(10000)),
    Product(2, "Yoga Mat bag", BigDecimal(5000)),
    Product(3, "Comfortable Exercise Clothes", BigDecimal(50000)),
    Product(4, "Water Bottle", BigDecimal(25000)),
    Product(5, "Yoga Block", BigDecimal(35000)),
    Product(6, "Yoga Strap", BigDecimal(15000))
)