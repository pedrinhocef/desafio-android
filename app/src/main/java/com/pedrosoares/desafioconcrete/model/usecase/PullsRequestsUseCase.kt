package com.pedrosoares.desafioconcrete.model.usecase

import com.pedrosoares.desafioconcrete.data.entity.pullrequests.PullsRequestsResponse
import com.pedrosoares.desafioconcrete.data.service.Api
import com.pedrosoares.desafioconcrete.data.service.Requester
import com.pedrosoares.desafioconcrete.model.PullsRequestsModelContract
import io.reactivex.Observable

class PullsRequestsUseCase : PullsRequestsModelContract.PullsRequestsUseCase {

    override fun getAllPullsRequests(creator: String, repository: String): Observable<List<PullsRequestsResponse>> {
        return Requester.service.create(Api::class.java).allPullsRequests(creator, repository)
    }

}