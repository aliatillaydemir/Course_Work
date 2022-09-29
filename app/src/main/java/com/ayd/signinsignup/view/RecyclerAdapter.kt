package com.ayd.signinsignup.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayd.signinsignup.databinding.RowItemBinding
import com.ayd.signinsignup.model.User


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()  {

    private lateinit var binding: RowItemBinding
    private var userList = emptyList<User>() //if i call List<User>(), i have to initialize it, but no problem now(cause i call emptyList<>())


    class ViewHolder(private val binding: RowItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = userList[position]
        binding.rowNumber.text = currentItem.uid.toString()
        binding.rowMail.text = currentItem.email.toString()
        binding.rowPass.text = currentItem.password.toString()
        binding.rowUsername.text = currentItem.username.toString()



    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user:List<User>){
        this.userList = user
        notifyDataSetChanged()
    }



}

