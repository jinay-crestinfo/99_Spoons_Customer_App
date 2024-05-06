package com.exp.a99spoonscustomer.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exp.a99spoonscustomer.databinding.PromoTileViewBinding
import com.exp.a99spoonscustomer.model.PromotionCard


class PromoAdapter(
    private var items: List<PromotionCard>,

    ) :
    RecyclerView.Adapter<PromoAdapter.ViewHolder>() {
    lateinit var binding:
            PromoTileViewBinding

    inner class ViewHolder(binding: PromoTileViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PromoTileViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
                binding.promoCardTitle.text = items[position].title
                binding.promoCardDesc.text = items[position].subtitle
                binding.promoCardCode.text = items[position].code
            }
        }
    }
}