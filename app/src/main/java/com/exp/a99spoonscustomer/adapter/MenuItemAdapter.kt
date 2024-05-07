package com.exp.a99spoonscustomer.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.exp.a99spoonscustomer.databinding.MenuTileBinding
import com.exp.a99spoonscustomer.model.MenuItem
import com.squareup.picasso.Picasso


class MenuItemAdapter(context: Context, courseModelArrayList: ArrayList<MenuItem>) :
    ArrayAdapter<MenuItem>(context, 0, courseModelArrayList) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: MenuTileBinding = MenuTileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.itemName.text = getItem(position)?.name ?: ""
        Picasso.get().load(getItem(position)?.image ?: "").into(binding.itemImage)
        return binding.root
    }
}