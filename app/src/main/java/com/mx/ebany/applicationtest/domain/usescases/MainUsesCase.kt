package com.mx.ebany.applicationtest.domain.usescases

import com.mx.ebany.applicationtest.data.local.entities.UsersEntity
import com.mx.ebany.applicationtest.data.repository.MainRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainUsesCase @Inject constructor(private val repository: MainRepository) {

        suspend fun saveUser(data: UsersEntity) = flow {
            try {
                val result = repository.saveUser(data)
                emit(Result.success(result))
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }

        suspend fun getUsers() = flow {
            try {
                val users = repository.getUsers()
                emit(Result.success(users))
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }
}
