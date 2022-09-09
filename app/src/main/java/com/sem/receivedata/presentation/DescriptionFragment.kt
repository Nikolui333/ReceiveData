package com.sem.receivedata.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sem.receivedata.R
import com.sem.receivedata.databinding.FragmentDescriptionBinding
import com.sem.receivedata.presentation.viewModel.DescriptionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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

        })

        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {

                    val fragment = NameListFragment()

                    val activity=context/*context*/ as AppCompatActivity
                    activity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout, fragment).
                        addToBackStack(null)
                        .commit()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

}