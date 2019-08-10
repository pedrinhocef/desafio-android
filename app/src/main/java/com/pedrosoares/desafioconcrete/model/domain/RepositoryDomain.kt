package com.pedrosoares.desafioconcrete.model.domain

data class RepositoryDomain(
	val totalCount: Int? = null,
	val incompleteResults: Boolean? = null,
	val items: List<ItemsItem?>? = null
)
