package com.sgn.apps.populararticles.articles_management.domain.data

import com.google.gson.annotations.SerializedName

data class ListArticlesResponse(
    @SerializedName("status") val status: String?,
    @SerializedName("copyright") val copyright: String?,
    @SerializedName("num_results") val numResults: Long?,
    @SerializedName("results") val results: List<ResultsEntity>?
)