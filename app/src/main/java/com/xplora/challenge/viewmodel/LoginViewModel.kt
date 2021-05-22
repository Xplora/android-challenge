package com.xplora.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xplora.challenge.helpers.SingleLiveEvent
import com.xplora.challenge.DataRepository.XploraRepository
import com.xplora.challenge.helpers.Validation
import com.xplora.challenge.model.LoginResponse
import com.xplora.challenge.network.Resource
import com.xplora.challenge.request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var repository: XploraRepository? = null
    private var loginResponse: MutableLiveData<Resource<LoginResponse?>>? = null
    val loginRequest = LoginRequest()
    var loginClick: SingleLiveEvent<Boolean>? = null
    var snackBarMessage = MutableLiveData<Any>()

    init {

        repository = XploraRepository()
        loginResponse = MutableLiveData()
        loginClick = SingleLiveEvent()
    }

    fun getSnakeBarMessage(): MutableLiveData<Any> {
        return snackBarMessage
    }

    fun onLoginClick(){

        when {

            loginRequest.email?.trim().isNullOrEmpty() -> {
                snackBarMessage.value = "Please enter email"
            }
            !Validation.isEmailValid(loginRequest.email?.trim()) -> {
                snackBarMessage.value = "Please enter valid email"
            }
            loginRequest.password?.trim().isNullOrEmpty() -> {
                snackBarMessage.value = "Please enter password"
            }
            else -> {
                callLoginAPI()
            }
        }
    }

    fun getLoginResponse():LiveData<Resource<LoginResponse?>>? = loginResponse

    private fun callLoginAPI() {

        viewModelScope.launch(Dispatchers.IO){
            loginResponse?.postValue(Resource.loading())
            loginResponse?.postValue(repository?.getLogin(loginRequest.email,loginRequest.password))
        }
    }
}