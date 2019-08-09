package com.pedrosoares.desafioconcrete.core

import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter : BaseContract.Presenter {

    protected var compositeDisposable: CompositeDisposable? = null

    override fun onAttach() {
        compositeDisposable = CompositeDisposable()
    }

    override fun onDetach() {
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }
    }
}