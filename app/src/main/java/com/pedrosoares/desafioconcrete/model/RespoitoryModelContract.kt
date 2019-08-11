package com.pedrosoares.desafioconcrete.model

import com.pedrosoares.desafioconcrete.data.entity.repository.RepositoryResponse
import io.reactivex.Observable

interface RepositoryModelContract {

    interface RepositoryUseCase {
        fun getRepository(page: Int = 1) :Observable<RepositoryResponse>
    }
}