package com.ayd.avatarproject.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ayd.avatarproject.data.Avatar
import com.ayd.avatarproject.databinding.AvatarRowLayoutBinding
import java.io.File


class AvatarAdapter(
    private val avatarList: MutableList<Avatar>,
    private val listener: AvatarListener
    ) : RecyclerView.Adapter<AvatarAdapter.ViewHolder>(){

    private lateinit var binding: AvatarRowLayoutBinding

    class ViewHolder(binding: AvatarRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        private val name = binding.nameTextView
        private val nation = binding.NationTextView
        private val age = binding.GenderTextView
        private val image = binding.avatarImageView

        fun bind(avatar: Avatar, listener: AvatarListener){
            name.text = avatar.name
            nation.text = avatar.nationality
            age.text = avatar.age
            image.load(avatar.imageUrl)


            itemView.setOnClickListener{
                listener.onClicked(avatar)
            }

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = AvatarRowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(avatarList[position],listener)

    }

    override fun getItemCount(): Int {
        return avatarList.size
    }


    interface AvatarListener {
        fun onClicked(avatar: Avatar)
    }

}