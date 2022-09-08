package com.sem.receivedata.presentation.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sem.receivedata.R
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.databinding.NameListItemBinding
import com.sem.receivedata.presentation.DescriptionFragment
import com.sem.receivedata.presentation.NameListFragment


class NameListAdapter(var context: NameListFragment, var listener: NameListAdapterListener
) : RecyclerView.Adapter<NameListAdapter.NameListHolder>() {

    private val pagination = ArrayList<PaginationLocalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: NameListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.name_list_item, parent, false)
        return NameListHolder(binding)
    }

    override fun onBindViewHolder(holder: NameListHolder, position: Int) {
        holder.bind(pagination[position], position, listener)
    }

    override fun getItemCount(): Int {
        return pagination.size
    }

    fun setList(exchangeRateList: List<PaginationLocalModel>) {
        pagination.clear()
        pagination.addAll(exchangeRateList)
    }

    class NameListHolder(val binding: NameListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(paginationLocalModel: PaginationLocalModel, position: Int, listener: NameListAdapterListener){

            binding.name.text = paginationLocalModel.name
            itemView.setOnClickListener{

                val fragment = DescriptionFragment()
                    // DialogFragment()
                val bundle = Bundle()
                bundle.putInt("someValue", 5)
                fragment.setArguments(bundle)

                listener.itemClick(position, fragment)
               // val intent = Intent(NameListFragment(), fragment)

/*                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fl_main, SecondFragment())
                transaction.disallowAddToBackStack()
                transaction.commit()*/
                Log.d("OnClick", "произошло нажатие по позиции $position")
            }

        }

    }

}