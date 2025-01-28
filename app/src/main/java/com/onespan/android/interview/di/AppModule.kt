package com.onespan.android.interview.di

import com.onespan.android.interview.data.remote.CatsAPI
import com.onespan.android.interview.data.repository.CatsRepositoryImpl
import com.onespan.android.interview.domain.repository.CatsRepository
import com.onespan.android.interview.utils.Constants
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCatsRepository(api: CatsAPI): CatsRepository {
        return CatsRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideCatsAPI(): CatsAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatsAPI::class.java)
    }
}