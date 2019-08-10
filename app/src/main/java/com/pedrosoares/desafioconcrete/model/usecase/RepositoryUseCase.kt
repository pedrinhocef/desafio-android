package com.pedrosoares.desafioconcrete.model.usecase

import com.pedrosoares.desafioconcrete.data.entity.RepositoryResponse
import com.pedrosoares.desafioconcrete.data.service.Api
import com.pedrosoares.desafioconcrete.data.service.Requester
import com.pedrosoares.desafioconcrete.model.RepositoryModelContract
import io.reactivex.Observable

class RepositoryUseCase : RepositoryModelContract.RepositoryUseCase {

    override fun getRepository(): Observable<RepositoryResponse> {
        return Requester.service.create(Api::class.java).allRepository
    }
}