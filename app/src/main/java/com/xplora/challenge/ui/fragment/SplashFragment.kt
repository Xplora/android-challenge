package com.xplora.challenge.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.xplora.challenge.databinding.FragmentSplashBinding
import com.xplora.challenge.helpers.MyPreference

class SplashFragment : Fragment() {

    private var binding: FragmentSplashBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({

            when(MyPreference.isLogin()){

                true -> {
                    val action = SplashFragmentDirections.actionFragmentSplashToModuleListFragment()
                    findNavController().navigate(action)
                }

                false -> {
                    val action = SplashFragmentDirections.actionFragmentSplashToFragmentLogin()
                    findNavController().navigate(action)
                }
            }
        }, 3000)

        return binding?.root
    }
}