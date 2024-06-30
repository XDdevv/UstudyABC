package com.uz.ustudy.ui.profile.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.uz.ustudy.model.ResponseRegister
import com.uz.ustudy.model.User
import com.uz.ustudy.repository.RStep1Repository
import com.uz.ustudy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RStep1ViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val registerRepository: RStep1Repository
) : ViewModel() {

    private val name = savedStateHandle.get<String>("name")
    private val phone = savedStateHandle.get<String>("phone")
    private val password = savedStateHandle.get<String>("password")

    private var _user: MutableLiveData<User?> = MutableLiveData(User())
    val user: LiveData<User?> = _user

    init {
        setUserName(name.toString())
        setUserPhone(phone.toString())
        setUserPassword(password.toString())
    }

    private fun setUserName(name: String) {
        _user.value?.name = name
    }

    private fun setUserPhone(phone: String) {
        _user.value?.phone = phone
    }

    private fun setUserPassword(password: String) {
        _user.value?.password = password
    }

    fun setUserGuid(guid: String) {
        _user.value?.guid = guid
    }

    fun setUserTitle(title: String) {
        _user.value?.title = title
    }

    fun setUserImage(image: String) {
        _user.value?.image = image
    }

    fun setUserDiamonds(diamonds: Int) {
        _user.value?.diamonds = diamonds
    }

    fun setCratedAt(timestamp: Long) {
        _user.value?.createdAt = timestamp
    }

    fun registerUser(hashmap: HashMap<String, String>): Flow<Resource<ResponseRegister>> =
        registerRepository.getData(hashmap)

}