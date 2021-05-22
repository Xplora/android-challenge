package com.xplora.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xplora.challenge.DataRepository.XploraRepository
import com.xplora.challenge.model.ModuleResponse
import com.xplora.challenge.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ModuleListViewModel : ViewModel() {

    private var repository: XploraRepository? = null
    private var moduleResponse: MutableLiveData<Resource<ModuleResponse?>>? = null

    init {

        repository = XploraRepository()
        moduleResponse = MutableLiveData()
    }

    fun getModuleList(): LiveData<Resource<ModuleResponse?>>? = moduleResponse

    fun callModulesAPI() {

        viewModelScope.launch(Dispatchers.IO){
            moduleResponse?.postValue(Resource.loading())
            moduleResponse?.postValue(repository?.getModules())
        }
    }
}