package com.sem.receivedata.presentation.di

import androidx.room.Room
import com.sem.receivedata.data.dataSource.ApiDataSource
import com.sem.receivedata.data.dataSource.PaginationDataSource
import com.sem.receivedata.data.dataSourceIMPL.ApiDataSourceIMPL
import com.sem.receivedata.data.dataSourceIMPL.DataSourceIMPL
import com.sem.receivedata.data.localDB.PaginationDB
import com.sem.receivedata.data.repository.DescriptionRepository
import com.sem.receivedata.data.repository.NameListRepository
import com.sem.receivedata.domain.repository.DescriptionCall
import com.sem.receivedata.domain.repository.NameListCall
import com.sem.receivedata.domain.useCase.DescriptionUseCase
import com.sem.receivedata.domain.useCase.NameListUseCase
import com.sem.receivedata.presentation.viewModel.DescriptionViewModel
import com.sem.receivedata.presentation.viewModel.NameListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nameList = module {

    single {
        Room.databaseBuilder(
            androidContext(), PaginationDB::class.java,
            "dbO"
        ).build()
    }

    single { get<PaginationDB>().paginationDao }

    single<PaginationDataSource> {
        DataSourceIMPL(
            get()
        )
    }

    single<ApiDataSource> {
        ApiDataSourceIMPL(
            get()
        )
    }


    single<NameListCall> { NameListRepository(get(),get()) }


    single { NameListUseCase(get()) }


    viewModel { NameListViewModel(get()) }

}

val description = module {

    single {
        Room.databaseBuilder(
            androidContext(), PaginationDB::class.java,
            "dbO"
        ).build()
    }

    single { get<PaginationDB>().paginationDao }

    single<PaginationDataSource> {
        DataSourceIMPL(
            get()
        )
    }

    single<DescriptionCall> { DescriptionRepository(get()) }


    single { DescriptionUseCase(get()) }


    viewModel { DescriptionViewModel(get()) }

}