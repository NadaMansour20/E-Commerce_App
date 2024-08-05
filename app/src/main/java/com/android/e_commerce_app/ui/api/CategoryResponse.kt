package com.android.e_commerce_app.ui.api

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("request_id")
	val requestId: String? = null,

	@field:SerializedName("parameters")
	val parameters: Parameters? = null,

	@field:SerializedName("status")
	val status: String? = null
)
data class DataItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
