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
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.domacazadaca1.R
import com.example.domacazadaca1.contacts.phonebook.RecyclerItemActivity
import com.example.domacazadaca1.models.Contact
import kotlinx.android.synthetic.main.recycler_item.view.*


class RecycleAdapter(private val contactsList: MutableLiveData<ArrayList<Contact>>,
private val listener: OnItemClickListener) :
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
            if (currentItem.favorite)  {
                holder.imageView.load(R.drawable.ic_baseline_star_24)
            }
            else {
                holder.imageView.load(currentItem.imageUri) {
                    transformations(RoundedCornersTransformation(100f))
                }
            }

            holder.textView1.text = "${currentItem.name} ${currentItem.surname}, ${currentItem.age}"
            holder.textView2.text = "${currentItem.oib}"
        }

    }


    override fun getItemCount() = contactsList.value!!.size

    inner class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.top_info
        val textView2: TextView = itemView.bottom_info

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val currentItem = contactsList.value?.get(position)
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
            if (v != null) {
                var intent = Intent(v.context, RecyclerItemActivity::class.java)
                if (currentItem != null) {
                    intent.putExtra("imageUri", currentItem.imageUri)
                    intent.putExtra("phoneNumber", currentItem.phoneNumber)
                    intent.putExtra("name", currentItem.name)
                    intent.putExtra("surname", currentItem.surname)
                    intent.putExtra("age", currentItem.age)
                    intent.putExtra("email", currentItem.email)
                    intent.putExtra("faculty", currentItem.faculty)
                    intent.putExtra("oib", currentItem.oib)
                    intent.putExtra("gender", currentItem.gender)
                    intent.putExtra("country", currentItem.country)
                    intent.putExtra("favorite", currentItem.favorite)
                }
                v.context.startActivity(intent)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }



}