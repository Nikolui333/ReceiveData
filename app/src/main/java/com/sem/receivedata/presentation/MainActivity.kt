package com.sem.receivedata.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sem.receivedata.R
import com.sem.receivedata.databinding.ActivityMainBinding
import com.sem.receivedata.presentation.viewModel.NameListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val nameListViewModel: NameListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        nameListViewModel.migration(this)
    }
}