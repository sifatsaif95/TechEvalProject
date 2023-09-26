package com.saif.techevalproject.data.datasource

import com.saif.techevalproject.model.SeriesResponse
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getSeries(name: String): Flow<SeriesResponse?>
}