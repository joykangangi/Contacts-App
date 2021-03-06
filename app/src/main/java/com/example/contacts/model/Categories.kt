package com.example.contacts.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Categories (
    @StringRes val categoryName: Int,
   @DrawableRes val categoryImage: Int
) {
}