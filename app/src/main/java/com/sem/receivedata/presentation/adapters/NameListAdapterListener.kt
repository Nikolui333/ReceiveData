package com.sem.receivedata.presentation.adapters

import androidx.fragment.app.Fragment

interface NameListAdapterListener {

    fun itemClick(position : Int, fragment: Fragment)

}