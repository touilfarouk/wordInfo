package com.plcoding.dictionary.feature_deliverer.data.remote

import com.plcoding.dictionary.feature_deliverer.data.remote.dto.Deliverer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DelivererApi {
    @GET("deliverers/{categories}/{name}")
    suspend fun getDeliverers(
        @Path("categories") category: String,
        @Path("name") name: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Deliverer> // must match your model
}