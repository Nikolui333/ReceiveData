package com.sem.receivedata.com.sem.receivedata.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.domain.repository.DescriptionCall
import com.sem.receivedata.domain.useCase.DescriptionUseCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class DescriptionUseCaseTest {

    val userRepository = mock<DescriptionCall>()

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun loadExchangeRate() {

        val testLiveData = listOf<PaginationLocalModel>(PaginationLocalModel(0, "name", "data", "description")
            , PaginationLocalModel(1, "name2", "data2", "description2"))

        val liveData = MutableLiveData<List<PaginationLocalModel>>()
        liveData.value = testLiveData
        Mockito.`when`(userRepository.loadDescription()).thenReturn(liveData)

        val useCase = DescriptionUseCase(userRepository)
        val actual = useCase.loadDescription()

        val liveData2 = MutableLiveData<List<PaginationLocalModel>>()
        liveData2.value = listOf<PaginationLocalModel>(PaginationLocalModel(0, "name", "data", "description"),
            PaginationLocalModel(1, "name2", "data2", "description2"))

        Assert.assertEquals(liveData2.value!!.get(0).id, actual.value!!.get(0).id)
        Assert.assertEquals(liveData2.value!!.get(0).name, actual.value!!.get(0).name)
        Assert.assertEquals(liveData2.value!!.get(0).date, actual.value!!.get(0).date)
        Assert.assertEquals(liveData2.value!!.get(0).description, actual.value!!.get(0).description)
        Assert.assertEquals(liveData2.value!!.get(1).id, actual.value!!.get(1).id)
        Assert.assertEquals(liveData2.value!!.get(1).name, actual.value!!.get(1).name)
        Assert.assertEquals(liveData2.value!!.get(1).date, actual.value!!.get(1).date)
        Assert.assertEquals(liveData2.value!!.get(1).description, actual.value!!.get(1).description)
    }

}