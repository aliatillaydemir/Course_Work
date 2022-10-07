package com.ayd.avatarproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ayd.avatarproject.R
import com.ayd.avatarproject.adapter.AvatarAdapter
import com.ayd.avatarproject.data.Avatar
import com.ayd.avatarproject.data.dataModels
import com.ayd.avatarproject.databinding.FragmentAvatarListBinding
import com.ayd.avatarproject.util.Constants.Companion.MAIN_ARGUMENT


class AvatarListFragment : Fragment(), AvatarAdapter.AvatarListener {

    private var _binding: FragmentAvatarListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAvatarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
        recyclerView = binding.recyclerView

        recyclerView.adapter = AvatarAdapter(dataModels,this@AvatarListFragment)

    }

    override fun onClicked(avatar: Avatar) {
        navController.navigate(R.id.action_avatarListFragment_to_avatarDetailsFragment, Bundle().apply {
        putString(MAIN_ARGUMENT,avatar.toJson())  //nav_graph'taki nav argument
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}