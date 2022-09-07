package com.sem.receivedata.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sem.receivedata.domain.useCase.NameListUseCase
import kotlinx.coroutines.launch

class NameListViewModel(private val nameListUseCase: NameListUseCase) : ViewModel() {

    val loadNameList = nameListUseCase.loadNameList()

    fun migration(context: Context) = viewModelScope.launch {
        nameListUseCase.startMigration(context)
    }

}