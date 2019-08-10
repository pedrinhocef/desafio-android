package com.pedrosoares.desafioconcrete.core.bases

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


abstract class BaseFragment<P : BaseContract.Presenter> : Fragment(),
    BaseContract.View<P> {

    private var presenter: P? = null

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