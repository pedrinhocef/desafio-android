package com.pedrosoares.desafioconcrete.data.entity

data class RepositoryResponse(
	val totalCount: Int? = null,
	val incompleteResults: Boolean? = null,
	val items: List<ItemsItem?>? = null
)
