package com.sem.receivedata.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sem.receivedata.R
import com.sem.receivedata.databinding.FragmentNameListBinding
import com.sem.receivedata.presentation.adapters.NameListAdapter
import com.sem.receivedata.presentation.viewModel.NameListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.sem.receivedata.presentation.adapters.NameListAdapterListener
import org.xmlpull.v1.XmlPullParserFactory.newInstance

class NameListFragment : Fragment()/*, NameListAdapterListener*/ {

    private var nameListAdapter : NameListAdapter? = null
    private val nameListViewModel: NameListViewModel by viewModel()

    private var binding : FragmentNameListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name_list, container, false)

        initRecyclerExchangeRate()
        loadExchangeRate()

        return binding?.root
    }

    private fun initRecyclerExchangeRate(){

        binding?.listNameRV?.layoutManager =
            LinearLayoutManager(context)
        nameListAdapter = NameListAdapter(this/*, this*/)

        binding?.listNameRV?.adapter = nameListAdapter
    }

    private fun loadExchangeRate(){

        nameListViewModel?.loadNameList?.observe(viewLifecycleOwner, Observer {

            nameListAdapter?.setList(it)
            nameListAdapter?.notifyDataSetChanged()
        })
    }

/*    override fun itemClick(position : Int, fragment: Fragment) {
        loadFragment(fragment)

    }

    private fun loadFragment(fragment: Fragment){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.rd_fragment, fragment)
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }*/
}