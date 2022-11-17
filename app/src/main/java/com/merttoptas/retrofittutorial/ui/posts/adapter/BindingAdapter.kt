package com.merttoptas.retrofittutorial.ui.posts.adapter

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.merttoptas.retrofittutorial.data.model.Post
import com.merttoptas.retrofittutorial.data.model.PostDTO
import com.merttoptas.retrofittutorial.ui.posts.PostsFragmentDirections

class BindingAdapter {

    companion object{

        @androidx.databinding.BindingAdapter("onClickListener")
        @JvmStatic
        fun onClickListener(postLayout: ConstraintLayout, post: PostDTO){
            postLayout.setOnClickListener{
                try{
                    val action = PostsFragmentDirections.actionPostsFragmentToDetailFragment(post)
                    postLayout.findNavController().navigate(action)
                }catch (e: Exception){
                    println("Error message: " +e.message)
                }
            }
        }


    }

}