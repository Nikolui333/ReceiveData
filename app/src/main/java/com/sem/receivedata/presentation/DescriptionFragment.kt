package com.sem.receivedata.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.sem.receivedata.R
import com.sem.receivedata.databinding.FragmentNameListBinding
import com.sem.receivedata.presentation.viewModel.DescriptionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DescriptionFragment : Fragment() {

    private var binding : FragmentNameListBinding? = null
    private val descriptionViewModel : DescriptionViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name_list, container, false)

      //  binding.name.text
        return binding?.root
    }

}