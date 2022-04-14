package dev.jocey.model.retrofit.entityes

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("tracks") val results: ApiTrack
)
