package com.example.submissionsmyfoods

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val name: String,
    val context: String,
    val description: String,
    val recipe: String,
    val photo: Int
) : Parcelable