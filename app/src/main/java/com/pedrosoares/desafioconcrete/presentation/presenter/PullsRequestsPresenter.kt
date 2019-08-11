package com.pedrosoares.desafioconcrete.presentation.presenter

import com.pedrosoares.desafioconcrete.core.bases.BasePresenter
import com.pedrosoares.desafioconcrete.model.usecase.PullsRequestsUseCase
import com.pedrosoares.desafioconcrete.presentation.PullsRequestsPresentationContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PullsRequestsPresenter(private val view: PullsRequestsPresentationContract.PullsRequestsListView) : BasePresenter(),
    PullsRequestsPresentationContract.PullsRequestsPresenter {

    private val pullsRequestsUseCase = PullsRequestsUseCase()

    override fun fetchPullsRequests(creator: String, repository: String) {
        view.loading()
        val disposable = pullsRequestsUseCase.getAllPullsRequests(creator, repository)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    view.populatePullsRequests(it)
                    view.success()
                }
            },
                { view.error() })
        compositeDisposable!!.add(disposable)
    }
}
