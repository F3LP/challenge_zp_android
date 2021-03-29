package com.estudos.challenge_zap2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.RealEstateRepositoryImpl

class RealEstateViewModel(private val repository: RealEstateRepositoryImpl) : ViewModel() {
    private val _result = MutableLiveData<RealEstate>()
    val result: LiveData<RealEstate>
        get() = _result

//    fun fetchRealEstate() {
//        if (_result.value == null) {
//            viewModelScope.launch {
//                repository.getAllRealEstate().collect {
//                    _result.postValue(it)
//                }
//            }
//
//        }
//    }

}