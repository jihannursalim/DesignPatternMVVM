package com.example.designpatternmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.designpatternmvvm.databinding.ItemUserBinding
import com.example.designpatternmvvm.model.getAllUserItem

class UserAdapter (var listUser : List<getAllUserItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        var view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.binding.txtNama.text = listUser[position].name
        holder.binding.txtUmur.text = listUser[position].age.toString()
        holder.binding.txtAlamat.text = listUser[position].address
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

}