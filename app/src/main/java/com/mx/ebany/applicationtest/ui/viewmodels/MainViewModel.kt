package com.mx.ebany.applicationtest.ui.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mx.ebany.applicationtest.data.local.entities.UsersEntity
import androidx.lifecycle.viewModelScope
import com.mx.ebany.applicationtest.domain.usescases.MainUsesCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val usesCase: MainUsesCase

): ViewModel() {

    private val _userData = MutableLiveData<List<UsersEntity>?>()
    val userData: LiveData<List<UsersEntity>?> get() = _userData

    private val _saveStatus = MutableLiveData<Boolean>()
    val saveStatus: LiveData<Boolean> get() = _saveStatus

    fun loadUsers() {
        viewModelScope.launch {
            usesCase.getUsers().collect { result ->
                if (result.isSuccess) {
                    _userData.value = result.getOrNull()
                } else {
                    result.exceptionOrNull()?.printStackTrace()
                }
            }
        }
    }

    fun saveUser(user: UsersEntity) {
        viewModelScope.launch {
            usesCase.saveUser(user).collect { result ->
                _saveStatus.value = result.isSuccess
            }
        }
    }

}