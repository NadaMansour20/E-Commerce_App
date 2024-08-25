package com.android.e_commerce_app.ui.api

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ProductResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)


@Entity
data class ProductsItem(


	@ColumnInfo
	val favOrNot:Boolean?=null,

	@ColumnInfo
	val addNumber:Int=1,

	@ColumnInfo
	val addToCart:Boolean?=null,

//	@ColumnInfo
//	@field:SerializedName("images")
//	val images: List<String?>? = null,

	@ColumnInfo
	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

//	@ColumnInfo
//	@field:SerializedName("minimumOrderQuantity")
//	val minimumOrderQuantity: Int? = null,
//
	@ColumnInfo
	@field:SerializedName("rating")
	val rating: Float? = null,
//
//	@ColumnInfo
//	@field:SerializedName("returnPolicy")
//	val returnPolicy: String? = null,

	@ColumnInfo
	@field:SerializedName("description")
	val description: String? = null,
//
//	@ColumnInfo
//	@field:SerializedName("weight")
//	val weight: Int? = null,
//
//	@ColumnInfo
//	@field:SerializedName("warrantyInformation")
//	val warrantyInformation: String? = null,

	@ColumnInfo
	@field:SerializedName("title")
	val title: String? = null,

//	@ColumnInfo
//	@field:SerializedName("tags")
//	val tags: List<String?>? = null,
//
//	@ColumnInfo
//	@field:SerializedName("discountPercentage")
//	val discountPercentage: Any? = null,
//
//	@ColumnInfo
//	@field:SerializedName("reviews")
//	val reviews: List<ReviewsItem?>? = null,

	@ColumnInfo
	@field:SerializedName("price")
	val price:Double? = null,

//	@ColumnInfo
//	@field:SerializedName("meta")
//	val meta: Meta? = null,
//
//	@ColumnInfo
//	@field:SerializedName("shippingInformation")
//	val shippingInformation: String? = null,

	@ColumnInfo
	@PrimaryKey
	@field:SerializedName("id")
	val id: Int,

//	@ColumnInfo
//	@field:SerializedName("availabilityStatus")
//	val availabilityStatus: String? = null,
//
//	@ColumnInfo
//	@field:SerializedName("category")
//	val category: String? = null,
//
	@ColumnInfo
	@field:SerializedName("stock")
	val stock: Int? = null,
//
//	@ColumnInfo
//	@field:SerializedName("sku")
//	val sku: String? = null,
//
//	@ColumnInfo
//	@field:SerializedName("brand")
//	val brand: String? = null,
//
//	@ColumnInfo
//	@field:SerializedName("dimensions")
//	val dimensions: Dimensions? = null


	@ColumnInfo // This is the foreign key
	val foreign_key: Int?=null
):Serializable

data class Dimensions(

	@field:SerializedName("depth")
	val depth: Any? = null,

	@field:SerializedName("width")
	val width: Any? = null,

	@field:SerializedName("height")
	val height: Any? = null
)

data class Meta(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("qrCode")
	val qrCode: String? = null,

	@field:SerializedName("barcode")
	val barcode: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class ReviewsItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("reviewerName")
	val reviewerName: String? = null,

	@field:SerializedName("reviewerEmail")
	val reviewerEmail: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("comment")
	val comment: String? = null
)
