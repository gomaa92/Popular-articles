package com.sgn.apps.populararticles.articles_management.domain.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MediaEntity(
    @SerializedName("type") val type: String?,
    @SerializedName("subtype") val subtype: String?,
    @SerializedName("caption") val caption: String?,
    @SerializedName("copyright") val copyright: String?,
    @SerializedName("approved_for_syndication") val approvedForSyndication: Long?,
    @SerializedName("media-metadata") val mediaMetaData: List<MediaMetaDataEntity?>?
) : Serializable