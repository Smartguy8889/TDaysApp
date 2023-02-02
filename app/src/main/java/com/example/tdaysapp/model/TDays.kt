package com.example.tdaysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TDays(
    @StringRes val stringResourceId: Int,
    @StringRes val stringQuoteId: Int,
    @StringRes val stringDescId: Int,
    @DrawableRes val imageResourceId: Int

)