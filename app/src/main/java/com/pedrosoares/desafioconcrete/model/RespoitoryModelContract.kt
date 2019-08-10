package com.pedrosoares.desafioconcrete.model

import com.pedrosoares.desafioconcrete.model.domain.RepositoryDomain
import io.reactivex.Observable

interface RepositoryModelContract {

    interface RepositoryUseCase {
        fun getRepository() :Observable<RepositoryDomain>
    }
}