package com.android.e_commerce_app.ui.api

import com.google.gson.annotations.SerializedName

data class ProductResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("request_id")
	val requestId: String? = null,

	@field:SerializedName("parameters")
	val parameters: Parameters? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class ProductsItem(

	@field:SerializedName("delivery")
	val delivery: String? = null,

	@field:SerializedName("product_star_rating")
	val productStarRating: String? = null,

	@field:SerializedName("product_minimum_offer_price")
	val productMinimumOfferPrice: String? = null,

	@field:SerializedName("product_url")
	val productUrl: String? = null,

	@field:SerializedName("has_variations")
	val hasVariations: Boolean? = null,

	@field:SerializedName("product_num_ratings")
	val productNumRatings: Int? = null,

	@field:SerializedName("product_price")
	val productPrice: String? = null,

	@field:SerializedName("product_title")
	val productTitle: String? = null,

	@field:SerializedName("is_prime")
	val isPrime: Boolean? = null,

	@field:SerializedName("product_photo")
	val productPhoto: String? = null,

	@field:SerializedName("product_num_offers")
	val productNumOffers: Int? = null,

	@field:SerializedName("climate_pledge_friendly")
	val climatePledgeFriendly: Boolean? = null,

	@field:SerializedName("asin")
	val asin: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("is_amazon_choice")
	val isAmazonChoice: Boolean? = null,

	@field:SerializedName("product_original_price")
	val productOriginalPrice: String? = null,

	@field:SerializedName("is_best_seller")
	val isBestSeller: Boolean? = null,

	@field:SerializedName("sales_volume")
	val salesVolume: String? = null,

	@field:SerializedName("unit_price")
	val unitPrice: String? = null,

	@field:SerializedName("unit_count")
	val unitCount: Int? = null
)

data class Parameters(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("max_price")
	val maxPrice: Int? = null,

	@field:SerializedName("category_id")
	val categoryId: String? = null,

	@field:SerializedName("min_price")
	val minPrice: Int? = null,

	@field:SerializedName("sort_by")
	val sortBy: String? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("brand")
	val brand: List<String?>? = null
)

data class Data(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("domain")
	val domain: String? = null,

	@field:SerializedName("total_products")
	val totalProducts: Int? = null,

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)
