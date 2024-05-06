package com.exp.a99spoonscustomer.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exp.a99spoonscustomer.databinding.NotificationTilesBinding
import com.exp.a99spoonscustomer.model.Notification


class NotificationAdapter(
    private var items: List<Notification>,

    ) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    lateinit var binding:
            NotificationTilesBinding

    inner class ViewHolder(binding: NotificationTilesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding =
            NotificationTilesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {

        }
        with(holder)
        {
            with(items[position]) {
                binding.title.text = items[position].title
                binding.details.text = items[position].subtitle
            }
        }
    }
}