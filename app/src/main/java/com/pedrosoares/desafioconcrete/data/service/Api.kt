package com.pedrosoares.desafioconcrete.data.service

import com.pedrosoares.desafioconcrete.data.entity.pullrequests.PullsRequestsResponse
import com.pedrosoares.desafioconcrete.data.entity.repository.RepositoryResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("search/repositories?q=language:Java&sort=stars&")
    fun allRepository(@Query("page") page: Int = 1): Observable<RepositoryResponse>

    @GET("repos/{criador}/{repositorio}/pulls")
    fun allPullsRequests(@Query("criador") creator: String,
                        @Query("repositorio") repository: String): Observable<List<PullsRequestsResponse>>
}