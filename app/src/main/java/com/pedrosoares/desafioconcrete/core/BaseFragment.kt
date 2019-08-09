package com.pedrosoares.desafioconcrete.core

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


abstract class BaseFragment<P : BaseContract.Presenter> : Fragment(), BaseContract.View<P> {

    protected var presenter: P? = null

    val isConnected: Boolean
        get() {
            val connected: Boolean

            context?.let {
                val connectivityManager = it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                connected =
                    connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
                return connected
            }
            return false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.let { presenter!!.onAttach() }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter?.let { presenter!!.onDetach() }

    }
}