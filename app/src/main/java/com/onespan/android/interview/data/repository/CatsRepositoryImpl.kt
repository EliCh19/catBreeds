package com.onespan.android.interview.data.repository

import Item
import com.onespan.android.interview.common.Resource
import com.onespan.android.interview.data.remote.CatsAPI
import com.onespan.android.interview.domain.repository.CatsRepository
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(private val api: CatsAPI) :
    CatsRepository {

    override suspend fun getBreeds(): Resource<Item> {
        val response = try {
            Resource.Loading(data = true)
            api.getBreeds()
        } catch (e: Exception) {
            return Resource.Error(message = "An error occurred ${e.message.toString()}")
        }
        Resource.Loading(data = false)
        return Resource.Success(data = response)
    }
}