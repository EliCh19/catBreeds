package com.onespan.android.interview.domain.repository

import Item
import com.onespan.android.interview.common.Resource

interface CatsRepository {
    suspend fun getBreeds(): Resource<Item>
}