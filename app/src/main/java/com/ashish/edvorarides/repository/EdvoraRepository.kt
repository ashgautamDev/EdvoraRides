package com.ashish.edvorarides.repository

import com.ashish.edvorarides.data.api.EdvoraApi
import com.ashish.edvorarides.data.api.RidesResponse
import com.ashish.edvorarides.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EdvoraRepository @Inject constructor(private val edvoraApi: EdvoraApi) {


    suspend fun getUser(): Flow<User> {
        return flow {
            val response = edvoraApi.getUser()
            emit(response)

        }.flowOn(Dispatchers.Main)
    }

    suspend fun getAllRides() : Flow<RidesResponse>{
        return flow {
            val response = edvoraApi.getAllRides()
            emit(response)


        }.flowOn(Dispatchers.Main)
    }

}