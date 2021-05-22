package com.xplora.challenge.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.xplora.challenge.MainActivity
import com.xplora.challenge.databinding.FragmentModuleListBinding
import com.xplora.challenge.network.Resource
import com.xplora.challenge.ui.adapter.ModuleListAdapter
import com.xplora.challenge.viewmodel.ModuleListViewModel

class ModuleListFragment : Fragment() {

    private lateinit var viewModel: ModuleListViewModel
    private var binding: FragmentModuleListBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModuleListViewModel::class.java)
        viewModel.callModulesAPI()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentModuleListBinding.inflate(inflater,container,false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getModuleList()?.observe(viewLifecycleOwner){ state ->

            when(state.status) {

                Resource.Status.LOADING -> {
                    binding?.progressLoader?.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {
                    binding?.progressLoader?.visibility = View.GONE
                    showSnackBar(state.message.toString())
                }
                Resource.Status.SUCCESS -> {
                    binding?.progressLoader?.visibility = View.GONE
                    binding?.rvModules?.adapter = ModuleListAdapter(state.data?.data?.modules){ modulesItem ->

                        val action = ModuleListFragmentDirections.actionFragmentModuleListToModuleDetailFragment(
                            modulesItem?.images?.en?.get(0)?.url,
                            modulesItem?.title?.en,
                            modulesItem?.content?.en
                        )
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }

    private fun showSnackBar(message: String) {
        binding?.root?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() }
    }
}