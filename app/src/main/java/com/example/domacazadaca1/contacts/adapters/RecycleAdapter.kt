package com.example.domacazadaca1.contacts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.domacazadaca1.models.Contact
import com.example.domacazadaca1.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecycleAdapter(private val contactsList: MutableLiveData<ArrayList<Contact>>) :
    RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_item,
            parent, false)
        return RecycleViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val currentItem = contactsList.value?.get(position)
        if (currentItem != null) {
            holder.textView1.text = "${currentItem.name} ${currentItem.surname}, ${currentItem.age}"
        }
        if (currentItem != null) {
            holder.textView2.text = "${currentItem.faculty}, ${currentItem.oib}"
        }
    }


    override fun getItemCount() = contactsList.value!!.size

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.top_info
        val textView2: TextView = itemView.bottom_info
    }


}