package com.pedrosoares.desafioconcrete.presentation

import com.pedrosoares.desafioconcrete.core.bases.BaseContract
import com.pedrosoares.desafioconcrete.data.entity.Items

interface RepositoryPresentationContract {

    interface RepositoryListView {
        fun populateRepository(itemList: List<Items>)
        fun success()
        fun loading()
        fun error()
    }

    interface RepositoryListPresenter : BaseContract.Presenter {
        fun fetchRepository()
    }
}