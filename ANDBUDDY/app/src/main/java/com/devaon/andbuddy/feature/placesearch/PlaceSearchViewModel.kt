package com.devaon.andbuddy.feature.placesearch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devaon.andbuddy.data.datasource.model.Place
import com.devaon.andbuddy.data.repository.PlaceSearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class PlaceSearchViewModel : ViewModel() {
    private val placeSearchRepository: PlaceSearchRepository = PlaceSearchRepository()
    private val disposables = CompositeDisposable()

    val placeList = MutableLiveData<List<Place>>()

    fun getAddress(search: String) {
        disposables.add(placeSearchRepository.getAddress(search)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
            }
            .doOnTerminate {}
            .subscribe {
                placeList.value = it.message
            }
        )
    }
    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}
