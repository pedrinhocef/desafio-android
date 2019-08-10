package com.pedrosoares.desafioconcrete.model.mapper

import com.pedrosoares.desafioconcrete.data.entity.RepositoryResponse
import com.pedrosoares.desafioconcrete.model.domain.RepositoryDomain

object RepositoryMapper {

    fun transformEntityToDomain(repositoryResponse: RepositoryResponse) : RepositoryDomain {
       return RepositoryDomain()
    }

}
