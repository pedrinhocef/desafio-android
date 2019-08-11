package com.pedrosoares.desafioconcrete.presentation

import com.pedrosoares.desafioconcrete.core.bases.BaseContract
import com.pedrosoares.desafioconcrete.data.entity.pullrequests.PullsRequestsResponse

interface PullsRequestsPresentationContract {

    interface PullsRequestsListView {
        fun populatePullsRequests(itemList: List<PullsRequestsResponse>)
        fun success()
        fun loading()
        fun error()
    }

    interface PullsRequestsPresenter : BaseContract.Presenter {
        fun fetchPullsRequests(creator: String, repository: String)
    }
}