package com.pedrosoares.desafioconcrete.model

import com.pedrosoares.desafioconcrete.data.entity.RepositoryResponse
import io.reactivex.Observable

interface RepositoryModelContract {

    interface RepositoryUseCase {
        fun getRepository() :Observable<RepositoryResponse>
    }
}