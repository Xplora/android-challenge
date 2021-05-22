package com.xplora.challenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.xplora.challenge.MainActivity
import com.xplora.challenge.databinding.FragmentModuleDetailBinding
import com.xplora.challenge.viewmodel.ModuleDetailViewModel

class ModuleDetailFragment : Fragment() {

    private val args: ModuleDetailFragmentArgs by navArgs()
    private lateinit var viewModel: ModuleDetailViewModel
    private var binding: FragmentModuleDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModuleDetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentModuleDetailBinding.inflate(inflater, container, false)
        binding?.imageUrl = args.imageUrl
        binding?.title = args.title
        binding?.description = args.description
        binding?.imgBack?.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding?.root
    }
}