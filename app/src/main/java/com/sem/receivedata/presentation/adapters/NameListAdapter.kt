package com.sem.receivedata.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sem.receivedata.R
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.databinding.NameListItemBinding

class NameListAdapter() : RecyclerView.Adapter<NameListAdapter.NameListHolder>() {

    private val pagination = ArrayList<PaginationLocalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: NameListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.name_list_item, parent, false)
        return NameListHolder(binding)
    }

    override fun onBindViewHolder(holder: NameListHolder, position: Int) {
        holder.bind(pagination[position])
    }

    override fun getItemCount(): Int {
        return pagination.size
    }

    fun setList(exchangeRateList: List<PaginationLocalModel>) {
        pagination.clear()
        pagination.addAll(exchangeRateList)
    }

    class NameListHolder(val binding: NameListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(paginationLocalModel: PaginationLocalModel){

            binding.name.text = paginationLocalModel.name

        }

    }

}