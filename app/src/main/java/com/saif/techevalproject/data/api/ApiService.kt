package com.saif.techevalproject.data.api

import com.saif.techevalproject.model.SeriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//https://www.amiiboapi.com/api/amiibo/?name=mario
    @GET("/api/amiibo")
    suspend fun getSeries(@Query("name") name: String): SeriesResponse
}