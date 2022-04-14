package dev.jocey.model.retrofit

import dev.jocey.model.retrofit.entityes.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/search/")
    fun searchCharacters(
        @Query("q") name: String, @Query("type") type: String, @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Single<ApiResponse>
}