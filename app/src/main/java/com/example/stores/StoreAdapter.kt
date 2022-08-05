package com.example.stores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stores.databinding.ItemStoreBinding

class StoreAdapter(private var stores: MutableList<Store>,
var listener: OnClickListener) : RecyclerView.Adapter<StoreAdapter.ViewHolder>(){

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view =LayoutInflater.from(mContext).inflate(R.layout.item_store, parent, false )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores.get(position)

        with(holder){
            setOnClickListener(store)
            binding.tvNameStore.text = store.name
        }

    }

    override fun getItemCount():  Int = stores.size

    fun add(store: Store) {
        stores.add(store)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
       val binding = ItemStoreBinding.bind(view)

        fun setOnClickListener(store: Store){
            binding.root.setOnClickListener { listener.onClick(store) }
        }
    }


}