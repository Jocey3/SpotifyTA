package dev.jocey.model.retrofit.entityes

import com.google.gson.annotations.SerializedName

data class ApiTrack(
    @SerializedName("href") val href: String,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("total") val total: Int,
    @SerializedName("items") val items: List<ApiItem>
)
