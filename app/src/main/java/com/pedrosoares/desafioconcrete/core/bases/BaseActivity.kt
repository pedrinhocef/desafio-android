package com.pedrosoares.desafioconcrete.core.bases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pedrosoares.desafioconcrete.core.helper.NetworkChangeReceiver
import com.pedrosoares.desafioconcrete.core.helper.NetworkChangeReceiver.Companion.networkChangeReceiver


abstract class BaseActivity<P : BaseContract.Presenter> : AppCompatActivity(), BaseContract.View<P>,
    NetworkChangeReceiver.ConnectionChangeCallback{

    protected var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkChangeReceiver(this)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter?.let { presenter!!.onAttach()}
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.let { presenter!!.onDetach()}
    }
}