package com.pedrosoares.desafioconcrete.core.bases

interface BaseContract {

    interface View<P : Presenter> {
        fun createPresenter(): P
    }

    interface Presenter {
        fun onDetach()
        fun onAttach()
    }
}