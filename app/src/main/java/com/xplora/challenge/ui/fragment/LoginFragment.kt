package com.xplora.challenge.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.xplora.challenge.MainActivity
import com.xplora.challenge.databinding.FragmentLoginBinding
import com.xplora.challenge.helpers.Constants.AUTH_TOKEN
import com.xplora.challenge.helpers.Constants.IS_LOGIN
import com.xplora.challenge.helpers.DebugLog
import com.xplora.challenge.helpers.MyPreference
import com.xplora.challenge.network.Resource
import com.xplora.challenge.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private var binding: FragmentLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        setUpSnackBar()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLoginResponse()?.observe(viewLifecycleOwner) { state ->

            when(state.status) {

                Resource.Status.LOADING -> {
                    binding?.progressLoader?.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {
                    binding?.progressLoader?.visibility = View.GONE
                    showSnackBar(state.message.toString())
                }
                Resource.Status.SUCCESS -> {
                    MyPreference.setValueBoolean(IS_LOGIN, true)
                    MyPreference.setValueString(AUTH_TOKEN, state.data?.data?.user?.apiToken)
                    DebugLog.e(state.data?.data?.user?.apiToken.toString())
                    Handler(Looper.getMainLooper()).postDelayed({
                        binding?.progressLoader?.visibility = View.GONE
                        val action = LoginFragmentDirections.actionFragmentLoginToModuleListFragment()
                        findNavController().navigate(action)
                    },500)
                }
            }
        }
    }

    private fun setUpSnackBar(){

        viewModel.getSnakeBarMessage().observe(viewLifecycleOwner) { message ->

           showSnackBar(message = message.toString())
        }
    }

    private fun showSnackBar(message: String) {
        binding?.root?.let {Snackbar.make(it, message,Snackbar.LENGTH_SHORT).show() }
    }
}