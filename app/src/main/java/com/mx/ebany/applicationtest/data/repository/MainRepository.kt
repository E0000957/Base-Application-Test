package com.mx.ebany.applicationtest.data.repository

import com.mx.ebany.applicationtest.data.local.entities.UsersEntity


interface MainRepository  {
    suspend fun saveUser(data: UsersEntity)
    suspend fun getUsers():List<UsersEntity>
}