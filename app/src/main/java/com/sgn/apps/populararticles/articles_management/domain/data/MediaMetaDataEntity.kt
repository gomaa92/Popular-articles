package com.sgn.apps.populararticles.articles_management.domain.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MediaMetaDataEntity(
    @SerializedName("url") val url: String?,
    @SerializedName("format") val format: String?,
    @SerializedName("height") val height: Long?,
    @SerializedName("width") val width: Long?
) : Serializable