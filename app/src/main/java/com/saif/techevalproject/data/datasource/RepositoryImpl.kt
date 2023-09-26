package com.saif.techevalproject.data.datasource

import android.util.Log
import com.saif.techevalproject.data.api.ApiService
import com.saif.techevalproject.model.SeriesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: ApiService,
    private val dispatcher: CoroutineDispatcher
) : Repository {
    override suspend fun getSeries(name: String): Flow<SeriesResponse?> = flow {
        try {
            emit(service.getSeries(name))
        } catch (e: Exception) {
            Log.i("api-fail", e.message?:"")
            emit(null)
        }
    }.flowOn(dispatcher)
}