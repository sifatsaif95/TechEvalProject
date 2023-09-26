package com.saif.techevalproject.di

import com.saif.techevalproject.data.api.ApiService
import com.saif.techevalproject.data.api.RetrofitBuilder
import com.saif.techevalproject.data.datasource.Repository
import com.saif.techevalproject.data.datasource.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideService(): ApiService =
        RetrofitBuilder.getRetrofit().create(ApiService::class.java)

    @Provides
    fun provideDispatcher() = Dispatchers.IO

    @Provides
    fun provideRepository(apiService: ApiService, dispatcher: CoroutineDispatcher): Repository =
        RepositoryImpl(apiService, dispatcher)
}