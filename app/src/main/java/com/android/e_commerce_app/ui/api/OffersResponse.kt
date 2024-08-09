//package com.android.e_commerce_app.ui.api
//
//import com.google.gson.annotations.SerializedName
//
//data class OffersResponse(
//
//	@field:SerializedName("data")
//	val data: Data? = null,
//
//	@field:SerializedName("request_id")
//	val requestId: String? = null,
//
//	@field:SerializedName("parameters")
//	val parameters: Parameters? = null,
//
//	@field:SerializedName("status")
//	val status: String? = null
//)
//
//data class CategoryPathItem(
//
//	@field:SerializedName("name")
//	val name: String? = null,
//
//	@field:SerializedName("link")
//	val link: String? = null,
//
//	@field:SerializedName("id")
//	val id: String? = null
//)
//
//data class Parameters(
//
//	@field:SerializedName("country")
//	val country: String? = null,
//
//	@field:SerializedName("limit")
//	val limit: Int? = null,
//
//	@field:SerializedName("asin")
//	val asin: String? = null,
//
//	@field:SerializedName("page")
//	val page: Int? = null
//)
//
//data class Data(
//
//	@field:SerializedName("country")
//	val country: String? = null,
//
//	@field:SerializedName("product_url")
//	val productUrl: String? = null,
//
//	@field:SerializedName("product_num_ratings")
//	val productNumRatings: Int? = null,
//
//	@field:SerializedName("customers_say")
//	val customersSay: String? = null,
//
//	@field:SerializedName("product_price")
//	val productPrice: Any? = null,
//
//	@field:SerializedName("product_information")
//	val productInformation: ProductInformation? = null,
//
//	@field:SerializedName("product_photo")
//	val productPhoto: String? = null,
//
//	@field:SerializedName("product_offers")
//	val productOffers: List<Any?>? = null,
//
//	@field:SerializedName("climate_pledge_friendly")
//	val climatePledgeFriendly: Boolean? = null,
//
//	@field:SerializedName("product_availability")
//	val productAvailability: String? = null,
//
//	@field:SerializedName("currency")
//	val currency: String? = null,
//
//	@field:SerializedName("product_photos")
//	val productPhotos: List<String?>? = null,
//
//	@field:SerializedName("product_description")
//	val productDescription: String? = null,
//
//	@field:SerializedName("is_best_seller")
//	val isBestSeller: Boolean? = null,
//
//	@field:SerializedName("sales_volume")
//	val salesVolume: Any? = null,
//
//	@field:SerializedName("product_star_rating")
//	val productStarRating: String? = null,
//
//	@field:SerializedName("product_title")
//	val productTitle: String? = null,
//
//	@field:SerializedName("is_prime")
//	val isPrime: Boolean? = null,
//
//	@field:SerializedName("product_num_offers")
//	val productNumOffers: Int? = null,
//
//	@field:SerializedName("category_path")
//	val categoryPath: List<CategoryPathItem?>? = null,
//
//	@field:SerializedName("product_variations")
//	val productVariations: List<Any?>? = null,
//
//	@field:SerializedName("asin")
//	val asin: String? = null,
//
//	@field:SerializedName("is_amazon_choice")
//	val isAmazonChoice: Boolean? = null,
//
//	@field:SerializedName("product_details")
//	val productDetails: ProductDetails? = null,
//
//	@field:SerializedName("about_product")
//	val aboutProduct: List<String?>? = null,
//
//	@field:SerializedName("product_original_price")
//	val productOriginalPrice: Any? = null
//)
//
//data class ProductDetails(
//
//	@field:SerializedName("Brand")
//	val brand: String? = null,
//
//	@field:SerializedName("Memory Storage Capacity")
//	val memoryStorageCapacity: String? = null,
//
//	@field:SerializedName("Wireless Carrier")
//	val wirelessCarrier: String? = null,
//
//	@field:SerializedName("Model Name")
//	val modelName: String? = null,
//
//	@field:SerializedName("Ram Memory Installed Size")
//	val ramMemoryInstalledSize: String? = null,
//
//	@field:SerializedName("Screen Size")
//	val screenSize: String? = null,
//
//	@field:SerializedName("CPU Model")
//	val cPUModel: String? = null,
//
//	@field:SerializedName("CPU Speed")
//	val cPUSpeed: String? = null,
//
//	@field:SerializedName("Operating System")
//	val operatingSystem: String? = null,
//
//	@field:SerializedName("Resolution")
//	val resolution: String? = null
//)
//
//data class ProductInformation(
//
//	@field:SerializedName("Battery Power Rating")
//	val batteryPowerRating: String? = null,
//
//	@field:SerializedName("Date First Available")
//	val dateFirstAvailable: String? = null,
//
//	@field:SerializedName("Ram Memory Installed Size")
//	val ramMemoryInstalledSize: String? = null,
//
//	@field:SerializedName("ASIN")
//	val aSIN: String? = null,
//
//	@field:SerializedName("Audio Jack")
//	val audioJack: String? = null,
//
//	@field:SerializedName("Whats in the box")
//	val whatsInTheBox: String? = null,
//
//	@field:SerializedName("Batteries")
//	val batteries: String? = null,
//
//	@field:SerializedName("GPS")
//	val gPS: String? = null,
//
//	@field:SerializedName("Product Dimensions")
//	val productDimensions: String? = null,
//
//	@field:SerializedName("Form Factor")
//	val formFactor: String? = null,
//
//	@field:SerializedName("Special features")
//	val specialFeatures: String? = null,
//
//	@field:SerializedName("Manufacturer")
//	val manufacturer: String? = null,
//
//	@field:SerializedName("Scanner Resolution")
//	val scannerResolution: String? = null,
//
//	@field:SerializedName("Standing screen display size")
//	val standingScreenDisplaySize: String? = null,
//
//	@field:SerializedName("OS")
//	val oS: String? = null,
//
//	@field:SerializedName("Color")
//	val color: String? = null,
//
//	@field:SerializedName("Item model number")
//	val itemModelNumber: String? = null,
//
//	@field:SerializedName("Weight")
//	val weight: String? = null,
//
//	@field:SerializedName("Human Interface Input")
//	val humanInterfaceInput: String? = null,
//
//	@field:SerializedName("Memory Storage Capacity")
//	val memoryStorageCapacity: String? = null,
//
//	@field:SerializedName("Other camera features")
//	val otherCameraFeatures: String? = null,
//
//	@field:SerializedName("Battery Capacity")
//	val batteryCapacity: String? = null,
//
//	@field:SerializedName("Connectivity technologies")
//	val connectivityTechnologies: String? = null,
//
//	@field:SerializedName("Wireless communication technologies")
//	val wirelessCommunicationTechnologies: String? = null,
//
//	@field:SerializedName("Other display features")
//	val otherDisplayFeatures: String? = null,
//
//	@field:SerializedName("Item Weight")
//	val itemWeight: String? = null,
//
//	@field:SerializedName("RAM")
//	val rAM: String? = null
//)
