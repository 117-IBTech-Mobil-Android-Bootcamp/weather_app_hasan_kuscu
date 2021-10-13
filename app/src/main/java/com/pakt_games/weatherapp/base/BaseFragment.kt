package com.pakt_games.weatherapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.pakt_games.weatherapp.utils.showToast

abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment(), FragmentActions {

    abstract val viewModel: VM
    protected lateinit var dataBinding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)
        injectKoin()
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        showToast(shouldCheckInternetConnection().toString())
    }
    abstract fun getLayoutID(): Int
    abstract fun observeLiveData()
    abstract fun injectKoin()
    override fun shouldCheckInternetConnection() = true
}