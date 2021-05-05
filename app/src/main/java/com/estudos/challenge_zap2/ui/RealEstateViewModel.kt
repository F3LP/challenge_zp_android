package com.estudos.challenge_zap2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.estudos.challenge_zap.model.RealEstate

class RealEstateViewModel(private val repository: RealEstateRepositoryImpl) : ViewModel() {

    private val _getRealEstate = MutableLiveData<Unit>()

    val result: LiveData<List<RealEstate>>
        get() = _getRealEstate.switchMap {
            repository.getAllRealEstate()
        }

    fun getRealEstate() {
        _getRealEstate.postValue(Unit)
    }

}

