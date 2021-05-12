package edu.ni.abra.retrofit

import retrofit2.http.GET

interface CatRetrofit {
    @GET("https://api.thecatapi.com/v1/breeds")
    suspend fun getCats(): List<CatNetworkEntity>
}