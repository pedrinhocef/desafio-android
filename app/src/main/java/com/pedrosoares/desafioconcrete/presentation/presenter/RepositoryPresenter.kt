package com.pedrosoares.desafioconcrete.presentation.presenter

import com.pedrosoares.desafioconcrete.core.bases.BasePresenter
import com.pedrosoares.desafioconcrete.model.usecase.RepositoryUseCase
import com.pedrosoares.desafioconcrete.presentation.RepositoryPresentationContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryPresenter(private val view: RepositoryPresentationContract.RepositoryListView) : BasePresenter(),
    RepositoryPresentationContract.RepositoryListPresenter {

    private val repositoryUseCase = RepositoryUseCase()


    override fun fetchRepository(page: Int) {
        val disposable = repositoryUseCase.getRepository(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.items.let { items ->
                    if(items.isNotEmpty()) {
                        view.populateRepository(items)
                        view.success()
                    } else {
                        view.error()
                    }
                }
            },
                { view.error() })
        compositeDisposable!!.add(disposable)
    }


}