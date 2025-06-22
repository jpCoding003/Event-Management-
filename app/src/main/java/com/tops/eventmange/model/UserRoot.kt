package com.tops.eventmange.model


import com.google.gson.annotations.SerializedName

data class UserRoot(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("users")
    val users: List<User>
)