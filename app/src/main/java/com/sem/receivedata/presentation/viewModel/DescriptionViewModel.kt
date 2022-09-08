package com.sem.receivedata.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.sem.receivedata.domain.useCase.DescriptionUseCase
import com.sem.receivedata.domain.useCase.NameListUseCase

class DescriptionViewModel(private val descriptionUseCase: DescriptionUseCase) : ViewModel() {

    val loadDescription = descriptionUseCase.loadDescription()

}