package com.android.e_commerce_app.ui.api

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

	@field:SerializedName("CategoryResponse")
	val categoryResponse: List<CategoryResponseItem?>? = null
)

data class CategoryResponseItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
