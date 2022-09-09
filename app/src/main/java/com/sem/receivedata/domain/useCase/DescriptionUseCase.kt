package com.sem.receivedata.domain.useCase

import android.util.Log
import androidx.lifecycle.LiveData
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.domain.repository.DescriptionCall

class DescriptionUseCase(private val descriptionCall: DescriptionCall) {

    fun loadDescription(): LiveData<List<PaginationLocalModel>> {

        Log.d("OnClick", "DescriptionUseCase " + descriptionCall.loadDescription())
        return descriptionCall.loadDescription()

    }

}