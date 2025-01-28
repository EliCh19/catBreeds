package com.onespan.android.interview.data.remote.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("breed")
    val breed: String,
    @SerializedName("coat")
    val coat: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("pattern")
    val pattern: String
)