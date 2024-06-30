package com.uz.ustudy.ui.profile.auth.otp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.uz.ustudy.model.User
import com.uz.ustudy.repository.OTPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class OTPViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: OTPRepository
) : ViewModel() {

    private val sguid = savedStateHandle.get<String>("guid")
    private val sphone = savedStateHandle.get<String>("phone")

    private var _phone: MutableLiveData<String> = MutableLiveData("")
    val phone: LiveData<String> = _phone

    private var _guid: MutableLiveData<String> = MutableLiveData("")
    val guid: LiveData<String> = _guid

    init {
        _phone.value = sphone.toString()
        _guid.value = sguid.toString()
    }

    fun verifyOTP(sms: String) = flow {
        repository.validate(guid.value.toString(), sms).collect {
            emit(it)
        }
    }

    fun writeToDb(user: User) = repository.writeToDb(user)
}