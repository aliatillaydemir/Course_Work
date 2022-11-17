package com.merttoptas.retrofittutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.merttoptas.retrofittutorial.data.model.PostDTO
import com.merttoptas.retrofittutorial.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater,container,false)

/*        val args = arguments
        val bundle: PostDTO? = args?.getParcelable("postBundle")

        binding.tvTitleValue.text = bundle?.title
        binding.tvBodyTitle.text = bundle?.body*/

        return binding.root
    }






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}