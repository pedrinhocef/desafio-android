package com.pedrosoares.desafioconcrete.data.entity.repository

import com.google.gson.annotations.SerializedName

data class Owner(
	val gistsUrl: String? = null,
	val reposUrl: String? = null,
	val followingUrl: String? = null,
	val starredUrl: String? = null,
	@SerializedName("login")
	val login: String,
	val followersUrl: String? = null,
	val type: String? = null,
	val url: String? = null,
	val subscriptionsUrl: String? = null,
	val receivedEventsUrl: String? = null,
	@SerializedName("avatar_url")
	val avatarUrl: String,
	val eventsUrl: String? = null,
	val htmlUrl: String? = null,
	val siteAdmin: Boolean? = null,
	val id: Int? = null,
	val gravatarId: String? = null,
	val nodeId: String? = null,
	val organizationsUrl: String? = null
)
