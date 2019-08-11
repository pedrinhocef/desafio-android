package com.pedrosoares.desafioconcrete.data.entity.repository

import com.google.gson.annotations.SerializedName
import com.pedrosoares.desafioconcrete.data.entity.repository.Items

data class RepositoryResponse(
	val totalCount: Int? = null,
	val incompleteResults: Boolean? = null,
	@SerializedName("items")
	val items: List<Items>
)
