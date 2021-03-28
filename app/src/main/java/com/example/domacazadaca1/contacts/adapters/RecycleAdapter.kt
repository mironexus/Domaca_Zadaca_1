package com.example.domacazadaca1.contacts.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.domacazadaca1.R
import com.example.domacazadaca1.contacts.phonebook.RecyclerItemActivity
import com.example.domacazadaca1.models.Contact
import kotlinx.android.synthetic.main.recycler_item.view.*


class RecycleAdapter(private val contactsList: MutableLiveData<ArrayList<Contact>>,
private val listener:OnItemClickListener) :
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

//        @Override
//        fun onClick(v: View) {
//            val intent = Intent(v.context, RecyclerItemActivity.class)
//            startActivity(intent)
//           v.context.startActivity(Intent(v.context, RecyclerItemActivity::class.java))
//        }


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

    inner class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.top_info
        val textView2: TextView = itemView.middle_top_info
        val textView3: TextView = itemView.middle_bottom_info
        val textView4: TextView = itemView.bottom_info

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val currentItem = contactsList.value?.get(position)
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
            // vidjeti hoce li ovo raditi za svaki item specificno (hoce li povuci podatke tog itema)
            if (v != null) {
                //v.context.startActivity(Intent(v.context, RecyclerItemActivity::class.java))
                var intent = Intent(v.context, RecyclerItemActivity::class.java)
                if (currentItem != null) {
                    intent.putExtra("name", currentItem.name)
                    intent.putExtra("surname", currentItem.surname)
                    intent.putExtra("age", currentItem.age)
                }
                v.context.startActivity(intent)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }



}