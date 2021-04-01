package com.estudos.challenge_zap2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.RealEstateRepositoryImpl

class RealEstateViewModel(private val repository: RealEstateRepositoryImpl) : ViewModel() {

    private var _result = MutableLiveData<List<RealEstate>>()

    val result: LiveData<List<RealEstate>>
        get() = _result

    fun getRealEstate(): MutableLiveData<List<RealEstate>> {
        _result = repository.getAllRealEstate()
        return _result
    }

}

