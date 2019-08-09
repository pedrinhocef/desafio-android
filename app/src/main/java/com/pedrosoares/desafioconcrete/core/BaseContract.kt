package com.pedrosoares.desafioconcrete.core

interface BaseContract {

    interface View<P : BaseContract.Presenter> {
        fun createPresenter(): P
    }

    interface Presenter {
        fun onDetach()
        fun onAttach()
    }
}