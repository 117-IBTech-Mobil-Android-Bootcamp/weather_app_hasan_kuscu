package com.pakt_games.weatherapp.base

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.pakt_games.weatherapp.components.ConnectionLiveData
import com.pakt_games.weatherapp.utils.showToast

abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment(), FragmentActions {

    abstract val viewModel: VM
    protected lateinit var dataBinding: DB
    private lateinit var checkInternetConnetion : ConnectionLiveData


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)
        actionEvents()

        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
    }
    abstract fun getLayoutID(): Int
    abstract fun observeLiveData()
    abstract fun actionEvents()
    override fun shouldCheckInternetConnection() {

    }
}