
package com.sem.receivedata.presentation.adapters

import android.os.Bundle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.sem.receivedata.R
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.databinding.NameListItemBinding
import com.sem.receivedata.presentation.DescriptionFragment
import com.sem.receivedata.presentation.NameListFragment
import android.util.Log

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
        holder.bind(pagination[position], position, listener /*context*/)
    }

    override fun getItemCount(): Int {
        return pagination.size
    }

    fun setList(exchangeRateList: List<PaginationLocalModel>) {
        pagination.clear()
        pagination.addAll(exchangeRateList)
    }

    class NameListHolder(val binding: NameListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(paginationLocalModel: PaginationLocalModel, position: Int, /*context: NameListFragment, */listener: NameListAdapterListener){

            binding.name.text = paginationLocalModel.name
            itemView.setOnClickListener{

                val fragment = DescriptionFragment()
                // DialogFragment()
                val bundle = Bundle()
                bundle.putInt("position", 5)
                fragment.setArguments(bundle)

                listener.itemClick(position, fragment)

/*                val fragment = DescriptionFragment()
                val bundle = Bundle()
                bundle.putInt("position", position)
                fragment.setArguments(bundle)

                val activity=context.context as AppCompatActivity
                activity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.framelayout, fragment)
                    .commitNow()*/

                Log.d("OnClick", "произошло нажатие по позиции $position")
            }

        }

    }

}