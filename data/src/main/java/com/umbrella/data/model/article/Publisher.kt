package com.umbrella.data.model.article

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Publisher(val id: String, val icon: String, val publisherName: String) : Parcelable