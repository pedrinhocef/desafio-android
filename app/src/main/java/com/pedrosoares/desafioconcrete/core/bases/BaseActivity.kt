package com.pedrosoares.desafioconcrete.core.bases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity<P : BaseContract.Presenter> : AppCompatActivity(), BaseContract.View<P> {

    protected var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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