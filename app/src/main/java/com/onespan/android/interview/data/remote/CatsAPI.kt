package com.onespan.android.interview.data.remote

import Item
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface CatsAPI {
    @GET("/breeds")
    suspend fun getBreeds(): Item
}