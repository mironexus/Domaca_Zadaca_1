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

        if(currentItem != null) {
            if (currentItem.favorite)
            holder.imageView.setImageResource(R.drawable.ic_baseline_star_24)

            holder.textView1.text = "${currentItem.name} ${currentItem.surname}, ${currentItem.gender}, ${currentItem.age}"
            holder.textView2.text = "${currentItem.phoneNumber}"
            holder.textView3.text = "${currentItem.email}, ${currentItem.faculty}"
            holder.textView4.text = "${currentItem.oib}, ${currentItem.country}"
        }

    }


    override fun getItemCount() = contactsList.value!!.size

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.top_info
        val textView2: TextView = itemView.middle_top_info
        val textView3: TextView = itemView.middle_bottom_info
        val textView4: TextView = itemView.bottom_info
    }


}