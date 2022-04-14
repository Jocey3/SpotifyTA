package dev.jocey.model.retrofit.entityes

import com.google.gson.annotations.SerializedName

data class ApiItem(
    @SerializedName("name") val name: String,
    @SerializedName("href") val href: String,
    @SerializedName("artists") val artists: List<ApiArtist>
)
