package com.pedrosoares.desafioconcrete.data.service

import com.pedrosoares.desafioconcrete.data.entity.RepositoryResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface Api {
    @get:GET("repositories?q=language:Java&sort=stars&page=1")
    val allRepository: Observable<RepositoryResponse>
}