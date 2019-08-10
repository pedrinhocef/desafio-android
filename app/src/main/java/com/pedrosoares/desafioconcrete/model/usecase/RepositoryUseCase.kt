package com.pedrosoares.desafioconcrete.model.usecase

import com.pedrosoares.desafioconcrete.data.entity.RepositoryResponse
import com.pedrosoares.desafioconcrete.data.service.Api
import com.pedrosoares.desafioconcrete.data.service.Requester
import com.pedrosoares.desafioconcrete.model.RepositoryModelContract
import com.pedrosoares.desafioconcrete.model.domain.RepositoryDomain
import com.pedrosoares.desafioconcrete.model.mapper.RepositoryMapper
import io.reactivex.Observable

class CurrencyUseCase : RepositoryModelContract.RepositoryUseCase {

    override fun getRepository(): Observable<RepositoryDomain> {
        val observable : Observable<RepositoryResponse> = Requester.service.create(Api::class.java).allRepository
        return observable.map { RepositoryMapper.transformEntityToDomain(it) }
    }
}