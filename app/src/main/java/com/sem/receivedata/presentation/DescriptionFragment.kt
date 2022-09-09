package com.sem.receivedata.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.sem.receivedata.R
import com.sem.receivedata.databinding.FragmentDescriptionBinding
import com.sem.receivedata.databinding.FragmentNameListBinding
import com.sem.receivedata.presentation.viewModel.DescriptionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer

class DescriptionFragment : Fragment() {

    private var binding : FragmentDescriptionBinding? = null
    private val descriptionViewModel : DescriptionViewModel by viewModel()

    val position: Int = getArguments()?.getInt("position", 0) ?: 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_description, container, false)

        binding?.name?.text = descriptionViewModel.loadDescription.value?.get(position)?.name
        Log.d("OnClick", "name во втором фрагменте " + descriptionViewModel.loadDescription.value?.get(position)?.name)
        binding?.date?.text = descriptionViewModel.loadDescription.value?.get(position)?.date
        binding?.description?.text = descriptionViewModel.loadDescription.value?.get(position)?.description

        descriptionViewModel?.loadDescription?.observe(viewLifecycleOwner, Observer {

            binding?.name?.text = it.get(position).name
            binding?.date?.text = it.get(position).date
            binding?.description?.text = it.get(position).description
            
            //nameListAdapter?.setList(it)
          //  nameListAdapter?.notifyDataSetChanged()
        })

        return binding?.root
    }

}