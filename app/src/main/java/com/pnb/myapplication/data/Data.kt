package com.pnb.myapplication.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.pnb.myapplication.R

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