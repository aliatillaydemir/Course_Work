package com.ayd.avatarproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.ayd.avatarproject.R
import com.ayd.avatarproject.data.Avatar
import com.ayd.avatarproject.databinding.FragmentAvatarDetailsBinding
import com.ayd.avatarproject.util.Constants.Companion.MAIN_ARGUMENT

class AvatarDetailsFragment : Fragment() {

    private var _binding: FragmentAvatarDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAvatarDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        arguments?.let {
            val avatarData = it.getString(MAIN_ARGUMENT)

            avatarData?.let {
                val avatar = Avatar.fromJson(it)

                    binding.textName.text = avatar.name
                    binding.textNation.text = avatar.nationality
                    binding.textAge.text = avatar.age
                    binding.avatarImage.load(avatar.imageUrl)
                    binding.textDescription.text = avatar.desc

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}