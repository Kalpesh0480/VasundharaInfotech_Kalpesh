package com.example.vasundharainfotech.model


import com.google.gson.annotations.SerializedName

data class GetDataDetails(
    @SerializedName("app_center")
    val appCenter: List<AppCenter>,
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("home")
    val home: List<Home>,
    @SerializedName("message")
    val message: String,
    @SerializedName("more_apps")
    val moreApps: List<MoreApp>,
    @SerializedName("native_add")
    val nativeAdd: NativeAdd,
    @SerializedName("status")
    val status: Int,
    @SerializedName("translator_ads_id")
    val translatorAdsId: TranslatorAdsId
) {
    data class AppCenter(
        @SerializedName("catgeory")
        val catgeory: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_active")
        val isActive: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("position")
        val position: Int,
        @SerializedName("sub_category")
        val subCategory: List<SubCategory>
    ) {
        data class SubCategory(
            @SerializedName("app_id")
            val appId: Int,
            @SerializedName("app_link")
            val appLink: String,
            @SerializedName("banner")
            val banner: String,
            @SerializedName("banner_image")
            val bannerImage: String,
            @SerializedName("icon")
            val icon: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_active")
            val imageActive: Int,
            @SerializedName("installed_range")
            val installedRange: String,
            @SerializedName("is_active")
            val isActive: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("position")
            val position: Int,
            @SerializedName("star")
            val star: String
        )
    }

    data class Data(
        @SerializedName("app_id")
        val appId: Int,
        @SerializedName("app_link")
        val appLink: String,
        @SerializedName("full_thumb_image")
        val fullThumbImage: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("package_name")
        val packageName: String,
        @SerializedName("position")
        val position: Int,
        @SerializedName("splash_active")
        val splashActive: Int,
        @SerializedName("thumb_image")
        val thumbImage: String
    )

    data class Home(
        @SerializedName("catgeory")
        val catgeory: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_active")
        val isActive: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("position")
        val position: Int,
        @SerializedName("sub_category")
        val subCategory: List<SubCategory>
    ) {
        data class SubCategory(
            @SerializedName("app_id")
            val appId: Int,
            @SerializedName("app_link")
            val appLink: String,
            @SerializedName("banner")
            val banner: String,
            @SerializedName("banner_image")
            val bannerImage: String,
            @SerializedName("icon")
            val icon: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_active")
            val imageActive: Int,
            @SerializedName("installed_range")
            val installedRange: String,
            @SerializedName("is_active")
            val isActive: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("position")
            val position: Int,
            @SerializedName("star")
            val star: String
        )
    }

    data class MoreApp(
        @SerializedName("catgeory")
        val catgeory: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_active")
        val isActive: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("position")
        val position: Int,
        @SerializedName("sub_category")
        val subCategory: List<SubCategory>
    ) {
        data class SubCategory(
            @SerializedName("app_id")
            val appId: Int,
            @SerializedName("app_link")
            val appLink: String,
            @SerializedName("banner")
            val banner: String,
            @SerializedName("icon")
            val icon: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_active")
            val imageActive: Int,
            @SerializedName("installed_range")
            val installedRange: String,
            @SerializedName("is_active")
            val isActive: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("position")
            val position: Int,
            @SerializedName("star")
            val star: String
        )
    }

    data class NativeAdd(
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("image_active")
        val imageActive: Int,
        @SerializedName("is_active")
        val isActive: Int,
        @SerializedName("package_name")
        val packageName: String,
        @SerializedName("playstore_link")
        val playstoreLink: String,
        @SerializedName("position")
        val position: Int
    )

    data class TranslatorAdsId(
        @SerializedName("banner")
        val banner: String,
        @SerializedName("interstitial")
        val interstitial: String
    )
}